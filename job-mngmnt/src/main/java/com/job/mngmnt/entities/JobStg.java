package com.job.mngmnt.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the job_stg database table.
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name="jobStg.findJobStgId",
                query="SELECT jobStg FROM JobStg jobStg where jobStg.jobStgId=:jobStgId")
})
@Table(name="job_stg")
public class JobStg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="job_stg_id")
	private int jobStgId;

	@Column(name="CREATE_DTS")
	private Timestamp createDts;

	@Column(name="CREATE_USR_ID")
	private String createUsrId;

	@Column(name="job_stg_nm")
	private String jobStgNm;

	@Column(name="UPDT_DTS")
	private Timestamp updtDts;

	@Column(name="UPDT_USR_ID")
	private String updtUsrId;

	//bi-directional many-to-one association to Job
	@OneToMany(mappedBy="jobStg")
	private List<Job> jobs;

	public JobStg() {
	}

	public int getJobStgId() {
		return this.jobStgId;
	}

	public void setJobStgId(int jobStgId) {
		this.jobStgId = jobStgId;
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

	public String getJobStgNm() {
		return this.jobStgNm;
	}

	public void setJobStgNm(String jobStgNm) {
		this.jobStgNm = jobStgNm;
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
		job.setJobStg(this);

		return job;
	}

	public Job removeJob(Job job) {
		getJobs().remove(job);
		job.setJobStg(null);

		return job;
	}

}