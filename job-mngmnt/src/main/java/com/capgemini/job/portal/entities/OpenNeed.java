/**
 * 
 */
package com.capgemini.job.portal.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author sryarlag
 *
 */

@Entity
@Table(name="wws_open_needs")
public class OpenNeed implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="wws_id")
	private Integer wwsId; //Id
	
	@Column(name="short_desc")
	private String shortDescription;//Short Description
	
	@Column(name="project_name")
	private String projectName;//Project Name
	
	@Column(name="project_start_date")
	private Date projectStartDate;//Project Start Date
	
	@Column(name="project_end_date")
	private Date projectEndDate;//Project End Date
	
	@Column(name="client")
	private String client; //Client
	
	@Column(name="grade")
	private String grade;//Grade
	
	@Column(name="local_grades")
	private String localGrades;//Local Grades
	
	@Column(name="mission_country")
	private String missionCountry;//Mission Country

	@Column(name="mission_location")
	private String missionLocation;//Mission Location

	@Column(name="work_anywhere")
	private String workAnywhere;//Work Anywhere

	@Column(name="internal_desc")
	private String internalDescription;//Internal Description

	@Column(name="confidential_desc")
	private String confidentialDescription;//Confidential Description
	
	@Column(name="private_comment")
	private String privateComment;//Private Comment

	@Column(name="rm_handler_full_name")
	private String rmHandlerFullName;//RM Handler Full Name

	@Column(name="creator_full_name")
	private String creatorFullName;//Creator Full Name

	@Column(name="requester_full_name")
	private String requesterFullName;//Requester Full Name

	@Column(name="project_type")
	private String projectType;//Project Type

	@Column(name="creation_date")
	private Date creatonDate;//Creation Date

	@Column(name="tag_global_practice")
	private String tagGlobalPractice;//Tag Global Practice

	@Column(name="tags_email_sent")
	private String tagsEmailSent;//Tags Email Sent

	@Column(name="skill_comment")
	private String skillComment;//Skill Comment

	@Column(name="need_reason")
	private String needReason;//Need Reason

	@Column(name="status")
	private String status;//Status

	@Column(name="recruitment_needs")
	private String recruitmentNeeds;//Recruitment Needs

	@Column(name="lead_time")
	private String leadTime;//Lead Time

	@Column(name="week_by_status")
	private String weekByStatus;//Week by Status

	public Integer getWwsId() {
		return wwsId;
	}

	public void setWwsId(Integer wwsId) {
		this.wwsId = wwsId;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public Date getProjectEndDate() {
		return projectEndDate;
	}

	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getLocalGrades() {
		return localGrades;
	}

	public void setLocalGrades(String localGrades) {
		this.localGrades = localGrades;
	}

	public String getMissionCountry() {
		return missionCountry;
	}

	public void setMissionCountry(String missionCountry) {
		this.missionCountry = missionCountry;
	}

	public String getMissionLocation() {
		return missionLocation;
	}

	public void setMissionLocation(String missionLocation) {
		this.missionLocation = missionLocation;
	}

	public String getWorkAnywhere() {
		return workAnywhere;
	}

	public void setWorkAnywhere(String workAnywhere) {
		this.workAnywhere = workAnywhere;
	}

	public String getInternalDescription() {
		return internalDescription;
	}

	public void setInternalDescription(String internalDescription) {
		this.internalDescription = internalDescription;
	}

	public String getConfidentialDescription() {
		return confidentialDescription;
	}

	public void setConfidentialDescription(String confidentialDescription) {
		this.confidentialDescription = confidentialDescription;
	}

	public String getPrivateComment() {
		return privateComment;
	}

	public void setPrivateComment(String privateComment) {
		this.privateComment = privateComment;
	}

	public String getRmHandlerFullName() {
		return rmHandlerFullName;
	}

	public void setRmHandlerFullName(String rmHandlerFullName) {
		this.rmHandlerFullName = rmHandlerFullName;
	}

	public String getCreatorFullName() {
		return creatorFullName;
	}

	public void setCreatorFullName(String creatorFullName) {
		this.creatorFullName = creatorFullName;
	}

	public String getRequesterFullName() {
		return requesterFullName;
	}

	public void setRequesterFullName(String requesterFullName) {
		this.requesterFullName = requesterFullName;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public Date getCreatonDate() {
		return creatonDate;
	}

	public void setCreatonDate(Date creatonDate) {
		this.creatonDate = creatonDate;
	}

	public String getTagGlobalPractice() {
		return tagGlobalPractice;
	}

	public void setTagGlobalPractice(String tagGlobalPractice) {
		this.tagGlobalPractice = tagGlobalPractice;
	}

	public String getTagsEmailSent() {
		return tagsEmailSent;
	}

	public void setTagsEmailSent(String tagsEmailSent) {
		this.tagsEmailSent = tagsEmailSent;
	}

	public String getSkillComment() {
		return skillComment;
	}

	public void setSkillComment(String skillComment) {
		this.skillComment = skillComment;
	}

	public String getNeedReason() {
		return needReason;
	}

	public void setNeedReason(String needReason) {
		this.needReason = needReason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRecruitmentNeeds() {
		return recruitmentNeeds;
	}

	public void setRecruitmentNeeds(String recruitmentNeeds) {
		this.recruitmentNeeds = recruitmentNeeds;
	}

	public String getLeadTime() {
		return leadTime;
	}

	public void setLeadTime(String leadTime) {
		this.leadTime = leadTime;
	}

	public String getWeekByStatus() {
		return weekByStatus;
	}

	public void setWeekByStatus(String weekByStatus) {
		this.weekByStatus = weekByStatus;
	}


}
