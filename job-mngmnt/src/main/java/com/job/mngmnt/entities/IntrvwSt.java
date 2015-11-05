package com.job.mngmnt.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the intrvw_sts database table.
 * 
 */
@Entity
@Table(name="intrvw_sts")
public class IntrvwSt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="intrvw_sts_id")
	private int intrvwStsId;

	@Column(name="CREATE_DTS")
	private Timestamp createDts;

	@Column(name="CREATE_USR_ID")
	private String createUsrId;

	@Column(name="intrvw_sts_nm")
	private String intrvwStsNm;

	@Column(name="UPDT_DTS")
	private Timestamp updtDts;

	@Column(name="UPDT_USR_ID")
	private String updtUsrId;

	//bi-directional many-to-one association to JobIntrvw
	@OneToMany(mappedBy="intrvwSt")
	private List<JobIntrvw> jobIntrvws;

	public IntrvwSt() {
	}

	public int getIntrvwStsId() {
		return this.intrvwStsId;
	}

	public void setIntrvwStsId(int intrvwStsId) {
		this.intrvwStsId = intrvwStsId;
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

	public String getIntrvwStsNm() {
		return this.intrvwStsNm;
	}

	public void setIntrvwStsNm(String intrvwStsNm) {
		this.intrvwStsNm = intrvwStsNm;
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

	public List<JobIntrvw> getJobIntrvws() {
		return this.jobIntrvws;
	}

	public void setJobIntrvws(List<JobIntrvw> jobIntrvws) {
		this.jobIntrvws = jobIntrvws;
	}

	public JobIntrvw addJobIntrvw(JobIntrvw jobIntrvw) {
		getJobIntrvws().add(jobIntrvw);
		jobIntrvw.setIntrvwSt(this);

		return jobIntrvw;
	}

	public JobIntrvw removeJobIntrvw(JobIntrvw jobIntrvw) {
		getJobIntrvws().remove(jobIntrvw);
		jobIntrvw.setIntrvwSt(null);

		return jobIntrvw;
	}

}