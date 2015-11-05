package com.job.mngmnt.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the job_sts database table.
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name="jobSt.findJobSt",
                query="SELECT jobSt FROM JobSt jobSt where jobSt.jobStsId=:jobStsId")
})
@Table(name="job_sts")
public class JobSt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="job_sts_id")
	private int jobStsId;

	@Column(name="CREATE_DTS")
	private Timestamp createDts;

	@Column(name="CREATE_USR_ID")
	private String createUsrId;

	@Column(name="job_sts_nm")
	private String jobStsNm;

	@Column(name="UPDT_DTS")
	private Timestamp updtDts;

	@Column(name="UPDT_USR_ID")
	private String updtUsrId;

	//bi-directional many-to-one association to Job
	@OneToMany(mappedBy="jobSt")
	private List<Job> jobs;

	public JobSt() {
	}

	public int getJobStsId() {
		return this.jobStsId;
	}

	public void setJobStsId(int jobStsId) {
		this.jobStsId = jobStsId;
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

	public String getJobStsNm() {
		return this.jobStsNm;
	}

	public void setJobStsNm(String jobStsNm) {
		this.jobStsNm = jobStsNm;
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
		job.setJobSt(this);

		return job;
	}

	public Job removeJob(Job job) {
		getJobs().remove(job);
		job.setJobSt(null);

		return job;
	}

}