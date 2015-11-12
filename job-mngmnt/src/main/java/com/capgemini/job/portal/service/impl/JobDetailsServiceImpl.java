/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */
package com.capgemini.job.portal.service.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.job.portal.constants.JobMngMntConstants;
import com.capgemini.job.portal.dao.JobDetailsDAO;
import com.capgemini.job.portal.entities.Account;
import com.capgemini.job.portal.entities.EmplTyp;
import com.capgemini.job.portal.entities.Job;
import com.capgemini.job.portal.entities.JobRole;
import com.capgemini.job.portal.entities.JobSt;
import com.capgemini.job.portal.entities.JobStg;
import com.capgemini.job.portal.jaxb.JobDetails;
import com.capgemini.job.portal.service.JobDetailsService;
import com.capgemini.job.portal.util.DateUtil;

/**
 * The Class performs create, update, delete Job JobDetailsService.
 * 
 * @author sbasired
 */
@Component("jobDetailsService")
public class JobDetailsServiceImpl implements JobDetailsService {

	@Autowired
	private JobDetailsDAO jobDetailsDAO;

	@Transactional
	@Override
	public String createJob(final JobDetails jobDetails) {
		final String response = JobMngMntConstants.CREATED;
		final Job jobObject = new Job();
		final Job job = populateJobDetails(jobDetails, jobObject);
		jobDetailsDAO.createJob(job);

		return response;
	}

	@Transactional
	@Override
	public String updateJob(final String jobId, final JobDetails jobDetails) {
		String response = JobMngMntConstants.OK_STATUS;
		Job job = jobDetailsDAO.getJob(jobId);

		if (job != null) {
			job = populateJobDetails(jobDetails, job);
			jobDetailsDAO.updateJob(job);
		}else{
			response = JobMngMntConstants.NOT_FOUND;
		}
		return response;
	}

	@Transactional
	@Override
	public String deleteJob(final String jobId) {
		String response = JobMngMntConstants.OK_STATUS;
		final Job job = jobDetailsDAO.getJob(jobId);

		if (job != null) {
			jobDetailsDAO.deleteJob(job);
		}else{
			response = JobMngMntConstants.NOT_FOUND;
		}
		return response;

	}

	/**
	 * populate the job details.
	 * @param jobDetails
	 *            the jobDetails
	 * @param job
	 *            the job
	 * @return the job
	 */
	private Job populateJobDetails(final JobDetails jobDetails, final Job job) {

		final Account account = getAccount(Integer
				.parseInt(jobDetails.getAccountId()));

		job.setAccount(account);

		final EmplTyp emplTyp = getEmplTyp(Integer.parseInt(jobDetails
				.getEmployementTypeId()));
		job.setEmptTyp(emplTyp);

		final JobRole jobRole = getJobRole(Integer.parseInt(jobDetails.getRoleId()));
		job.setJobRole(jobRole);

		final JobSt jobSt = getJobStatus(Integer
				.parseInt(jobDetails.getJobStatusId()));
		job.setJobSt(jobSt);

		final JobStg jobStg = getJobStage(Integer
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

	@Transactional
	@Override
	public Account getAccount(final int acctId) {

		return jobDetailsDAO.getAccount(acctId);
	}

	@Transactional
	@Override
	public EmplTyp getEmplTyp(final int emptTypId) {

		return jobDetailsDAO.getEmplTyp(emptTypId);
	}

	@Transactional
	@Override
	public JobRole getJobRole(final int jobRlId) {

		return jobDetailsDAO.getJobRole(jobRlId);
	}

	@Transactional
	@Override
	public JobSt getJobStatus(final int jobStsId) {

		return jobDetailsDAO.getJobStatus(jobStsId);
	}

	@Transactional
	@Override
	public JobStg getJobStage(final int jobStgId) {

		return jobDetailsDAO.getJobStage(jobStgId);
	}

}
