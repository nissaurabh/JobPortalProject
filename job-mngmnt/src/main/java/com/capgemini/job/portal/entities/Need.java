/**
 * 
 */
package com.capgemini.job.portal.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author sryarlag
 *
 */

@Entity
@Table(name="wws_need_master")
public class Need implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="wws_id")
	private Integer wwsId;
	
	@Column(name="need_status")
	private String needStatus;
		
	@ManyToOne
	@JoinColumn(name="practice_id")
	private Practice practice;
	
	@ManyToOne
	@JoinColumn(name="location_id")
	private Location location;
	
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="grade_id")
	private Grade grade;
	
	@ManyToOne
	@JoinColumn(name="billability_id")
	private Billability billability;
	
	@OneToOne
	@JoinColumn(name="wws_skill_profile_id")
	private SkillProfile skillProfile;
	
	@OneToOne
	@JoinColumn(name="close_reason_id")
	private NeedCloseReason needCloseReason;
	
	@Column(name="close_comments")
	private String closeComments;
	
	@Column(name="project_start_dt")
	private Date projectStartDate;
	
	@Column(name="project_end_dt")
	private Date projectEndDate;
	
	@Column(name="close_dt")
	private Date needCloseDate;
	
	@Column(name="created_dt")
	private Date createdDate;
	
	@Column(name="updted_dt")
	private Date updatedDate;
	
	@Column(name="short_desc")
	private String shortDescription;
	
	
	public Integer getWwsId() {
		return wwsId;
	}

	public void setWwsId(Integer wwsId) {
		this.wwsId = wwsId;
	}

	public String getNeedStatus() {
		return needStatus;
	}

	public void setNeedStatus(String needStatus) {
		this.needStatus = needStatus;
	}

	public Practice getPractice() {
		return practice;
	}

	public void setPractice(Practice practice) {
		this.practice = practice;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Billability getBillability() {
		return billability;
	}

	public void setBillability(Billability billability) {
		this.billability = billability;
	}

	public SkillProfile getSkillProfile() {
		return skillProfile;
	}

	public void setSkillProfile(SkillProfile skillProfile) {
		this.skillProfile = skillProfile;
	}

	public NeedCloseReason getNeedCloseReason() {
		return needCloseReason;
	}

	public void setNeedCloseReason(NeedCloseReason needCloseReason) {
		this.needCloseReason = needCloseReason;
	}

	public String getCloseComments() {
		return closeComments;
	}

	public void setCloseComments(String closeComments) {
		this.closeComments = closeComments;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
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


	public Date getNeedCloseDate() {
		return needCloseDate;
	}

	public void setNeedCloseDate(Date needCloseDate) {
		this.needCloseDate = needCloseDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}


}
