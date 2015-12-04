package com.capgemini.job.portal.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cndt_ctg database table.
 * 
 */
@Entity
@Table(name="cndt_ctg")
@NamedQueries({
    @NamedQuery(name="cndtCtg.findCndtCtg",
                query="SELECT cndtCtg FROM CndtCtg cndtCtg where cndtCtg.cndtCtgId=:cndtCtgId")
}) 
public class CndtCtg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cndt_ctg_id")
	private int cndtCtgId;

	@Column(name="cndt_ctg_nm")
	private String cndtCtgNm;

	@Column(name="CREATE_DTS")
	private Timestamp createDts;

	@Column(name="CREATE_USR_ID")
	private String createUsrId;

	@Column(name="UPDT_DTS")
	private Timestamp updtDts;

	@Column(name="UPDT_USR_ID")
	private String updtUsrId;

	//bi-directional many-to-one association to JobCndt
	@OneToMany(mappedBy="cndtCtg")
	private List<JobCndt> jobCndts;

	public CndtCtg() {
	}

	public int getCndtCtgId() {
		return this.cndtCtgId;
	}

	public void setCndtCtgId(int cndtCtgId) {
		this.cndtCtgId = cndtCtgId;
	}

	public String getCndtCtgNm() {
		return this.cndtCtgNm;
	}

	public void setCndtCtgNm(String cndtCtgNm) {
		this.cndtCtgNm = cndtCtgNm;
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
		jobCndt.setCndtCtg(this);

		return jobCndt;
	}

	public JobCndt removeJobCndt(JobCndt jobCndt) {
		getJobCndts().remove(jobCndt);
		jobCndt.setCndtCtg(null);

		return jobCndt;
	}

}