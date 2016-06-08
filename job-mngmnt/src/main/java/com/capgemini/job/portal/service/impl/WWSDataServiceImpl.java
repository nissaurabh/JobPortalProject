/**
 * 
 */
package com.capgemini.job.portal.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
import com.capgemini.job.portal.service.WWSDataService;
import com.capgemini.wws.vo.NeedVO;

/**
 * @author sryarlag
 *
 */
@Component("wwsDataService")
public class WWSDataServiceImpl implements WWSDataService {
	
	@Autowired
	private WWSDataDao wWSDataDao;

	@Transactional
	@Override
	public void persistOpenNeeds(List<OpenNeed> openNeeds) {
		wWSDataDao.persistOpenNeeds(openNeeds);
	}

	@Transactional
	@Override
	public void persistClosedNeeds(List<ClosedNeed> closedNeeds) {
		wWSDataDao.persistClosedNeeds(closedNeeds);
	}

	@Override
	public Map<String, Billability> getBillabilityTypes() {
		return wWSDataDao.getBillabilityTypes();
	}

	@Override
	public Map<String, Client> getClients() {
		return wWSDataDao.getClients();
	}

	@Override
	public Map<String, Practice> getPractices() {
		return wWSDataDao.getPractices();
	}
	
	@Override
	public Map<String, Location> getLocations() {
		return wWSDataDao.getLocations();
	}
	
	@Override
	public Map<String, Grade> getGrades() {
		return wWSDataDao.getGrades();
	}


	@Override
	public Need getNeedByWWSId(Integer wwsId) {
		return wWSDataDao.getNeedByWWSId(wwsId);
	}

	@Transactional
	@Override
	public Location persistLocation(String missionLocation, String missionCountry) {
		String[] str = missionLocation.trim().split(",");
		Location location = new Location();
		if (null != str && str.length > 0) {
			location.setCity(str[0]);
		} else {
			location.setCity("");
		}
		if (null != str && str.length > 1) {
			location.setState(str[1]);
		} else {
			location.setState("");
		}
		
		location.setCountry(missionCountry);
		return wWSDataDao.persistLocation(location);
	}

	@Transactional
	@Override
	public Billability persistBillability(String projectType) {
		Billability billability = new Billability();
		billability.setBillabilityDesc(projectType);
		return wWSDataDao.persistBillability(billability);
	}

	@Transactional
	@Override
	public Client persistClient(String clientNm) {
		Client client = new Client();
		client.setClientName(clientNm);
		return wWSDataDao.persistClient(client);
	}
	
	@Transactional
	@Override
	public Grade persistGrade(String gradeDs) {
		Grade grade = new Grade();
		grade.setGradeDescription(gradeDs);
		return wWSDataDao.persistGrade(grade);
	}

	@Transactional
	@Override
	public Practice persistPractice(String tagGlobalPractice) {
		Practice practice = new Practice();
		practice.setPracticeName(tagGlobalPractice);
		return wWSDataDao.persistPractice(practice);
	}

	@Transactional
	@Override
	public Need persistNeed(Need need) {
		return wWSDataDao.persistNeed(need);
	}

	@Override
	public Map<String, NeedCloseReason> getNeedCloseReasons() {
		return wWSDataDao.getNeedCloseReasons();
	}

	@Transactional
	@Override
	public NeedCloseReason persistNeedCloseReason(String closingReason, String closingReasonDetails) {
		NeedCloseReason reason = new NeedCloseReason();
		reason.setCloseReason(closingReason);
		reason.setCloseReasonDetails(closingReasonDetails);
		return wWSDataDao.persistNeedCloseReason(reason);
	}

	@Override
	public List<NeedVO> getNeedsWithNoSkillProfile() {
		return wWSDataDao.getNeedsWithNoSkillProfile();
	}

	@Override
	public OpenNeed getNeedDetails(Integer wwsId) {
		return wWSDataDao.getNeedDetails(wwsId);
	}

	@Transactional
	@Override
	public SkillProfile updateSkillProfileOfNeed(SkillProfile skillProfile, Integer wwsId) {
		Need need = wWSDataDao.getNeedByWWSId(wwsId);
		
		need.setSkillProfile(skillProfile);
		
		need = wWSDataDao.persistNeed(need);
		return need.getSkillProfile();
	}

	@Transactional
	@Override
	public SkillProfile persistOrGetMatchingSkillProfile(SkillProfile skillProfile) {
		//Persist the skill if it is new
		if (null == skillProfile.getSkill().getSkillId()) {
			skillProfile.setSkill(wWSDataDao.persistSkill(skillProfile.getSkill()));
		}
		//persist the role if it is new
		if (null == skillProfile.getRole().getRoleId()) {
			skillProfile.setRole(wWSDataDao.persistRole(skillProfile.getRole()));
		}
		
		SkillProfile existingSP = wWSDataDao.getSkillProfileForRoleAndSkill(skillProfile.getRole(), skillProfile.getSkill());
		if (null == existingSP) {
			existingSP = wWSDataDao.persistSkillProfile(skillProfile.getRole(), skillProfile.getSkill());
		}
		return existingSP;
	}

	@Override
	public Map<Integer, String> getSkillCategories() {
		Map<Integer, String> skillCats = new HashMap<Integer, String>();
		List<Skill> skills = wWSDataDao.getSkills();
		if (null != skills) {
			for (Skill skill: skills) {
				skillCats.put(skill.getSkillId(), skill.getSkillCategory());
			}
		}
		return skillCats;
	}

	@Override
	public Map<Integer, String> getNeedRoles() {
		Map<Integer, String> roleMap = new HashMap<Integer, String>();
		List<Role> roles = wWSDataDao.getRoles();
		if (null != roles) {
			for (Role role: roles) {
				roleMap.put(role.getRoleId(), role.getRole());
			}
		}
		return roleMap;
	}

	@Override
	public List<Skill> getSkillsOfCategory(String skillCategory) {
		return wWSDataDao.getSkillsOfCategory(skillCategory);
	}

	@Override
	public List<Role> getRoleNamesOfRole(String role) {
		return wWSDataDao.getRoleNamesOfRole(role);
	}

	@Override
	public List<Skill> getSkills() {
		return wWSDataDao.getSkills();
	}

	@Override
	public List<Role> getRoles() {
		return wWSDataDao.getRoles();
	}

	@Override
	public List<NeedVO> searchNeeds(NeedSearchJAXB searchObj) {
		return wWSDataDao.searchNeeds(searchObj);
	}

	@Override
	public NeedVO getNeedInformation(Integer wwsId) {
		return wWSDataDao.getNeedInformation(wwsId);
	}

}
