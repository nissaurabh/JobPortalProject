package com.capgemini.job.portal.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the account database table.
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name="account.findAccount",
                query="SELECT acct FROM Account acct where acct.clntId=:clntId"),
   @NamedQuery(name="account.getAccount",
                query="SELECT acct FROM Account acct")
}) 
@Table(name="account")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="clnt_id")
	private int clntId;

	@Column(name="clnt_nm")
	private String clntNm;

	@Column(name="CREATE_DTS")
	private Timestamp createDts;

	@Column(name="CREATE_USR_ID")
	private String createUsrId;

	@Column(name="UPDT_DTS")
	private Timestamp updtDts;

	@Column(name="UPDT_USR_ID")
	private String updtUsrId;

	//bi-directional many-to-one association to Job
	@OneToMany(mappedBy="account")
	private List<Job> jobs;

	public Account() {
	}

	public int getClntId() {
		return this.clntId;
	}

	public void setClntId(int clntId) {
		this.clntId = clntId;
	}

	public String getClntNm() {
		return this.clntNm;
	}

	public void setClntNm(String clntNm) {
		this.clntNm = clntNm;
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
		job.setAccount(this);

		return job;
	}

	public Job removeJob(Job job) {
		getJobs().remove(job);
		job.setAccount(null);

		return job;
	}

}