package com.capgemini.job.portal.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the job_cndt database table.
 * 
 */
@Entity
@Table(name="job_cndt")
@NamedQueries({
    @NamedQuery(name="jobCndt.findJobCndt",
                query="SELECT jobCndt FROM JobCndt jobCndt where jobCndt.cndtId=:cndtId"),
    @NamedQuery(name="jobCndt.findByJobIdAndJobCndtId",
                query="SELECT jobCndt FROM JobCndt jobCndt where jobCndt.cndtId=:cndtId"
                + " and jobCndt.job.jobId=:jobId")            
}) 
public class JobCndt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cndt_id")
	private int cndtId;

	@Column(name="act_join_dt")
	private Timestamp actJoinDt;

	@Column(name="bu_ld_appr")
	private Boolean buLdAppr;

	@Column(name="cap_ld_appr")
	private Boolean capLdAppr;

	@Column(name="cndt_nm")
	private String cndtNm;

	@Lob
	@Column(name="cndt_rsm")
	private byte[] cndtRsm;

	@Column(name="cntrctr_rt")
	private String cntrctrRt;

	@Column(name="CREATE_DTS")
	private Timestamp createDts;

	@Column(name="CREATE_USR_ID")
	private String createUsrId;

	@Column(name="join_dt")
	private Timestamp joinDt;

	@Column(name="offr_acpt_dt")
	private Timestamp offrAcptDt;

	@Column(name="offr_dt")
	private Timestamp offrDt;

	@Column(name="prmy_sk")
	private String prmySk;

	@Column(name="UPDT_DTS")
	private Timestamp updtDts;

	@Column(name="UPDT_USR_ID")
	private String updtUsrId;

	//bi-directional many-to-one association to CndtCtg
	@ManyToOne
	@JoinColumn(name="cndt_ctg_id")
	private CndtCtg cndtCtg;

	//bi-directional many-to-one association to CndtSt
	@ManyToOne
	@JoinColumn(name="cndt_sts_id")
	private CndtSt cndtSt;

	//bi-directional many-to-one association to CtznshpSt
	@ManyToOne
	@JoinColumn(name="ctzn_shp_id")
	private CtznshpSt ctznshpSt;

	//bi-directional many-to-one association to Job
	@ManyToOne
	@JoinColumn(name="job_id")
	private Job job;

	//bi-directional many-to-one association to ResourceTyp
	@ManyToOne
	@JoinColumn(name="res_typ_id")
	private ResourceTyp resourceTyp;

	//bi-directional many-to-one association to JobIntrvw
	@OneToMany(mappedBy="jobCndt")
	private List<JobIntrvw> jobIntrvws;

	public JobCndt() {
	}

	public int getCndtId() {
		return this.cndtId;
	}

	public void setCndtId(int cndtId) {
		this.cndtId = cndtId;
	}

	public Timestamp getActJoinDt() {
		return this.actJoinDt;
	}

	public void setActJoinDt(Timestamp actJoinDt) {
		this.actJoinDt = actJoinDt;
	}

	public Boolean getBuLdAppr() {
		return this.buLdAppr;
	}

	public void setBuLdAppr(Boolean buLdAppr) {
		this.buLdAppr = buLdAppr;
	}

	public Boolean getCapLdAppr() {
		return this.capLdAppr;
	}

	public void setCapLdAppr(Boolean capLdAppr) {
		this.capLdAppr = capLdAppr;
	}

	public String getCndtNm() {
		return this.cndtNm;
	}

	public void setCndtNm(String cndtNm) {
		this.cndtNm = cndtNm;
	}

	public byte[] getCndtRsm() {
		return this.cndtRsm;
	}

	public void setCndtRsm(byte[] cndtRsm) {
		this.cndtRsm = cndtRsm;
	}

	public String getCntrctrRt() {
		return this.cntrctrRt;
	}

	public void setCntrctrRt(String cntrctrRt) {
		this.cntrctrRt = cntrctrRt;
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

	public Timestamp getJoinDt() {
		return this.joinDt;
	}

	public void setJoinDt(Timestamp joinDt) {
		this.joinDt = joinDt;
	}

	public Timestamp getOffrAcptDt() {
		return this.offrAcptDt;
	}

	public void setOffrAcptDt(Timestamp offrAcptDt) {
		this.offrAcptDt = offrAcptDt;
	}

	public Timestamp getOffrDt() {
		return this.offrDt;
	}

	public void setOffrDt(Timestamp offrDt) {
		this.offrDt = offrDt;
	}

	public String getPrmySk() {
		return this.prmySk;
	}

	public void setPrmySk(String prmySk) {
		this.prmySk = prmySk;
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

	public CndtCtg getCndtCtg() {
		return this.cndtCtg;
	}

	public void setCndtCtg(CndtCtg cndtCtg) {
		this.cndtCtg = cndtCtg;
	}

	public CndtSt getCndtSt() {
		return this.cndtSt;
	}

	public void setCndtSt(CndtSt cndtSt) {
		this.cndtSt = cndtSt;
	}

	public CtznshpSt getCtznshpSt() {
		return this.ctznshpSt;
	}

	public void setCtznshpSt(CtznshpSt ctznshpSt) {
		this.ctznshpSt = ctznshpSt;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public ResourceTyp getResourceTyp() {
		return this.resourceTyp;
	}

	public void setResourceTyp(ResourceTyp resourceTyp) {
		this.resourceTyp = resourceTyp;
	}

	public List<JobIntrvw> getJobIntrvws() {
		return this.jobIntrvws;
	}

	public void setJobIntrvws(List<JobIntrvw> jobIntrvws) {
		this.jobIntrvws = jobIntrvws;
	}

	public JobIntrvw addJobIntrvw(JobIntrvw jobIntrvw) {
		getJobIntrvws().add(jobIntrvw);
		jobIntrvw.setJobCndt(this);

		return jobIntrvw;
	}

	public JobIntrvw removeJobIntrvw(JobIntrvw jobIntrvw) {
		getJobIntrvws().remove(jobIntrvw);
		jobIntrvw.setJobCndt(null);

		return jobIntrvw;
	}

}