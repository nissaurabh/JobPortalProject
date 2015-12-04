package com.capgemini.job.portal.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the portal_user database table.
 * 
 */
@Entity
@Table(name="portal_user")
public class PortalUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_id")
	private String userId;

	@Column(name="candidate_dashboard")
	private String candidateDashboard;

	@Column(name="CREATE_DTS")
	private Timestamp createDts;

	@Column(name="CREATE_USR_ID")
	private String createUsrId;

	@Column(name="interview_dashboard")
	private String interviewDashboard;

	@Column(name="job_dashboard")
	private String jobDashboard;

	private String password;

	@Column(name="UPDT_DTS")
	private Timestamp updtDts;

	@Column(name="UPDT_USR_ID")
	private String updtUsrId;

	@Column(name="user_name")
	private String userName;

	//bi-directional many-to-one association to PortalUserRole
	@ManyToOne
	@JoinColumn(name="role_name")
	private PortalUserRole portalUserRole;

	public PortalUser() {
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCandidateDashboard() {
		return this.candidateDashboard;
	}

	public void setCandidateDashboard(String candidateDashboard) {
		this.candidateDashboard = candidateDashboard;
	}

	public Timestamp getCreateDts() {
		return this.createDts;
	}

	public void setCreateDts(Timestamp createDts) {
		this.createDts = createDts;
	}

	public String getCreateUsrId() {
		return this.createUsrId;
	}

	public void setCreateUsrId(String createUsrId) {
		this.createUsrId = createUsrId;
	}

	public String getInterviewDashboard() {
		return this.interviewDashboard;
	}

	public void setInterviewDashboard(String interviewDashboard) {
		this.interviewDashboard = interviewDashboard;
	}

	public String getJobDashboard() {
		return this.jobDashboard;
	}

	public void setJobDashboard(String jobDashboard) {
		this.jobDashboard = jobDashboard;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getUpdtDts() {
		return this.updtDts;
	}

	public void setUpdtDts(Timestamp updtDts) {
		this.updtDts = updtDts;
	}

	public String getUpdtUsrId() {
		return this.updtUsrId;
	}

	public void setUpdtUsrId(String updtUsrId) {
		this.updtUsrId = updtUsrId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public PortalUserRole getPortalUserRole() {
		return this.portalUserRole;
	}

	public void setPortalUserRole(PortalUserRole portalUserRole) {
		this.portalUserRole = portalUserRole;
	}

}