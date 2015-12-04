package com.capgemini.job.portal.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cndt_sts database table.
 * 
 */
@Entity
@Table(name="cndt_sts")
@NamedQueries({
    @NamedQuery(name="cndtSt.findCndtSt",
                query="SELECT cndtSt FROM CndtSt cndtSt where cndtSt.cndtStsId=:cndtStsId")
}) 
public class CndtSt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cndt_sts_id")
	private int cndtStsId;

	@Column(name="cndt_sts_nm")
	private String cndtStsNm;

	@Column(name="CREATE_DTS")
	private Timestamp createDts;

	@Column(name="CREATE_USR_ID")
	private String createUsrId;

	@Column(name="UPDT_DTS")
	private Timestamp updtDts;

	@Column(name="UPDT_USR_ID")
	private String updtUsrId;

	//bi-directional many-to-one association to JobCndt
	@OneToMany(mappedBy="cndtSt")
	private List<JobCndt> jobCndts;

	public CndtSt() {
	}

	public int getCndtStsId() {
		return this.cndtStsId;
	}

	public void setCndtStsId(int cndtStsId) {
		this.cndtStsId = cndtStsId;
	}

	public String getCndtStsNm() {
		return this.cndtStsNm;
	}

	public void setCndtStsNm(String cndtStsNm) {
		this.cndtStsNm = cndtStsNm;
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

	public List<JobCndt> getJobCndts() {
		return this.jobCndts;
	}

	public void setJobCndts(List<JobCndt> jobCndts) {
		this.jobCndts = jobCndts;
	}

	public JobCndt addJobCndt(JobCndt jobCndt) {
		getJobCndts().add(jobCndt);
		jobCndt.setCndtSt(this);

		return jobCndt;
	}

	public JobCndt removeJobCndt(JobCndt jobCndt) {
		getJobCndts().remove(jobCndt);
		jobCndt.setCndtSt(null);

		return jobCndt;
	}

}