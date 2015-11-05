package com.job.mngmnt.service.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.job.mngmnt.dao.JobDetailsDAO;
import com.job.mngmnt.entities.Account;
import com.job.mngmnt.entities.EmplTyp;
import com.job.mngmnt.entities.Job;
import com.job.mngmnt.entities.JobRole;
import com.job.mngmnt.entities.JobSt;
import com.job.mngmnt.entities.JobStg;
import com.job.mngmnt.jaxb.JobDetails;
import com.job.mngmnt.service.JobDetailsService;
import com.job.mngmnt.util.DateUtil;

@Component("jobDetailsService")
public class JobDetailsServiceImpl implements JobDetailsService {

	@Autowired
	private JobDetailsDAO jobDetailsDAO;

	@Transactional
	public void createJob(JobDetails jobDetails) {
		Job jobObject = new Job();
		Job job = populateJobDetails(jobDetails, jobObject);
		jobDetailsDAO.createJob(job);
	}

	@Transactional
	public void updateJob(String jobId, JobDetails jobDetails) {
		
		Job job = jobDetailsDAO.getJob(jobId);

		if (job != null) {
			job = populateJobDetails(jobDetails, job);
			jobDetailsDAO.updateJob(job);
		}

	}

	@Transactional
	public void deleteJob(String jobId) {

		Job job = jobDetailsDAO.getJob(jobId);

		if (job != null) {
			jobDetailsDAO.deleteJob(job);
		}

	}

	private Job populateJobDetails(JobDetails jobDetails, Job job) {

		Account account = getAccount(Integer
				.parseInt(jobDetails.getAccountId()));

		job.setAccount(account);

		EmplTyp emplTyp = getEmplTyp(Integer.parseInt(jobDetails
				.getEmployementTypeId()));
		job.setEmptTyp(emplTyp);

		JobRole jobRole = getJobRole(Integer.parseInt(jobDetails.getRoleId()));
		job.setJobRole(jobRole);

		JobSt jobSt = getJobStatus(Integer
				.parseInt(jobDetails.getJobStatusId()));
		job.setJobSt(jobSt);

		JobStg jobStg = getJobStage(Integer
				.parseInt(jobDetails.getJobStageId()));
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
