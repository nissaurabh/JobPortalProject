/**
 * 
 */
package com.capgemini.job.portal.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.cxf.common.util.CollectionUtils;
import org.springframework.stereotype.Service;

import com.capgemini.job.portal.dao.WWSDataDao;
import com.capgemini.job.portal.entities.Billability;
import com.capgemini.job.portal.entities.Client;
import com.capgemini.job.portal.entities.ClosedNeed;
import com.capgemini.job.portal.entities.Grade;
import com.capgemini.job.portal.entities.Location;
import com.capgemini.job.portal.entities.Need;
import com.capgemini.job.portal.entities.NeedCloseReason;
import com.capgemini.job.portal.entities.OpenNeed;
import com.capgemini.job.portal.entities.Practice;
import com.capgemini.job.portal.entities.Role;
import com.capgemini.job.portal.entities.Skill;
import com.capgemini.job.portal.entities.SkillProfile;
import com.capgemini.job.portal.jaxb.NeedSearchJAXB;
import com.capgemini.wws.filefeed.WWSUtil;
import com.capgemini.wws.vo.NeedVO;

/**
 * @author sryarlag
 *
 */
@Service("wWSDataDao")
public class WWSDataDaoImpl implements WWSDataDao {

	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager entityManager;
	
	@Override
	public void persistOpenNeeds(List<OpenNeed> openNeeds) {
		for (OpenNeed need: openNeeds) {
			entityManager.merge(need);
			entityManager.flush();
		}
	}

	@Override
	public void persistClosedNeeds(List<ClosedNeed> closedNeeds) {
		for (ClosedNeed need: closedNeeds) {
			entityManager.merge(need);
			entityManager.flush();
		}
	}

	@Override
	public Map<String, Billability> getBillabilityTypes() {
		Map<String, Billability> result = new HashMap<String, Billability>();
		final Query query = entityManager.createQuery("From Billability");
		final List<Billability> billabilities = (List<Billability>) query.getResultList();
		if (null != billabilities && billabilities.size() > 0) {
			for (Billability billability: billabilities) {
				result.put(WWSUtil.getWWSComparableString(billability.getBillabilityDesc()), billability);
			}
		}
		return result;
	}

	@Override
	public Map<String, Client> getClients() {
		Map<String, Client> result = new HashMap<String, Client>();
		final Query query = entityManager.createQuery("From Client");
		final List<Client> clients = (List<Client>) query.getResultList();
		if (null != clients && clients.size() > 0) {
			for (Client client: clients) {
				result.put(WWSUtil.getWWSComparableString(client.getClientName()), client);
			}
		}
		return result;
	}

	@Override
	public Map<String, Practice> getPractices() {
		Map<String, Practice> result = new HashMap<String, Practice>();
		final Query query = entityManager.createQuery("From Practice");
		final List<Practice> practices = (List<Practice>) query.getResultList();
		if (null != practices && practices.size() > 0) {
			for (Practice practice: practices) {
				result.put(WWSUtil.getWWSComparableString(practice.getPracticeName()), practice);
			}
		}
		return result;
	}
	
	@Override
	public Map<String, Location> getLocations() {
		Map<String, Location> result = new HashMap<String, Location>();
		final Query query = entityManager.createQuery("From Location");
		final List<Location> locations = (List<Location>) query.getResultList();
		if (null != locations && locations.size() > 0) {
			for (Location location: locations) {
				result.put(WWSUtil.getWWSComparableString((location.getCity()+location.getState()+location.getCountry())), location);
			}
		}
		return result;
	}
	
	@Override
	public Map<String, Grade> getGrades() {
		Map<String, Grade> result = new HashMap<String, Grade>();
		final Query query = entityManager.createQuery("From Grade ");
		final List<Grade> grades = (List<Grade>) query.getResultList();
		if (null != grades && grades.size() > 0) {
			for (Grade grade: grades) {
				result.put(WWSUtil.getWWSComparableString(grade.getGradeDescription()), grade);
			}
		}
		return result;
	}
	
	@Override
	public Map<String, NeedCloseReason> getNeedCloseReasons() {
		Map<String, NeedCloseReason> result = new HashMap<String, NeedCloseReason>();
		final Query query = entityManager.createQuery("From NeedCloseReason");
		final List<NeedCloseReason> closeReasons = (List<NeedCloseReason>) query.getResultList();
		if (null != closeReasons && closeReasons.size() > 0) {
			for (NeedCloseReason reason: closeReasons) {
				result.put(WWSUtil.getWWSComparableString((reason.getCloseReason()+reason.getCloseReasonDetails())), reason);
			}
		}
		return result;
	}

	@Override
	public Need getNeedByWWSId(Integer wwsId) {
		return entityManager.find(Need.class, wwsId);
	}

	@Override
	public Location persistLocation(Location location) {
		entityManager.persist(location);
		entityManager.flush();
		return location;
	}

	@Override
	public Billability persistBillability(Billability billability) {
		entityManager.persist(billability);
		return billability;
	}

	@Override
	public Client persistClient(Client client) {
		entityManager.persist(client);
		entityManager.flush();
		return client;
	}

	@Override
	public Practice persistPractice(Practice practice) {
		entityManager.persist(practice);
		entityManager.flush();
		return practice;
	}

	@Override
	public Need persistNeed(Need need) {
		entityManager.merge(need);
		entityManager.flush();
		return need;
	}

	@Override
	public Grade persistGrade(Grade grade) {
		entityManager.merge(grade);
		entityManager.flush();
		return grade;
	}

	@Override
	public NeedCloseReason persistNeedCloseReason(NeedCloseReason reason) {
		NeedCloseReason ncr = entityManager.merge(reason);
		entityManager.flush();
		return ncr;
	}

	@Override
	public List<NeedVO> getNeedsWithNoSkillProfile() {
		StringBuilder sql = new StringBuilder();
		sql.append("Select new com.capgemini.wws.vo.NeedVO (n.wwsId, n.client.clientName, n.practice.practiceName, n.location.city ")
		.append(" , n.location.state, n.location.country, n.grade.gradeDescription, n.billability.billabilityDesc ")
		.append(" , n.projectStartDate, n.projectEndDate, n.createdDate, n.updatedDate, n.shortDescription )")
		.append(" From Need n where n.skillProfile is NULL")
		//.append(" From Need n")
		;
		final Query query = entityManager.createQuery(sql.toString());
		final List<NeedVO> needList = (List<NeedVO>) query.getResultList();
		
		return needList;
		
		 /*List<NeedVO> needs = new ArrayList<NeedVO>();
		 final Query query = entityManager.createQuery("From Need");
		 final List<Need> needList = (List<Need>) query.getResultList();
		 if (null != needList && needList.size() >0) {
			 for (Need need: needList) {
				 if (null == need.getNeedCloseDate() && (null == need.getSkillProfile() || need.getSkillProfile().getSkillProfileId()<1)) {
					 NeedVO needVo = new NeedVO();
					 needVo.setWwsId(need.getWwsId());
					 if (null != need.getLocation()) {
						 needVo.setCity(need.getLocation().getCity());
						 needVo.setState(need.getLocation().getState());
						 needVo.setCountry(need.getLocation().getCountry());
					 }
					 if (null != need.getClient()) {
						 needVo.setClientName(need.getClient().getClientName());
					 }
					 needVo.setCloseDate(need.getNeedCloseDate());
					 if (null != need.getGrade()) {
						 needVo.setGrade(need.getGrade().getGradeDescription());
					 }
					 if (null != need.getNeedCloseReason()) {
						 needVo.setCloseReason(need.getNeedCloseReason().getCloseReason());
						 needVo.setCloseReasonDtls(need.getNeedCloseReason().getCloseReasonDetails());
					 }
					 needVo.setCreated(need.getCreatedDate());
					 if (null != need.getPractice()) {
						 needVo.setPracticeNm(need.getPractice().getPracticeName());
					 }
					 needVo.setProjectEndDt(need.getProjectEndDate());
					 needVo.setProjectStartDt(need.getProjectStartDate());
					 if (null != need.getBillability()) {
						 needVo.setProjectType(need.getBillability().getBillabilityDesc());
					 }
					 needVo.setUpdated(need.getUpdatedDate());
					 
					 //Role and skill details not populated here to vo, because this method is supposed to return only the needs with missing skillprofile
					 
					 needs.add(needVo);
				 }
			 }
		 }
		 return needs;*/
		
	}

	@Override
	public OpenNeed getNeedDetails(Integer wwsId) {
		OpenNeed openNeed = new OpenNeed();
		final Query query = entityManager.createQuery(" select n from OpenNeed n where n.wwsId =:wwsId").setParameter("wwsId", wwsId);
		final List<OpenNeed> needs = (List<OpenNeed>) query.getResultList();
		
		if(!CollectionUtils.isEmpty(needs)){
			openNeed = needs.get(0);
		}
		return openNeed;
	}

	@Override
	public Skill persistSkill(Skill skill) {
		entityManager.persist(skill);
		entityManager.flush();
		return skill;
	}

	@Override
	public Role persistRole(Role role) {
		entityManager.persist(role);
		entityManager.flush();
		return role;
	}

	@Override
	public SkillProfile getSkillProfileForRoleAndSkill(Role role, Skill skill) {
		SkillProfile skillProfile = new SkillProfile();
		final Query query = entityManager.createQuery(" select sp from SkillProfile sp where sp.skill.skillId =:skillId and sp.role.roleId =:roleId")
				.setParameter("skillId", skill.getSkillId()).setParameter("roleId", role.getRoleId());
		final List<SkillProfile> skillProfiles = (List<SkillProfile>) query.getResultList();
		
		if(!CollectionUtils.isEmpty(skillProfiles)){
			skillProfile = skillProfiles.get(0);
			return skillProfile;
		} 
		return null;
	}

	@Override
	public SkillProfile persistSkillProfile(Role role, Skill skill) {
		SkillProfile skillProfile = new SkillProfile();
		skillProfile.setSkill(skill);
		skillProfile.setRole(role);
		entityManager.persist(skillProfile);
		entityManager.flush();
		return skillProfile;
	}

	@Override
	public List<Skill> getSkills() {
		final Query query = entityManager.createQuery("From Skill");
		final List<Skill> skills = (List<Skill>) query.getResultList();
		return skills;
	}

	@Override
	public List<Role> getRoles() {
		final Query query = entityManager.createQuery("From Role");
		final List<Role> roles = (List<Role>) query.getResultList();
		return roles;
	}

	@Override
	public List<Skill> getSkillsOfCategory(String skillCategory) {
		final Query query = entityManager.createQuery(" select s from Skill s where s.skillCategory =:skill_cat").setParameter("skill_cat", skillCategory);
		final List<Skill> skills = (List<Skill>) query.getResultList();
		return skills;
	}

	@Override
	public List<Role> getRoleNamesOfRole(String role) {
		final Query query = entityManager.createQuery(" select r from Role r where r.role =:role").setParameter("role", role);
		final List<Role> roles = (List<Role>) query.getResultList();
		return roles;
	}

	@Override
	public List<NeedVO> searchNeeds(NeedSearchJAXB searchObj) {
		List<NeedVO> results = new ArrayList<NeedVO>();
		/*
		StringBuilder sql = new StringBuilder();
		sql.append("Select new com.capgemini.wws.vo.NeedVO (n.wwsId, n.client.clientName, n.practice.practiceName, n.location.city ")
		.append(" , n.location.state, n.location.country, n.grade.gradeDescription, n.billability.billabilityDesc ")
		.append(" ,n.skillProfile.skill.skill, n.skillProfile.skill.skillCategory, n.skillProfile.role.role, n.skillProfile.role.roleName, n.skillProfile.taleoId ")
		.append(" , n.needCloseReason.closeReason, n.needCloseReason.closeReasonDetails ")
		.append(" , n.projectStartDate, n.projectEndDate, n.needCloseDate, n.createdDate, n.updatedDate, n.shortDescription )")
		.append(" From Need n where n.wwsId is not NULL")
		;
		*/
		StringBuilder sql = new StringBuilder();
		sql.append(" from Need n where n.wwsId is not null ");
		
		if (!WWSUtil.nullOrEmpty(searchObj.getWwsId())) {
			sql.append(" and n.wwsId =:wwsId ");
		}
		if (!WWSUtil.nullOrEmpty(searchObj.getClientId())) {
			sql.append(" and n.client.clientId =:clientId ");
		}
		if (!WWSUtil.nullOrEmpty(searchObj.getGradeId())) {
			sql.append(" and n.grade.gradeId =:gradeId ");
		}
		if (!WWSUtil.nullOrEmpty(searchObj.getLocationId())) {
			sql.append(" and n.location.locationId =:locationId ");
		}
		if (!WWSUtil.nullOrEmpty(searchObj.getSkillId())) {
			sql.append(" and n.skillProfile.skill.skillId =:skillId ");
		}
		if (!WWSUtil.nullOrEmpty(searchObj.getRoleId())) {
			sql.append(" and n.skillProfile.role.roleId =:roleId ");
		}
		if (!WWSUtil.nullOrEmpty(searchObj.getPracticeId())) {
			sql.append(" and n.practice.practiceId =:practiceId ");
		}
		if (!WWSUtil.nullOrEmpty(searchObj.getProjectTypeId())) {
			sql.append(" and n.billability.billabilityId =:billabilityId ");
		}
		if (!WWSUtil.nullOrEmpty(searchObj.getCloseReasonId())) {
			sql.append(" and n.needCloseReason.closeReasonId =:closeReasonId ");
		}
		if (!WWSUtil.nullOrEmpty(searchObj.getNeedStatus())) {
			sql.append(" and n.needStatus =:needStatus ");
		}
		
		
		final Query query = entityManager.createQuery(sql.toString());
		
		
		if (!WWSUtil.nullOrEmpty(searchObj.getWwsId())) {
			query.setParameter("wwsId", new Integer(searchObj.getWwsId()));
		}
		if (!WWSUtil.nullOrEmpty(searchObj.getClientId())) {
			query.setParameter("clientId",  new Integer(searchObj.getClientId()));
		}
		if (!WWSUtil.nullOrEmpty(searchObj.getGradeId())) {
			query.setParameter("gradeId",  new Integer(searchObj.getGradeId()));
		}
		if (!WWSUtil.nullOrEmpty(searchObj.getLocationId())) {
			query.setParameter("locationId",  new Integer(searchObj.getLocationId()));
		}
		if (!WWSUtil.nullOrEmpty(searchObj.getSkillId())) {
			query.setParameter("skillId",  new Integer(searchObj.getSkillId()));
		}
		if (!WWSUtil.nullOrEmpty(searchObj.getRoleId())) {
			query.setParameter("roleId",  new Integer(searchObj.getRoleId()));
		}
		if (!WWSUtil.nullOrEmpty(searchObj.getPracticeId())) {
			query.setParameter("practiceId", new Integer(searchObj.getPracticeId()));
		}
		if (!WWSUtil.nullOrEmpty(searchObj.getProjectTypeId())) {
			query.setParameter("billabilityId", new Integer(searchObj.getProjectTypeId()));
		}
		if (!WWSUtil.nullOrEmpty(searchObj.getCloseReasonId())) {
			query.setParameter("closeReasonId", new Integer(searchObj.getCloseReasonId()));
		}
		if (!WWSUtil.nullOrEmpty(searchObj.getNeedStatus())) {
			query.setParameter("needStatus", searchObj.getNeedStatus());
		}
		
		final List<Need> needs = (List<Need>) query.getResultList();
		
		
		
		/*CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<NeedSearchResVO> criteria = builder.createQuery(NeedSearchResVO.class);
		
		Root<Need> needRoot = criteria.from(Need.class);
		criteria.select(
		    builder.construct(
		    	NeedSearchResVO.class,
	    		needRoot.get(Need_.wwsId ),
	    		needRoot.get(Need_.needStatus ),
	    		needRoot.get(Need_.practice ),
	    		needRoot.get(Need_.location ),
	    		needRoot.get(Need_.client ),
	    		needRoot.get(Need_.grade ),
	    		needRoot.get(Need_.billability ),
	    		needRoot.get(Need_.needCloseReason ),
	    		needRoot.get(Need_.projectStartDate ),
	    		needRoot.get(Need_.projectEndDate ),
	    		needRoot.get(Need_.needCloseDate ),
	    		needRoot.get(Need_.skillProfile )
		    )
		);
		
		if (!WWSUtil.nullOrEmpty(searchObj.getWwsId())) {
			criteria.where(builder.equal(needRoot.get(Need_.wwsId), searchObj.getWwsId()));
		}
		
		if (!WWSUtil.nullOrEmpty(searchObj.getClientId())) {
			criteria.where(builder.equal(needRoot.get(Need_.client), searchObj.getClientId()));
		}
		
		if (!WWSUtil.nullOrEmpty(searchObj.getCloseReasonId())) {
			criteria.where(builder.equal(needRoot.get(Need_.needCloseReason), searchObj.getCloseReasonId()));	
		}
		
		if (!WWSUtil.nullOrEmpty(searchObj.getGradeId())) {
			criteria.where(builder.equal(needRoot.get(Need_.grade), searchObj.getGradeId()));
		}
		
		if (!WWSUtil.nullOrEmpty(searchObj.getLocationId())) {
			criteria.where(builder.equal(needRoot.get(Need_.location), searchObj.getLocationId()));
		}
		
		if (!WWSUtil.nullOrEmpty(searchObj.getNeedStatus())) {
			criteria.where(builder.equal(needRoot.get(Need_.needStatus), searchObj.getNeedStatus()));
		}
		
		if (!WWSUtil.nullOrEmpty(searchObj.getPracticeId())) {
			criteria.where(builder.equal(needRoot.get(Need_.practice), searchObj.getPracticeId()));
		}
		
		if (!WWSUtil.nullOrEmpty(searchObj.getProjectTypeId())) {
			criteria.where(builder.equal(needRoot.get(Need_.billability), searchObj.getProjectTypeId()));
		}
		
		if (!WWSUtil.nullOrEmpty(searchObj.getSkillId())) {
			criteria.where(builder.equal(needRoot.get(Need_.skillProfile), searchObj.getSkillId()));
		}
		
		List<NeedSearchResVO> searchResVos = entityManager.createQuery(criteria).getResultList();
		
		System.out.println("Search Results Vo: "+searchResVos);*/
		
		if (null != needs && needs.size() > 0) {
			for (Need need: needs) {
				NeedVO vo = new NeedVO();
				vo.setWwsId(need.getWwsId());
				if (null != need.getLocation()) {
					vo.setCity(need.getLocation().getCity());
					vo.setState(need.getLocation().getState());
					vo.setCountry(need.getLocation().getCountry());
				}
				if (null != need.getClient()) {
					vo.setClientName(need.getClient().getClientName());
				}
				if (null != need.getGrade()) {
					vo.setGrade(need.getGrade().getGradeDescription());
				}
				vo.setNeedShortDesc(need.getShortDescription());
				
				if (null != need.getSkillProfile()) {
					vo.setSkill(need.getSkillProfile().getSkill().getSkill());
					vo.setSkillCategory(need.getSkillProfile().getSkill().getSkillCategory());
					vo.setRole(need.getSkillProfile().getRole().getRole());
					vo.setRoleName(need.getSkillProfile().getRole().getRoleName());
				}
				
				if (null != need.getBillability()) {
					 vo.setProjectType(need.getBillability().getBillabilityDesc());
				}
				
				vo.setProjectStartDt(need.getProjectStartDate());
				vo.setProjectEndDt(need.getProjectEndDate());
				vo.setNeedStatus(need.getNeedStatus());
				vo.setCreated(need.getCreatedDate());
				
				results.add(vo);
			}
		}
		
		return results;
	}

	@Override
	public NeedVO getNeedInformation(Integer wwsId) {
		NeedVO needVo = new NeedVO();
		OpenNeed openNeed = new OpenNeed();
		Query query = entityManager.createQuery(" select n from OpenNeed n where n.wwsId =:wwsId").setParameter("wwsId", wwsId);
		final List<OpenNeed> openNeeds = (List<OpenNeed>) query.getResultList();
		
		if(!CollectionUtils.isEmpty(openNeeds)){
			openNeed = openNeeds.get(0);
		}
		//Populate Data from OpenNeed
		needVo.setWwsId(wwsId);
		needVo.setConfidentialDesc(openNeed.getConfidentialDescription());
		needVo.setCreatorFullName(openNeed.getCreatorFullName());
		needVo.setNeedReason(openNeed.getNeedReason());
		needVo.setPrivateComment(openNeed.getPrivateComment());
		needVo.setRecruitmentNeeds(openNeed.getRecruitmentNeeds());
		needVo.setRequestorFullName(openNeed.getRequesterFullName());
		needVo.setRmHandlerFullName(openNeed.getRmHandlerFullName());
		needVo.setSkillComment(openNeed.getSkillComment());
		needVo.setTagsEmailSent(openNeed.getTagsEmailSent());
		needVo.setWorkAnywhere(openNeed.getWorkAnywhere());
		needVo.setProjectName(openNeed.getProjectName());
		needVo.setLocalGrade(openNeed.getLocalGrades());
		needVo.setShortDesc(openNeed.getShortDescription());
		needVo.setInternalDesc(openNeed.getInternalDescription());
		//Populate Data from Need
		query = entityManager.createQuery(" select n from Need n where n.wwsId =:wwsId").setParameter("wwsId", wwsId);
		final List<Need> needs = (List<Need>) query.getResultList();
		Need need = new Need();
		if(!CollectionUtils.isEmpty(needs)){
			need = needs.get(0);
		}
		
		if (null != need) {
			if (null != need.getLocation()) {
				needVo.setCity(need.getLocation().getCity());
				needVo.setState(need.getLocation().getState());
				needVo.setCountry(need.getLocation().getCountry());
			}
			
			if (null != need.getBillability() ) {
				needVo.setProjectType(need.getBillability().getBillabilityDesc());
			}
			
			if (null != need.getClient()) {
				needVo.setClientName(need.getClient().getClientName());
			}
			
			if (null != need.getGrade()) {
				needVo.setGrade(need.getGrade().getGradeDescription());
			}
			if (null != need.getSkillProfile()) {
				needVo.setSkill(need.getSkillProfile().getSkill().getSkill());
				needVo.setSkillCategory(need.getSkillProfile().getSkill().getSkillCategory());
				needVo.setRole(need.getSkillProfile().getRole().getRole());
				needVo.setRoleName(need.getSkillProfile().getRole().getRoleName());
			}
			
			if (null != need.getNeedCloseReason()) {
				needVo.setCloseReason(need.getNeedCloseReason().getCloseReason());
				needVo.setCloseReasonDtls(need.getNeedCloseReason().getCloseReasonDetails());
			}
			if (null != need.getPractice()) {
				needVo.setPracticeNm(need.getPractice().getPracticeName());
			}
			needVo.setProjectEndDt(need.getProjectEndDate());
			needVo.setProjectStartDt(need.getProjectStartDate());
			needVo.setNeedShortDesc(need.getShortDescription());
			needVo.setCloseDate(need.getNeedCloseDate());
			needVo.setCreated(need.getCreatedDate());
			if (null != need.getNeedCloseDate()) {
				needVo.setNeedStatus("Closed");
			} else {
				needVo.setNeedStatus("Open");
			}
		}
		return needVo;
	}

}
