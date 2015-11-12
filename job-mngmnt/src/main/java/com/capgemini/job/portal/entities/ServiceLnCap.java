package com.capgemini.job.portal.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the service_ln_cap database table.
 * 
 */
@Entity
@Table(name="service_ln_cap")
public class ServiceLnCap implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="srvc_ln_cap_id")
	private int srvcLnCapId;

	@Column(name="CREATE_DTS")
	private Timestamp createDts;

	@Column(name="CREATE_USR_ID")
	private String createUsrId;

	@Column(name="srvc_ln_cap_nm")
	private String srvcLnCapNm;

	@Column(name="UPDT_DTS")
	private Timestamp updtDts;

	@Column(name="UPDT_USR_ID")
	private String updtUsrId;

	//bi-directional many-to-one association to JobRole
	@OneToMany(mappedBy="serviceLnCap")
	private List<JobRole> jobRoles;

	//bi-directional many-to-one association to ServiceLn
	@ManyToOne
	@JoinColumn(name="srvc_ln_id")
	private ServiceLn serviceLn;

	public ServiceLnCap() {
	}

	public int getSrvcLnCapId() {
		return this.srvcLnCapId;
	}

	public void setSrvcLnCapId(int srvcLnCapId) {
		this.srvcLnCapId = srvcLnCapId;
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

	public String getSrvcLnCapNm() {
		return this.srvcLnCapNm;
	}

	public void setSrvcLnCapNm(String srvcLnCapNm) {
		this.srvcLnCapNm = srvcLnCapNm;
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

	public List<JobRole> getJobRoles() {
		return this.jobRoles;
	}

	public void setJobRoles(List<JobRole> jobRoles) {
		this.jobRoles = jobRoles;
	}

	public JobRole addJobRole(JobRole jobRole) {
		getJobRoles().add(jobRole);
		jobRole.setServiceLnCap(this);

		return jobRole;
	}

	public JobRole removeJobRole(JobRole jobRole) {
		getJobRoles().remove(jobRole);
		jobRole.setServiceLnCap(null);

		return jobRole;
	}

	public ServiceLn getServiceLn() {
		return this.serviceLn;
	}

	public void setServiceLn(ServiceLn serviceLn) {
		this.serviceLn = serviceLn;
	}

}