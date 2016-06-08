/**
 * 
 */
package com.capgemini.job.portal.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * @author sryarlag
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "wwsId",
    "clientId",
    "practiceId",
    "locationId",
    "projectTypeId",
    "closeReasonId",
    "gradeId",
    "skillId",
    "roleId",
    "needStatus"
})

public class NeedSearchJAXB {
	
	private String wwsId;
	
	private String clientId;

	private String practiceId;
	
	private String locationId;
	
	private String projectTypeId;
	
	private String closeReasonId;
	
	private String gradeId;
	
	private String skillId;
	
	private String roleId;
	
	private String needStatus;

	public String getWwsId() {
		return wwsId;
	}

	public void setWwsId(String wwsId) {
		this.wwsId = wwsId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getPracticeId() {
		return practiceId;
	}

	public void setPracticeId(String practiceId) {
		this.practiceId = practiceId;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getProjectTypeId() {
		return projectTypeId;
	}

	public void setProjectTypeId(String projectTypeId) {
		this.projectTypeId = projectTypeId;
	}

	public String getCloseReasonId() {
		return closeReasonId;
	}

	public void setCloseReasonId(String closeReasonId) {
		this.closeReasonId = closeReasonId;
	}

	public String getGradeId() {
		return gradeId;
	}

	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}

	public String getSkillId() {
		return skillId;
	}

	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getNeedStatus() {
		return needStatus;
	}

	public void setNeedStatus(String needStatus) {
		this.needStatus = needStatus;
	}

		
}
