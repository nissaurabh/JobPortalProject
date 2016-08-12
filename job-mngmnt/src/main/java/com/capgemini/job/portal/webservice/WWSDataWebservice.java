/**
 * @author  sryarlag
 * 
 */
package com.capgemini.job.portal.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import org.springframework.web.bind.annotation.RequestBody;

import com.capgemini.job.portal.jaxb.NeedCommentJAXB;
import com.capgemini.job.portal.jaxb.NeedSearchJAXB;
import com.capgemini.job.portal.jaxb.SkillProfileJAXB;

/**
 * Webservice for dealing in WWS Data.
 * 
 * @author sryarlag
 */
@Path("/wwsData")
public interface WWSDataWebservice {
	
	

	@POST
	@Path("/{need-file-type}/{data-sheet-name}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response loadNeedsFile(@PathParam("need-file-type") final String needFileType, 
			@Multipart("file") Attachment attachment, @PathParam("data-sheet-name") final String dataSheetName) throws Exception;
	
	@GET
	@Path("/clients")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClients() throws Exception; 
	
	
	@GET
	@Path("/locations")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLocations() throws Exception; 
	
	
	@GET
	@Path("/practices")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPractices() throws Exception; 
	
	
	@GET
	@Path("/project-types")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProjectTypes() throws Exception; 
	
	
	@GET
	@Path("/close-reasons")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCloseReasons() throws Exception; 
	
	@GET
	@Path("/grades")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGrades() throws Exception; 
	
	@GET
	@Path("/skills")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSkills() throws Exception;
	
	@GET
	@Path("/roles")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getroles() throws Exception;
	
	@GET
	@Path("/no-skill-profile-needs")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNeedsRequiringSkillProfile();
	
	@GET
	@Path("/need-details/{wwsId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNeedDetails(@PathParam("wwsId") final String wwsId);
	
	/**
	 * this service returns skill profile data as well.
	 * @param wwsId
	 * @return
	 */
	@GET
	@Path("/need-information/{wwsId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNeedInformation(@PathParam("wwsId") final String wwsId);
	
	@POST
	@Consumes("application/json")
	@Path("/update-skill-profile/{wwsId}")
	public Response updateSkillProfileOfNeed(@PathParam("wwsId") final String wwsId, @RequestBody final SkillProfileJAXB skillProfJaxb);
	
	@GET
	@Path("/skill-categories")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSkillCategories();
	
	@GET
	@Path("/need-roles")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNeedRoles();
	
	@GET
	@Path("/category-core-skills/{skillCategory}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCoreSkillsOfCategory(@PathParam("skillCategory") final String skillCategory);
	
	@GET
	@Path("/role-names/{role}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRoleNamesOfRole(@PathParam("role") final String role);
		
	@POST
	@Consumes("application/json")
	@Path("/search-needs")
	public Response searchNeeds(@RequestBody final NeedSearchJAXB searchObj);
	
	@POST
	@Consumes("application/json")
	@Path("/add-need-comment")
	public Response addNeedComments(@RequestBody final NeedCommentJAXB needCommentJaxb);
	
	@GET
	@Path("/need-comments/{wwsId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNeedComments(@PathParam("wwsId") final String wwsId);
	
	@DELETE
	@Path("/delete-need-comment/{needCmntId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteComment(@PathParam("wwneedCmntIdsId") final String needCmntId);
}
