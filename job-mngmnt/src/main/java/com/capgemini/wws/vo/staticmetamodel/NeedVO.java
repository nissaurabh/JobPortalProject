/**
 * 
 */
package com.capgemini.wws.vo.staticmetamodel;

import java.util.Date;

/**
 * @author sryarlag
 *
 */
public class NeedVO {

	private Integer wwsId;
	
	private String clientName;
	
	private String practiceNm;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String grade;
	
	private String projectType;
	
	private String skill;
	
	private String skillCategory;
	
	private String role;
	
	private String roleName;
	
	private String taleoId;
	
	private String closeReason;
	
	private String closeReasonDtls;
	
	private Date projectStartDt;
	
	private Date projectEndDt;
	
	private Date closeDate;
	
	private Date created;
	
	private Date updated;
	
	private String needShortDesc;
	
	public NeedVO() {
		
	}
	
	public NeedVO(Integer wwsId, String clientName, String practiceNm, String city, String state, String country, String grade, String projectType, Date projectStartDt, Date projectEndDt, Date created, Date updated, String needShortDesc) {
		this.wwsId=wwsId;
		this.clientName=clientName;
		this.practiceNm=practiceNm;
		this.city=city;
		this.state=state;
		this.country=country;
		this.grade=grade;
		this.projectType=projectType;
		this.projectStartDt=projectStartDt;
		this.projectEndDt=projectEndDt;
		this.created=created;
		this.updated=updated;
		this.needShortDesc = needShortDesc;
	}

	public NeedVO(Integer wwsId, String clientName, String practiceNm, String city, String state, String country, String grade, String projectType, 
			String skill, String skillCategory, String role, String roleName, String taleoId, String closeReason, 
			String closeReasonDtls, Date projectStartDt, Date projectEndDt, Date closeDate, Date created, Date updated) {
		
		this.wwsId=wwsId;
		this.clientName=clientName;
		this.practiceNm=practiceNm;
		this.city=city;
		this.state=state;
		this.country=country;
		this.grade=grade;
		this.projectType=projectType;
		this.skill=skill;
		this.skillCategory=skillCategory;
		this.role=role;
		this.roleName=roleName;
		this.taleoId=taleoId;
		this.closeReason=closeReason;
		this.closeReasonDtls=closeReasonDtls;
		this.projectStartDt=projectStartDt;
		this.projectEndDt=projectEndDt;
		this.closeDate=closeDate;
		this.created=created;
		this.updated=updated;
	}

	public Integer getWwsId() {
		return wwsId;
	}

	public void setWwsId(Integer wwsId) {
		this.wwsId = wwsId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getPracticeNm() {
		return practiceNm;
	}

	public void setPracticeNm(String practiceNm) {
		this.practiceNm = practiceNm;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getSkillCategory() {
		return skillCategory;
	}

	public void setSkillCategory(String skillCategory) {
		this.skillCategory = skillCategory;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getTaleoId() {
		return taleoId;
	}

	public void setTaleoId(String taleoId) {
		this.taleoId = taleoId;
	}

	public String getCloseReason() {
		return closeReason;
	}

	public void setCloseReason(String closeReason) {
		this.closeReason = closeReason;
	}

	public String getCloseReasonDtls() {
		return closeReasonDtls;
	}

	public void setCloseReasonDtls(String closeReasonDtls) {
		this.closeReasonDtls = closeReasonDtls;
	}

	public Date getProjectStartDt() {
		return projectStartDt;
	}

	public void setProjectStartDt(Date projectStartDt) {
		this.projectStartDt = projectStartDt;
	}

	public Date getProjectEndDt() {
		return projectEndDt;
	}

	public void setProjectEndDt(Date projectEndDt) {
		this.projectEndDt = projectEndDt;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public String getNeedShortDesc() {
		return needShortDesc;
	}

	public void setNeedShortDesc(String needShortDesc) {
		this.needShortDesc = needShortDesc;
	}
	
}
