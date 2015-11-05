package com.job.mngmnt.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the job database table.
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name="job.findJob",
                query="SELECT job FROM Job job where job.jobId=:jobId")
}) 
public class Job implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="job_id")
	private int jobId;

	@Column(name="chrg_out_rt")
	private int chrgOutRt;

	@Column(name="clsr_dt")
	private Timestamp clsrDt;

	@Column(name="cntrt_rt")
	private int cntrtRt;

	@Column(name="CREATE_DTS")
	private Timestamp createDts;

	@Column(name="CREATE_USR_ID")
	private String createUsrId;

	@Column(name="crtr_rm")
	private String crtrRm;

	@Column(name="opn_dt")
	private Timestamp opnDt;

	@Column(name="own_rm")
	private String ownRm;

	@Column(name="prsnt_dt")
	private Timestamp prsntDt;

	@Column(name="req_dt")
	private Timestamp reqDt;

	@Column(name="reqmnt_spc")
	private String reqmntSpc;

	@Column(name="reqstr_rm")
	private String reqstrRm;

	@Column(name="resr_cnt")
	private int resrCnt;

	@Column(name="rl_end_dt")
	private Timestamp rlEndDt;

	@Column(name="rl_str_dt")
	private Timestamp rlStrDt;

	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private Boolean trvl;

	@Column(name="UPDT_DTS")
	private Timestamp updtDts;

	@Column(name="UPDT_USR_ID")
	private String updtUsrId;

	//bi-directional many-to-one association to Account
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="clnt_id")
	private Account account;

	//bi-directional many-to-one association to EmptTyp
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="empt_typ_id")
	private EmplTyp emptTyp;

	//bi-directional many-to-one association to JobRole
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="job_rl_id")
	private JobRole jobRole;

	//bi-directional many-to-one association to JobStg
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="job_stg_id")
	private JobStg jobStg;

	//bi-directional many-to-one association to JobSt
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="job_sts_id")
	private JobSt jobSt;

	//bi-directional many-to-one association to JobCndt
	@OneToMany(mappedBy="job")
	private List<JobCndt> jobCndts;

	public Job() {
	}

	public int getJobId() {
		return this.jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public int getChrgOutRt() {
		return this.chrgOutRt;
	}

	public void setChrgOutRt(int chrgOutRt) {
		this.chrgOutRt = chrgOutRt;
	}

	public Timestamp getClsrDt() {
		return this.clsrDt;
	}

	public void setClsrDt(Timestamp clsrDt) {
		this.clsrDt = clsrDt;
	}

	public int getCntrtRt() {
		return this.cntrtRt;
	}

	public void setCntrtRt(int cntrtRt) {
		this.cntrtRt = cntrtRt;
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

	public String getCrtrRm() {
		return this.crtrRm;
	}

	public void setCrtrRm(String crtrRm) {
		this.crtrRm = crtrRm;
	}

	public Timestamp getOpnDt() {
		return this.opnDt;
	}

	public void setOpnDt(Timestamp opnDt) {
		this.opnDt = opnDt;
	}

	public String getOwnRm() {
		return this.ownRm;
	}

	public void setOwnRm(String ownRm) {
		this.ownRm = ownRm;
	}

	public Timestamp getPrsntDt() {
		return this.prsntDt;
	}

	public void setPrsntDt(Timestamp prsntDt) {
		this.prsntDt = prsntDt;
	}

	public Timestamp getReqDt() {
		return this.reqDt;
	}

	public void setReqDt(Timestamp reqDt) {
		this.reqDt = reqDt;
	}

	public String getReqmntSpc() {
		return this.reqmntSpc;
	}

	public void setReqmntSpc(String reqmntSpc) {
		this.reqmntSpc = reqmntSpc;
	}

	public String getReqstrRm() {
		return this.reqstrRm;
	}

	public void setReqstrRm(String reqstrRm) {
		this.reqstrRm = reqstrRm;
	}

	public int getResrCnt() {
		return this.resrCnt;
	}

	public void setResrCnt(int resrCnt) {
		this.resrCnt = resrCnt;
	}

	public Timestamp getRlEndDt() {
		return this.rlEndDt;
	}

	public void setRlEndDt(Timestamp rlEndDt) {
		this.rlEndDt = rlEndDt;
	}

	public Timestamp getRlStrDt() {
		return this.rlStrDt;
	}

	public void setRlStrDt(Timestamp rlStrDt) {
		this.rlStrDt = rlStrDt;
	}

	public Boolean getTrvl() {
		return this.trvl;
	}

	public void setTrvl(Boolean trvl) {
		this.trvl = trvl;
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

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public EmplTyp getEmptTyp() {
		return this.emptTyp;
	}

	public void setEmptTyp(EmplTyp emptTyp) {
		this.emptTyp = emptTyp;
	}

	public JobRole getJobRole() {
		return this.jobRole;
	}

	public void setJobRole(JobRole jobRole) {
		this.jobRole = jobRole;
	}

	public JobStg getJobStg() {
		return this.jobStg;
	}

	public void setJobStg(JobStg jobStg) {
		this.jobStg = jobStg;
	}

	public JobSt getJobSt() {
		return this.jobSt;
	}

	public void setJobSt(JobSt jobSt) {
		this.jobSt = jobSt;
	}

	public List<JobCndt> getJobCndts() {
		return this.jobCndts;
	}

	public void setJobCndts(List<JobCndt> jobCndts) {
		this.jobCndts = jobCndts;
	}

	public JobCndt addJobCndt(JobCndt jobCndt) {
		getJobCndts().add(jobCndt);
		jobCndt.setJob(this);

		return jobCndt;
	}

	public JobCndt removeJobCndt(JobCndt jobCndt) {
		getJobCndts().remove(jobCndt);
		jobCndt.setJob(null);

		return jobCndt;
	}

}