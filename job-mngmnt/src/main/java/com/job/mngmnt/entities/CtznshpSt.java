package com.job.mngmnt.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ctznshp_sts database table.
 * 
 */
@Entity
@Table(name="ctznshp_sts")
public class CtznshpSt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ctzn_shp_id")
	private int ctznShpId;

	@Column(name="CREATE_DTS")
	private Timestamp createDts;

	@Column(name="CREATE_USR_ID")
	private String createUsrId;

	@Column(name="ctzn_shp_nm")
	private String ctznShpNm;

	@Column(name="UPDT_DTS")
	private Timestamp updtDts;

	@Column(name="UPDT_USR_ID")
	private String updtUsrId;

	//bi-directional many-to-one association to JobCndt
	@OneToMany(mappedBy="ctznshpSt")
	private List<JobCndt> jobCndts;

	public CtznshpSt() {
	}

	public int getCtznShpId() {
		return this.ctznShpId;
	}

	public void setCtznShpId(int ctznShpId) {
		this.ctznShpId = ctznShpId;
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

	public String getCtznShpNm() {
		return this.ctznShpNm;
	}

	public void setCtznShpNm(String ctznShpNm) {
		this.ctznShpNm = ctznShpNm;
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
		jobCndt.setCtznshpSt(this);

		return jobCndt;
	}

	public JobCndt removeJobCndt(JobCndt jobCndt) {
		getJobCndts().remove(jobCndt);
		jobCndt.setCtznshpSt(null);

		return jobCndt;
	}

}