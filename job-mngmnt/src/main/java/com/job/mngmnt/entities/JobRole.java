package com.job.mngmnt.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the job_role database table.
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name="jobRole.findJobRole",
                query="SELECT jobRole FROM JobRole jobRole where jobRole.jobRlId=:jobRlId")
})
@Table(name="job_role")
public class JobRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="job_rl_id")
	private int jobRlId;

	@Column(name="CREATE_DTS")
	private Timestamp createDts;

	@Column(name="CREATE_USR_ID")
	private String createUsrId;

	@Column(name="job_rl_nm")
	private String jobRlNm;

	@Column(name="UPDT_DTS")
	private Timestamp updtDts;

	@Column(name="UPDT_USR_ID")
	private String updtUsrId;

	//bi-directional many-to-one association to Job
	@OneToMany(mappedBy="jobRole")
	private List<Job> jobs;

	//bi-directional many-to-one association to ServiceLnCap
	@ManyToOne
	@JoinColumn(name="srvc_ln_cap_id")
	private ServiceLnCap serviceLnCap;

	public JobRole() {
	}

	public int getJobRlId() {
		return this.jobRlId;
	}

	public void setJobRlId(int jobRlId) {
		this.jobRlId = jobRlId;
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

	public String getJobRlNm() {
		return this.jobRlNm;
	}

	public void setJobRlNm(String jobRlNm) {
		this.jobRlNm = jobRlNm;
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

	public List<Job> getJobs() {
		return this.jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public Job addJob(Job job) {
		getJobs().add(job);
		job.setJobRole(this);

		return job;
	}

	public Job removeJob(Job job) {
		getJobs().remove(job);
		job.setJobRole(null);

		return job;
	}

	public ServiceLnCap getServiceLnCap() {
		return this.serviceLnCap;
	}

	public void setServiceLnCap(ServiceLnCap serviceLnCap) {
		this.serviceLnCap = serviceLnCap;
	}

}