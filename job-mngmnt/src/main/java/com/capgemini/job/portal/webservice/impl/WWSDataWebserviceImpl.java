/**
 * 
 */
package com.capgemini.job.portal.webservice.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import javax.activation.DataHandler;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.capgemini.job.portal.entities.Billability;
import com.capgemini.job.portal.entities.Client;
import com.capgemini.job.portal.entities.ClosedNeed;
import com.capgemini.job.portal.entities.Grade;
import com.capgemini.job.portal.entities.Location;
import com.capgemini.job.portal.entities.NeedCloseReason;
import com.capgemini.job.portal.entities.NeedComment;
import com.capgemini.job.portal.entities.OpenNeed;
import com.capgemini.job.portal.entities.Practice;
import com.capgemini.job.portal.entities.Role;
import com.capgemini.job.portal.entities.Skill;
import com.capgemini.job.portal.entities.SkillProfile;
import com.capgemini.job.portal.jaxb.NeedCommentJAXB;
import com.capgemini.job.portal.jaxb.NeedSearchJAXB;
import com.capgemini.job.portal.jaxb.SkillProfileJAXB;
import com.capgemini.job.portal.service.WWSDataService;
import com.capgemini.job.portal.webservice.WWSDataWebservice;
import com.capgemini.wws.filefeed.ExcelReader;
import com.capgemini.wws.filefeed.WWSFileDataHelper;
import com.capgemini.wws.filefeed.WWSMasterDataProcessor;
import com.capgemini.wws.util.WWSUtil;
import com.capgemini.wws.vo.NeedVO;
import com.capgemini.wws.vo.WWSFileVO;

/**
 * @author sryarlag
 *
 */
@CrossOriginResourceSharing(allowAllOrigins = true)
@Component("wwsDataWebservice")
public class WWSDataWebserviceImpl implements WWSDataWebservice {

	public ExcelReader excelReader;
	
	@Autowired
	private WWSDataService wwsDataService;
	
	public WWSDataWebserviceImpl() {
		excelReader = new ExcelReader();
	}
	
	@Override
	@POST
	@Path("/{need-file-type}/{data-sheet-name}")
	@Produces("application/json")
	@Consumes("multipart/form-data")
	public Response loadNeedsFile(@PathParam("need-file-type") String needsFileType,
			@Multipart("file") Attachment attachment, @PathParam("data-sheet-name") final String dataSheetName) throws Exception {
		DataHandler dataHandler1 =attachment.getDataHandler();
		InputStream fileStream = dataHandler1.getInputStream();
	    //byte[] contents = IOUtils.toByteArray(fileStream);
	    
	    String fileName = attachment.getContentDisposition().getParameter("filename"); // (java.lang.String) Ops Fulfillment  Tracker_05022016.xlsx
	    //attachment.getContentType().getSubtype();  (java.lang.String) vnd.openxmlformats-officedocument.spreadsheetml.sheet
	    //attachment.getContentType().getType();  (java.lang.String) application
	    if (!fileName.endsWith("xlsx")) {
	    	return Response.status(Response.Status.PRECONDITION_FAILED).entity("Only xlsx files please !!! You sent \""+fileName+"\"").build();
	    }
	    
	    Map<String, Map<Long, String>> sheetData = excelReader.getSheetData(fileName, dataSheetName, fileStream);
	    
	    if (null == sheetData || sheetData.size() == 0) {
	    	return Response.status(Response.Status.BAD_REQUEST).entity("No Content Found in  \""+fileName+"\". Could be some error in file processing.").build();
	    }
	    
	    WWSFileVO vo = new WWSFileVO();
	    vo.setFileName(fileName);
	    vo.setSheetName(dataSheetName);
	    vo.setNeedFileType(needsFileType);
	    vo.setDebugMesg(new StringBuilder("Submitted File '"+fileName+"' as "+needsFileType +" Needs File..."));
	    vo.setNoOfColumns(sheetData.keySet().size());
	    Map.Entry<String, Map<Long, String>> firstEntry=sheetData.entrySet().iterator().next();
	    vo.setNoOfRows(firstEntry.getValue().keySet().size());
	    //vo.setSheetData(sheetData); //Don't enable this until really necessary
	    
	    
	    
	    WWSFileDataHelper helper = new WWSFileDataHelper();
	    if ("Open".equalsIgnoreCase(needsFileType)) {
	    	List<OpenNeed> recordsToPersist = helper.getOpenNeedRecords(sheetData);
		    wwsDataService.persistOpenNeeds(recordsToPersist);
		    vo.setConsideredRecords(recordsToPersist.size());
		    
		    WWSMasterDataProcessor mdp = new WWSMasterDataProcessor(recordsToPersist, needsFileType, wwsDataService);
		    Thread thread = new Thread(mdp);
		    thread.start();
		    
	    } else if ("Closed".equalsIgnoreCase(needsFileType)) {
	    	//Persisting closed need info and open need info. Closed need file also contains the open need information. Closed need info is extra in this file.
	    	List<OpenNeed> openNeedDataToPersist = helper.getOpenNeedRecords(sheetData);
	    	wwsDataService.persistOpenNeeds(openNeedDataToPersist);
	    	
	    	WWSMasterDataProcessor openNeedDataProcessor = new WWSMasterDataProcessor(openNeedDataToPersist, "Open", wwsDataService);
		    Thread openNeedProcessorThread = new Thread(openNeedDataProcessor);
		    openNeedProcessorThread.start();
	    	
	    	
	    	List<ClosedNeed> recordsToPersist = helper.getClosedNeedRecords(sheetData);
	    	wwsDataService.persistClosedNeeds(recordsToPersist);
	    	vo.setConsideredRecords(recordsToPersist.size());
	    	
	    	WWSMasterDataProcessor mdp = new WWSMasterDataProcessor(needsFileType, recordsToPersist, wwsDataService);
		    Thread thread = new Thread(mdp);
		    thread.start();
		    
	    } else {
	    	return Response.status(Response.Status.BAD_REQUEST).entity("Need file type can be either Open or Closed").build();
	    }
	    
	    
		return Response.ok(vo).build();
	}

	@Override
	@GET
	@Path("/clients")
	@Produces("application/json")
	public Response getClients() throws Exception {
		Map<String, Client> cMap = wwsDataService.getClients();
		List<Client> clients = new ArrayList<Client>();
		clients.addAll(cMap.values());
		return Response.ok(clients).build();
	}

	@Override
	@GET
	@Path("/locations")
	@Produces("application/json")
	public Response getLocations() throws Exception {
		Map<String, Location> locMap = wwsDataService.getLocations();
		List<Location> locations = new ArrayList<Location>();
		locations.addAll(locMap.values());
		return Response.ok(locations).build();
	}

	@Override
	@GET
	@Path("/practices")
	@Produces("application/json")
	public Response getPractices() throws Exception {
		Map<String, Practice> pMap = wwsDataService.getPractices();
		List<Practice> practices = new ArrayList<Practice>();
		practices.addAll(pMap.values());
		return Response.ok(practices).build();
	}

	@Override
	@GET
	@Path("/project-types")
	@Produces("application/json")
	public Response getProjectTypes() throws Exception {
		Map<String, Billability> ptMap = wwsDataService.getBillabilityTypes();
		List<Billability> projTypes = new ArrayList<Billability>();
		projTypes.addAll(ptMap.values());
		return Response.ok(projTypes).build();
	}

	@Override
	@GET
	@Path("/close-reasons")
	@Produces("application/json")
	public Response getCloseReasons() throws Exception {
		Map<String, NeedCloseReason> ncrMap = wwsDataService.getNeedCloseReasons();
		List<NeedCloseReason> closeReasons = new ArrayList<NeedCloseReason>();
		closeReasons.addAll(ncrMap.values());
		return Response.ok(closeReasons).build();
	}
	
	@Override
	@GET
	@Path("/grades")
	@Produces("application/json")
	public Response getGrades() throws Exception {
		Map<String, Grade> gradesMap = wwsDataService.getGrades();
		List<Grade> grades = new ArrayList<Grade>();
		grades.addAll(gradesMap.values());
		return Response.ok(grades).build();
	}
	
	@Override
	@GET
	@Path("/skills")
	@Produces("application/json")
	public Response getSkills() throws Exception {
		List<Skill> skills = wwsDataService.getSkills();
		return Response.ok(skills).build();
	}

	@Override
	@GET
	@Path("/roles")
	@Produces("application/json")
	public Response getroles() throws Exception {
		List<Role> roles = wwsDataService.getRoles();
		return Response.ok(roles).build();
	}


	@Override
	@GET
	@Path("/no-skill-profile-needs")
	@Produces("application/json")
	public Response getNeedsRequiringSkillProfile() {
		List<NeedVO> needs = wwsDataService.getNeedsWithNoSkillProfile();
		return Response.ok(needs).build();
	}

	@Override
	@GET
	@Path("/need-details/{wwsId}")
	@Produces("application/json")
	public Response getNeedDetails(@PathParam("wwsId") String wwsId) {
		OpenNeed openNeed = wwsDataService.getNeedDetails(new Integer(wwsId));
		return Response.ok(openNeed).build();
	}

	@Override
	@POST
	@Consumes("application/json")
	@Path("/update-skill-profile/{wwsId}")
	public Response updateSkillProfileOfNeed(@PathParam("wwsId") String wwsId, @RequestBody SkillProfileJAXB skillProfJaxb) {
		SkillProfile skillProfile = new SkillProfile();
		Skill skill = new Skill();
		Role role = new Role();
		//One role will have multiple role_names, so consider the role id associated to role_names
		/*if (!WWSUtil.nullOrEmpty(skillProfJaxb.getRoleNmRoleId())) {
			role.setRoleId(new Integer(skillProfJaxb.getRoleRoleId()));
			if (!WWSUtil.nullOrEmpty(skillProfJaxb.getRole())) {
				role.setRole(skillProfJaxb.getRole());
			}
		} else if(!WWSUtil.nullOrEmpty(skillProfJaxb.getRole()) && !WWSUtil.nullOrEmpty(skillProfJaxb.getRoleName())) {
			role.setRoleName(skillProfJaxb.getRoleName());
			role.setRole(skillProfJaxb.getRole());
		} else {
			return Response.status(Response.Status.BAD_REQUEST).entity("Either choose an existing Role and Role Name combination or Define a new combination..").build();
		}
		
		//One SkillCategory will have multiple combinations of skills. Hence considering the skillId associated to kill
		if (!WWSUtil.nullOrEmpty(skillProfJaxb.getSkillsSkillId())) {
			skill.setSkillId(new Integer(skillProfJaxb.getSkillsSkillId()));
			if (!WWSUtil.nullOrEmpty(skillProfJaxb.getSkillCategory())) {
				skill.setSkillCategory(skillProfJaxb.getSkillCategory());
			}
		} else if (!WWSUtil.nullOrEmpty(skillProfJaxb.getSkillCategory()) && !WWSUtil.nullOrEmpty(skillProfJaxb.getSkill())) {
			skill.setSkill(skillProfJaxb.getSkill());
			skill.setSkillCategory(skillProfJaxb.getSkillCategory());
		} else {
			return Response.status(Response.Status.BAD_REQUEST).entity("Either choose an existing Skill Category and Core Skills combination or Define a new combination..").build();
		}*/
		
		if ((null == skillProfJaxb.getDefineNewSkill() || "false".equalsIgnoreCase(skillProfJaxb.getDefineNewSkill())) && !WWSUtil.nullOrEmpty(skillProfJaxb.getExistingSkillId())) {
			//Existing skill
			skill.setSkillId(new Integer(skillProfJaxb.getExistingSkillId()));
		} else if (!WWSUtil.nullOrEmpty(skillProfJaxb.getSkillCategory()) && !WWSUtil.nullOrEmpty(skillProfJaxb.getSkill())) {
			//New Skill
			skill.setSkill(skillProfJaxb.getSkill());
			skill.setSkillCategory(skillProfJaxb.getSkillCategory());
		} else {
			//Error condition
			return Response.status(Response.Status.BAD_REQUEST).entity("Either choose an existing Skill Category and Skill combination or Define a new combination..").build();
		}
		
		if ((null == skillProfJaxb.getDefineNewRole() || "false".equalsIgnoreCase(skillProfJaxb.getDefineNewRole())) && (!WWSUtil.nullOrEmpty(skillProfJaxb.getExistingRoleId()))) {
			//Existing Role
			role.setRoleId(new Integer(skillProfJaxb.getExistingRoleId()));
		} else if (!WWSUtil.nullOrEmpty(skillProfJaxb.getRole()) && !WWSUtil.nullOrEmpty(skillProfJaxb.getRoleName())) {
			//New Role
			role.setRole(skillProfJaxb.getRole());
			role.setRoleName(skillProfJaxb.getRoleName());
		} else {
			//Error condition
			return Response.status(Response.Status.BAD_REQUEST).entity("Either choose an existing Role and role Name combination or Define a new combination..").build();
		}
		
		
		
		skillProfile.setRole(role);
		skillProfile.setSkill(skill);
		
		skillProfile = wwsDataService.persistOrGetMatchingSkillProfile(skillProfile);
		
		skillProfile = wwsDataService.updateSkillProfileOfNeed(skillProfile, new Integer(wwsId));
		return Response.ok(skillProfile).build();
	}

	@Override
	@GET
	@Path("/skill-categories")
	@Produces("application/json")
	public Response getSkillCategories() {
		Map<Integer, String> skillCategories = wwsDataService.getSkillCategories();
		TreeSet<String> uniqueSkillCategories = new TreeSet<String>();
		uniqueSkillCategories.addAll(skillCategories.values());
		return Response.ok(uniqueSkillCategories).build();
	}

	@Override
	@GET
	@Path("/need-roles")
	@Produces("application/json")
	public Response getNeedRoles() {
		Map<Integer, String> needRoles = wwsDataService.getNeedRoles();
		TreeSet<String> uniqueRoles = new TreeSet<String>();
		uniqueRoles.addAll(needRoles.values());
		return Response.ok(uniqueRoles).build();
	}

	@Override
	@GET
	@Path("/category-core-skills/{skillCategory}")
	@Produces("application/json")
	public Response getCoreSkillsOfCategory(@PathParam("skillCategory") String skillCategory) {
		List<Skill> skills = wwsDataService.getSkillsOfCategory(skillCategory);
		return Response.ok(skills).build();
	}

	@Override
	@GET
	@Path("/role-names/{role}")
	@Produces("application/json")
	public Response getRoleNamesOfRole(@PathParam("role") String role) {
		List<Role> roles = wwsDataService.getRoleNamesOfRole(role);
		return Response.ok(roles).build();
	}

	@Override
	@POST
	@Consumes("application/json")
	@Path("/search-needs")
	public Response searchNeeds(@RequestBody NeedSearchJAXB searchObj) {
		List<NeedVO> needs = wwsDataService.searchNeeds(searchObj);
		return Response.ok(needs).build();
	}

	@Override
	@GET
	@Path("/need-information/{wwsId}")
	@Produces("application/json")
	public Response getNeedInformation(@PathParam("wwsId") String wwsId) {
		NeedVO needVo = wwsDataService.getNeedInformation(new Integer(wwsId));
		return Response.ok(needVo).build();
	}

	@Override
	@POST
	@Consumes("application/json")
	@Path("/add-need-comment")
	public Response addNeedComments(@RequestBody NeedCommentJAXB needCommentJaxb) {
		NeedComment needComment = new NeedComment();
		needComment.setComment(needCommentJaxb.getComment());
		needComment.setCommentDate(WWSUtil.getDate(needCommentJaxb.getCommentDate()));
		if (!WWSUtil.nullOrEmpty(needCommentJaxb.getCommentId())) {
			needComment.setNeedCommentId(new Integer(needCommentJaxb.getCommentId()));
		} else {
			needComment.setCreated(new Date());
		}
		needComment.setWwsId(new Integer(needCommentJaxb.getWwsId()));
		needComment = wwsDataService.addNeedComment(needComment);
		return Response.status(Status.CREATED).build();
	}

	@Override
	@GET
	@Path("/need-comments/{wwsId}")
	@Produces("application/json")
	public Response getNeedComments(@PathParam("wwsId") String wwsId) {
		List<NeedComment> needComments = wwsDataService.getNeedComments(new Integer(wwsId));
		return Response.ok(needComments).build();
	}

	@Override
	@DELETE
	@Path("/delete-need-comment/{needCmntId}")
	@Produces("application/json")
	public Response deleteComment(@PathParam("needCmntId") String needCmntId) {
		wwsDataService.deleteNeedComment(needCmntId);
		return Response.ok().build();
	}
	

}
