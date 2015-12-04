package com.capgemini.job.portal.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the empl_typ database table.
 * 
 */
@Entity
@Table(name="empl_typ")
@NamedQueries({
    @NamedQuery(name="emplTyp.findEmplTyp",
                query="SELECT emplTyp FROM EmplTyp emplTyp where emplTyp.emptTypId=:emptTypId")
})
public class EmplTyp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="empt_typ_id")
	private int emptTypId;

	@Column(name="CREATE_DTS")
	private Timestamp createDts;

	@Column(name="CREATE_USR_ID")
	private String createUsrId;

	@Column(name="empt_typ_nm")
	private String emptTypNm;

	@Column(name="UPDT_DTS")
	private String updtDts;

	@Column(name="UPDT_USR_ID")
	private String updtUsrId;

	//bi-directional many-to-one association to Job
	@OneToMany(mappedBy="emplTyp")
	private List<Job> jobs;

	public EmplTyp() {
	}

	public int getEmptTypId() {
		return this.emptTypId;
	}

	public void setEmptTypId(int emptTypId) {
		this.emptTypId = emptTypId;
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

	public String getEmptTypNm() {
		return this.emptTypNm;
	}

	public void setEmptTypNm(String emptTypNm) {
		this.emptTypNm = emptTypNm;
	}

	public String getUpdtDts() {
		return this.updtDts;
	}

	public void setUpdtDts(String updtDts) {
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
		job.setEmplTyp(this);

		return job;
	}

	public Job removeJob(Job job) {
		getJobs().remove(job);
		job.setEmplTyp(null);

		return job;
	}

}