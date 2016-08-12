/**
 * 
 */
package com.capgemini.job.portal.dao;

import java.util.List;
import java.util.Map;

import com.capgemini.job.portal.entities.Billability;
import com.capgemini.job.portal.entities.Client;
import com.capgemini.job.portal.entities.ClosedNeed;
import com.capgemini.job.portal.entities.Grade;
import com.capgemini.job.portal.entities.Location;
import com.capgemini.job.portal.entities.Need;
import com.capgemini.job.portal.entities.NeedCloseReason;
import com.capgemini.job.portal.entities.NeedComment;
import com.capgemini.job.portal.entities.OpenNeed;
import com.capgemini.job.portal.entities.Practice;
import com.capgemini.job.portal.entities.Role;
import com.capgemini.job.portal.entities.Skill;
import com.capgemini.job.portal.entities.SkillProfile;
import com.capgemini.job.portal.jaxb.NeedSearchJAXB;
import com.capgemini.wws.vo.NeedVO;

/**
 * @author sryarlag
 *
 */
public interface WWSDataDao {
	
	/**
	 * persist the open needs to database
	 * @param openNeeds
	 */
	public void persistOpenNeeds(List<OpenNeed> openNeeds);

	/**
	 * persist the closed needs to datastore
	 * @param closedNeeds
	 */
	public void persistClosedNeeds(List<ClosedNeed> closedNeeds);
	
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
	 * get grades
	 * @return
	 */
	public Map<String, Grade> getGrades();

	/**
	 * get need record by wws Id
	 * @param wwsId
	 * @return
	 */
	public Need getNeedByWWSId(Integer wwsId);

	/**
	 * Persists the location
	 * @param location
	 * @return
	 */
	public Location persistLocation(Location location);
	
	/**
	 * persist billability type
	 * @param billability
	 * @return
	 */
	public Billability persistBillability(Billability billability);

	/**
	 * persist new client
	 * @param client
	 * @return
	 */
	public Client persistClient(Client client);

	/**
	 * save practice
	 * @param practice
	 * @return
	 */
	public Practice persistPractice(Practice practice);

	/**
	 * Persist need
	 * @param need
	 * @return
	 */
	public Need persistNeed(Need need);

	/**
	 * Persists Grade
	 * @param grade
	 * @return
	 */
	public Grade persistGrade(Grade grade);

	/**
	 * Fetch the need close Reasons..
	 * @return
	 */
	public Map<String, NeedCloseReason> getNeedCloseReasons();

	/**
	 * Persist the NeedCloseReason
	 * @param reason
	 * @return
	 */
	public NeedCloseReason persistNeedCloseReason(NeedCloseReason reason);

	/**
	 * Fetch all the needs those do not have skill profile attached
	 * @return
	 */
	public List<NeedVO> getNeedsWithNoSkillProfile();

	/**
	 * Fetch the Need Details for given wwsId
	 * @param wwsId
	 * @return
	 */
	public OpenNeed getNeedDetails(Integer wwsId);

	/**
	 * Persist Skill
	 * @param skill
	 * @return
	 */
	public Skill persistSkill(Skill skill);

	/**
	 * Persist Role
	 * @param role
	 * @return
	 */
	public Role persistRole(Role role);

	/**
	 * Checks if any SkillProfile already exists for this skill and role combination; returns if exists.
	 * @param role
	 * @param skill
	 * @return
	 */
	public SkillProfile getSkillProfileForRoleAndSkill(Role role, Skill skill);

	/**
	 * persists new skillprofile for role and skill combination
	 * @param role
	 * @param skill
	 * @return
	 */
	public SkillProfile persistSkillProfile(Role role, Skill skill);

	/**
	 * get all Skills
	 * @return
	 */
	public List<Skill> getSkills();

	/**
	 * Get all Roles
	 * @return
	 */
	public List<Role> getRoles();

	/**
	 * Fetches the skills associated to the skillCategory
	 * @param skillCategory
	 * @return
	 */
	public List<Skill> getSkillsOfCategory(String skillCategory);

	/**
	 * Fetches the role names associated to the given role
	 * @param role
	 * @return
	 */
	public List<Role> getRoleNamesOfRole(String role);

	/**
	 * search the needs matching the given criteria
	 * @param searchObj
	 * @return
	 */
	public List<NeedVO> searchNeeds(NeedSearchJAXB searchObj);

	/**
	 * Search the given need in both Need and OpenNeed tables, returns the mixed data.
	 * @param wwsId
	 * @return
	 */
	public NeedVO getNeedInformation(Integer wwsId);

	/**
	 * Fetches the need comments for the wwsid
	 * @param wwsId
	 * @return
	 */
	public List<NeedComment> getNeedComments(Integer wwsId);

	/**
	 * Persists the need comment
	 * @param needComment
	 * @return
	 */
	public NeedComment persistNeedComment(NeedComment needComment);

	/**
	 * delete the need comment for given id
	 * @param nc
	 */
	public void deleteNeedComment(NeedComment nc);
	
	
}
