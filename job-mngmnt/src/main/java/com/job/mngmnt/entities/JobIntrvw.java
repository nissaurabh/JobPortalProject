package com.job.mngmnt.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the job_intrvw database table.
 * 
 */
@Entity
@Table(name="job_intrvw")
public class JobIntrvw implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="job_intrvw_id")
	private int jobIntrvwId;

	@Lob
	@Column(name="intrvr_cmnts")
	private String intrvrCmnts;

	@Column(name="intrvr_nm")
	private String intrvrNm;

	@Column(name="intrvr_pos")
	private String intrvrPos;

	@Column(name="intrvw_tm")
	private Timestamp intrvwTm;

	//bi-directional many-to-one association to JobCndt
	@OneToMany(mappedBy="jobIntrvw")
	private List<JobCndt> jobCndts;

	//bi-directional many-to-one association to IntrvwSt
	@ManyToOne
	@JoinColumn(name="intrvw_sts_id")
	private IntrvwSt intrvwSt;

	public JobIntrvw() {
	}

	public int getJobIntrvwId() {
		return this.jobIntrvwId;
	}

	public void setJobIntrvwId(int jobIntrvwId) {
		this.jobIntrvwId = jobIntrvwId;
	}

	public String getIntrvrCmnts() {
		return this.intrvrCmnts;
	}

	public void setIntrvrCmnts(String intrvrCmnts) {
		this.intrvrCmnts = intrvrCmnts;
	}

	public String getIntrvrNm() {
		return this.intrvrNm;
	}

	public void setIntrvrNm(String intrvrNm) {
		this.intrvrNm = intrvrNm;
	}

	public String getIntrvrPos() {
		return this.intrvrPos;
	}

	public void setIntrvrPos(String intrvrPos) {
		this.intrvrPos = intrvrPos;
	}

	public Timestamp getIntrvwTm() {
		return this.intrvwTm;
	}

	public void setIntrvwTm(Timestamp intrvwTm) {
		this.intrvwTm = intrvwTm;
	}

	public List<JobCndt> getJobCndts() {
		return this.jobCndts;
	}

	public void setJobCndts(List<JobCndt> jobCndts) {
		this.jobCndts = jobCndts;
	}

	public JobCndt addJobCndt(JobCndt jobCndt) {
		getJobCndts().add(jobCndt);
		jobCndt.setJobIntrvw(this);

		return jobCndt;
	}

	public JobCndt removeJobCndt(JobCndt jobCndt) {
		getJobCndts().remove(jobCndt);
		jobCndt.setJobIntrvw(null);

		return jobCndt;
	}

	public IntrvwSt getIntrvwSt() {
		return this.intrvwSt;
	}

	public void setIntrvwSt(IntrvwSt intrvwSt) {
		this.intrvwSt = intrvwSt;
	}

}