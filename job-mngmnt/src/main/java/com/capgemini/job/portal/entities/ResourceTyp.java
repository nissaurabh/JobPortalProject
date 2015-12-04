package com.capgemini.job.portal.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the resource_typ database table.
 * 
 */
@Entity
@Table(name="resource_typ")
@NamedQueries({
    @NamedQuery(name="resourceTyp.findResourceTyp",
                query="SELECT resourceTyp FROM ResourceTyp resourceTyp where resourceTyp.resTypId=:resTypId")
}) 
public class ResourceTyp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="res_typ_id")
	private int resTypId;

	@Column(name="CREATE_DTS")
	private Timestamp createDts;

	@Column(name="CREATE_USR_ID")
	private String createUsrId;

	@Column(name="res_typ_nm")
	private String resTypNm;

	@Column(name="UPDT_DTS")
	private Timestamp updtDts;

	@Column(name="UPDT_USR_ID")
	private String updtUsrId;

	//bi-directional many-to-one association to JobCndt
	@OneToMany(mappedBy="resourceTyp")
	private List<JobCndt> jobCndts;

	public ResourceTyp() {
	}

	public int getResTypId() {
		return this.resTypId;
	}

	public void setResTypId(int resTypId) {
		this.resTypId = resTypId;
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

	public String getResTypNm() {
		return this.resTypNm;
	}

	public void setResTypNm(String resTypNm) {
		this.resTypNm = resTypNm;
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

	public List<JobCndt> getJobCndts() {
		return this.jobCndts;
	}

	public void setJobCndts(List<JobCndt> jobCndts) {
		this.jobCndts = jobCndts;
	}

	public JobCndt addJobCndt(JobCndt jobCndt) {
		getJobCndts().add(jobCndt);
		jobCndt.setResourceTyp(this);

		return jobCndt;
	}

	public JobCndt removeJobCndt(JobCndt jobCndt) {
		getJobCndts().remove(jobCndt);
		jobCndt.setResourceTyp(null);

		return jobCndt;
	}

}