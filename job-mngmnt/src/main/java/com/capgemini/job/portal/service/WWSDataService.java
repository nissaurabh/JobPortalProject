/**
 * 
 */
package com.capgemini.job.portal.service;

import java.util.List;
import java.util.Map;

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
import com.capgemini.wws.vo.NeedVO;

/**
 * to deal with WWS File uploads data
 * @author sryarlag
 *
 */
public interface WWSDataService {
	
	/**
	 * persists the open needs
	 * @param openNeeds
	 */
	public void persistOpenNeeds(List<OpenNeed> openNeeds);

	/**
	 * persists the closed needs
	 * @param recordsToPersist
	 */
	public void persistClosedNeeds(List<ClosedNeed> recordsToPersist);
	
	/**
	 * Load billability Types
	 * @return
	 */
	public Map<String, Billability> getBillabilityTypes();
	
	/**
	 * get available clients
	 * @return
	 */
	public Map<String, Client> getClients();

	/**
	 * get practices
	 * @return
	 */
	public Map<String, Practice> getPractices();

	/**
	 * get all the locations
	 * @return
	 */
	public Map<String, Location> getLocations();
	
	/**
	 * load the need record from database if exists 
	 * @param wwsId
	 * @return
	 */
	public Need getNeedByWWSId(Integer wwsId);

	/**
	 * get Grades
	 * @return
	 */
	public Map<String, Grade> getGrades();

	
	/**
	 * persist location
	 * @param missionLocation
	 * @param missionCountry
	 * @return
	 */
	public Location persistLocation(String missionLocation, String missionCountry);

	/**
	 * persist the billability type
	 * @param projectType
	 * @return
	 */
	public Billability persistBillability(String projectType);

	/**
	 * Persist new client
	 * @param client
	 * @return
	 */
	public Client persistClient(String client);

	/**
	 * Persist new Practice
	 * @param tagGlobalPractice
	 * @return
	 */
	public Practice persistPractice(String tagGlobalPractice);

	/**
	 * Persist Need, Save/Update
	 * @param need
	 */
	public Need persistNeed(Need need);

	/**
	 * persists the Grade
	 * @param grade
	 * @return
	 */
	public Grade persistGrade(String grade);

	/**
	 * gets the Need close reasons.
	 * @return
	 */
	public Map<String, NeedCloseReason> getNeedCloseReasons();

	/**
	 * Persist Need closing reason
	 * @param closingReason
	 * @param closingReasonDetails
	 * @return
	 */
	public NeedCloseReason persistNeedCloseReason(String closingReason, String closingReasonDetails);

	/**
	 * Get all the needs that do not have Skill Profile attached
	 * @return
	 */
	public List<NeedVO> getNeedsWithNoSkillProfile();

	/**
	 * Loads the need details for the wwsId
	 * @param integer
	 * @return
	 */
	public OpenNeed getNeedDetails(Integer wwsId);

	/**
	 * Persist skillprofile
	 * @param skillProfile
	 * @param wwsId 
	 * @return
	 */
	public SkillProfile updateSkillProfileOfNeed(SkillProfile skillProfile, Integer wwsId);

	/**
	 * Checks if the matching skill profile exists for the given skill and role, returns if exists or persists if not
	 * @param skillProfile
	 * @return
	 */
	public SkillProfile persistOrGetMatchingSkillProfile(SkillProfile skillProfile);

	/**
	 * returns the available SkillCategories from Skill table
	 * @return
	 */
	public Map<Integer, String> getSkillCategories();

	/**
	 * returns the available Roles from role table
	 * @return
	 */
	public Map<Integer, String> getNeedRoles();

	/**
	 * returns the all skill names mapped to the given skill category
	 * @param skillCategory
	 * @return
	 */
	public List<Skill> getSkillsOfCategory(String skillCategory);

	/**
	 * returns the all role names mapped to the given role
	 * @param role
	 * @return
	 */
	public List<Role> getRoleNamesOfRole(String role);

	/**
	 * returns the skills available in the system
	 * @return
	 */
	public List<Skill> getSkills();

	/**
	 * returns the roles available in the system
	 * @return
	 */
	public List<Role> getRoles();

	/**
	 * search the needs with given criteria
	 * @param searchObj
	 * @return
	 */
	public List<NeedVO> searchNeeds(NeedSearchJAXB searchObj);

	/**
	 * returns the need information, fetches the dat from both Need and OpenNeed tables
	 * @param integer
	 * @return
	 */
	public NeedVO getNeedInformation(Integer integer);

	
}
