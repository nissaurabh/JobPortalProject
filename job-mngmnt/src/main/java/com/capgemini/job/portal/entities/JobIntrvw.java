package com.capgemini.job.portal.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


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
	@ManyToOne
	@JoinColumn(name="cndt_id")
	private JobCndt jobCndt;

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

	public JobCndt getJobCndt() {
		return this.jobCndt;
	}

	public void setJobCndt(JobCndt jobCndt) {
		this.jobCndt = jobCndt;
	}

	public IntrvwSt getIntrvwSt() {
		return this.intrvwSt;
	}

	public void setIntrvwSt(IntrvwSt intrvwSt) {
		this.intrvwSt = intrvwSt;
	}

}