package com.capgemini.job.portal.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the portal_user_role database table.
 * 
 */
@Entity
@Table(name="portal_user_role")
public class PortalUserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="role_name")
	private String roleName;

	@Column(name="CREATE_DTS")
	private Timestamp createDts;

	@Column(name="CREATE_USR_ID")
	private String createUsrId;

	@Column(name="default_candidate_dashboard")
	private String defaultCandidateDashboard;

	@Column(name="default_interview_dashboard")
	private String defaultInterviewDashboard;

	@Column(name="default_job_dashboard")
	private String defaultJobDashboard;

	@Column(name="UPDT_DTS")
	private Timestamp updtDts;

	@Column(name="UPDT_USR_ID")
	private String updtUsrId;

	//bi-directional many-to-one association to PortalUser
	@OneToMany(mappedBy="portalUserRole")
	private List<PortalUser> portalUsers;

	public PortalUserRole() {
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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

	public String getDefaultCandidateDashboard() {
		return this.defaultCandidateDashboard;
	}

	public void setDefaultCandidateDashboard(String defaultCandidateDashboard) {
		this.defaultCandidateDashboard = defaultCandidateDashboard;
	}

	public String getDefaultInterviewDashboard() {
		return this.defaultInterviewDashboard;
	}

	public void setDefaultInterviewDashboard(String defaultInterviewDashboard) {
		this.defaultInterviewDashboard = defaultInterviewDashboard;
	}

	public String getDefaultJobDashboard() {
		return this.defaultJobDashboard;
	}

	public void setDefaultJobDashboard(String defaultJobDashboard) {
		this.defaultJobDashboard = defaultJobDashboard;
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

	public List<PortalUser> getPortalUsers() {
		return this.portalUsers;
	}

	public void setPortalUsers(List<PortalUser> portalUsers) {
		this.portalUsers = portalUsers;
	}

	public PortalUser addPortalUser(PortalUser portalUser) {
		getPortalUsers().add(portalUser);
		portalUser.setPortalUserRole(this);

		return portalUser;
	}

	public PortalUser removePortalUser(PortalUser portalUser) {
		getPortalUsers().remove(portalUser);
		portalUser.setPortalUserRole(null);

		return portalUser;
	}

}