package com.job.mngmnt.service.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.job.mmngmnt.jaxb.JobDetails;
import com.job.mngmnt.dao.JobDetailsDAO;
import com.job.mngmnt.entities.Account;
import com.job.mngmnt.entities.EmplTyp;
import com.job.mngmnt.entities.Job;
import com.job.mngmnt.entities.JobRole;
import com.job.mngmnt.entities.JobSt;
import com.job.mngmnt.entities.JobStg;
import com.job.mngmnt.service.JobDetailsService;
import com.job.mngmnt.util.DateUtil;

@Component("jobDetailsService")
public class JobDetailsServiceImpl implements JobDetailsService {

	@Autowired
	private JobDetailsDAO jobDetailsDAO;

	@Transactional
	public void createJob(JobDetails jobDetails) {
		Job job = populateJobDetails(jobDetails);
		jobDetailsDAO.storeJob(job);
	}

	/*
	 * private Job populateJobDetails(JobDetails jobDetails) { Job job = new
	 * Job(); JSONObject jobJsonObject = JSONObject.getJSONObject(jobDetails);
	 * 
	 * Account account = retrieveAccount(jobJsonObject.getInt("accountId"));
	 * job.setAccount(account);
	 * 
	 * EmplTyp emplTyp = job.getEmptTyp();
	 * emplTyp.setEmptTypId(jobJsonObject.getInt("employementTypeId"));
	 * job.setEmptTyp(emplTyp);
	 * 
	 * JobRole jobRole = job.getJobRole();
	 * jobRole.setJobRlId(jobJsonObject.getInt("roleId"));
	 * job.setJobRole(jobRole);
	 * 
	 * JobSt jobSt = job.getJobSt();
	 * jobSt.setJobStsId(jobJsonObject.getInt("jobStatusId"));
	 * job.setJobSt(jobSt);
	 * 
	 * JobStg jobStg = job.getJobStg();
	 * jobStg.setJobStgId(jobJsonObject.getInt("jobStageId"));
	 * job.setJobStg(jobStg);
	 * 
	 * job.setChrgOutRt(jobJsonObject.getInt("chargeOutRate"));
	 * 
	 * job.setClsrDt(DateUtil.convertStringToTimestamp(jobJsonObject.getString(
	 * "closureDate")));
	 * 
	 * job.setCntrtRt(jobJsonObject.getInt("contractorRate"));
	 * 
	 * job.setCrtrRm(jobJsonObject.getString("creatorRM"));
	 * 
	 * job.setOpnDt(DateUtil.convertStringToTimestamp(jobJsonObject.getString(
	 * "openDate")));
	 * 
	 * job.setOwnRm(jobJsonObject.getString("owningRM"));
	 * 
	 * job.setPrsntDt(DateUtil.convertStringToTimestamp(jobJsonObject.getString(
	 * "presentedDate")));
	 * 
	 * job.setReqDt(DateUtil.convertStringToTimestamp(jobJsonObject.getString(
	 * "requestedDate")));
	 * 
	 * job.setReqmntSpc(jobJsonObject.getString("requirementSpecifics"));
	 * 
	 * job.setReqstrRm(jobJsonObject.getString("requestorRM"));
	 * 
	 * job.setResrCnt(jobJsonObject.getInt("contractorRate"));
	 * 
	 * job.setTrvl(Boolean.valueOf(jobJsonObject.getString("requirementSpecifics"
	 * )));
	 * 
	 * job.setRlStrDt(DateUtil.convertStringToTimestamp(jobJsonObject.getString(
	 * "openDate")));
	 * 
	 * job.setRlEndDt(DateUtil.convertStringToTimestamp(jobJsonObject.getString(
	 * "openDate")));
	 * 
	 * job.setCreateDts(new Timestamp(System.currentTimeMillis()));
	 * job.setCreateUsrId("jobmngmnt"); job.setUpdtDts(new
	 * Timestamp(System.currentTimeMillis())); job.setUpdtUsrId("jobmngmnt");
	 * 
	 * return job; }
	 */

	private Job populateJobDetails(JobDetails jobDetails) {
		Job job = new Job();

		Account account = getAccount(Integer.parseInt(jobDetails
				.getAccountId()));
		
		job.setAccount(account);

		EmplTyp emplTyp = getEmplTyp(Integer.parseInt(jobDetails.getEmployementTypeId()));
		job.setEmptTyp(emplTyp);

		JobRole jobRole = getJobRole(Integer.parseInt(jobDetails.getRoleId()));
		job.setJobRole(jobRole);

		JobSt jobSt = getJobStatus(Integer.parseInt(jobDetails.getJobStatusId()));
		job.setJobSt(jobSt);

		JobStg jobStg = getJobStage(Integer.parseInt(jobDetails.getJobStageId()));
		job.setJobStg(jobStg);

		job.setChrgOutRt(Integer.parseInt(jobDetails.getChargeOutRate()));

		job.setClsrDt(DateUtil.convertStringToTimestamp(jobDetails
				.getClosureDate()));

		job.setCntrtRt(Integer.parseInt(jobDetails.getContractorRate()));

		job.setCrtrRm(jobDetails.getCreatorRM());

		job.setOpnDt(DateUtil.convertStringToTimestamp(jobDetails.getOpenDate()));

		job.setOwnRm(jobDetails.getOwningRM());

		job.setPrsntDt(DateUtil.convertStringToTimestamp(jobDetails
				.getPresentedDate()));

		job.setReqDt(DateUtil.convertStringToTimestamp(jobDetails
				.getRequestedDate()));

		job.setReqmntSpc(jobDetails.getRequirementSpecifics());

		job.setReqstrRm(jobDetails.getRequestorRM());

		job.setResrCnt(Integer.parseInt(jobDetails.getResourceCount()));

		job.setTrvl(Boolean.valueOf(jobDetails.getTravel()));

		job.setRlStrDt(DateUtil.convertStringToTimestamp(jobDetails
				.getRoleStartDate()));

		job.setRlEndDt(DateUtil.convertStringToTimestamp(jobDetails
				.getRoleEndDate()));

		job.setCreateDts(new Timestamp(System.currentTimeMillis()));
		job.setCreateUsrId("jobmngmnt");
		job.setUpdtDts(new Timestamp(System.currentTimeMillis()));
		job.setUpdtUsrId("jobmngmnt");

		return job;
	}

	public Account getAccount(int acctId) {

		return jobDetailsDAO.getAccount(acctId);
	}

	public EmplTyp getEmplTyp(int emptTypId) {

		return jobDetailsDAO.getEmplTyp(emptTypId);
	}

	public JobRole getJobRole(int jobRlId) {

		return jobDetailsDAO.getJobRole(jobRlId);
	}

	public JobSt getJobStatus(int jobStsId) {

		return jobDetailsDAO.getJobStatus(jobStsId);
	}

	public JobStg getJobStage(int jobStgId) {

		return jobDetailsDAO.getJobStage(jobStgId);
	}

}
