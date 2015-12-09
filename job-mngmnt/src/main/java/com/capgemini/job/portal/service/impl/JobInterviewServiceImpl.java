package com.capgemini.job.portal.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.job.portal.constants.JobMngMntConstants;
import com.capgemini.job.portal.dao.JobCandidateDAO;
import com.capgemini.job.portal.dao.JobDetailsDAO;
import com.capgemini.job.portal.dao.JobInterviewDetailsDAO;
import com.capgemini.job.portal.entities.IntrvwSt;
import com.capgemini.job.portal.entities.Job;
import com.capgemini.job.portal.entities.JobCndt;
import com.capgemini.job.portal.entities.JobIntrvw;
import com.capgemini.job.portal.jaxb.InterviewDetails;
import com.capgemini.job.portal.service.JobInterviewService;
import com.capgemini.job.portal.util.DateUtil;

/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */


/**
 * The Class JobInterviewService performs schedule, modify and cancel interviews.
 * 
 * @author ppenamak
 */
@Component("jobInterviewService")
public class JobInterviewServiceImpl implements JobInterviewService {

	@Autowired
	private JobInterviewDetailsDAO jobInterviewDetailsDAO;
	
	@Autowired
	private JobCandidateDAO jobCandidateDAO;
	
	@Autowired
	private JobDetailsDAO jobDetailsDAO;

	@Transactional
	@Override
	public String scheduleInterview(String jobId, String candidateId,
			InterviewDetails interviewDetails) {
		final JobIntrvw jobIntrvw = populateJobInterviewDetails(jobId, candidateId, interviewDetails);
		return jobInterviewDetailsDAO.createJobInterview(jobIntrvw);
	}

	
	/* (non-Javadoc)
	 * @see com.capgemini.job.portal.service.JobInterviewService#updateScheduledInterview(java.lang.String, com.capgemini.job.portal.jaxb.InterviewDetails)
	 */
	@Transactional
	@Override
	public String updateScheduledInterview(String interviewId,InterviewDetails interviewDetails) {
		String response = JobMngMntConstants.OK_STATUS;
		final JobIntrvw jobIntrvw = jobInterviewDetailsDAO.retrieveInterviewDetails(Integer
				.parseInt(interviewId));
		if (jobIntrvw != null) {
			updateInterviewDetails(jobIntrvw, interviewDetails);
			jobInterviewDetailsDAO.updateJobInterview(jobIntrvw);
		} else{
			response = JobMngMntConstants.NOT_FOUND;
		}
		return response;
	}

	
	/**
	 * @param jobIntrvw
	 * @param interviewDetails
	 */
	private void updateInterviewDetails(JobIntrvw jobIntrvw,
			InterviewDetails interviewDetails) {
		if(StringUtils.isNotEmpty(interviewDetails.getInterviewDateTime())){
			jobIntrvw.setIntrvwTm(DateUtil.convertStringToTimestamp(interviewDetails.getInterviewDateTime()));
		}
		if(StringUtils.isNotEmpty(interviewDetails.getIntrvwrName())){
			jobIntrvw.setIntrvrNm(interviewDetails.getIntrvwrName());
		}
		if(StringUtils.isNotEmpty(interviewDetails.getInterviewerPos())){
			jobIntrvw.setIntrvrPos(interviewDetails.getInterviewerPos());
		}
		if(StringUtils.isNotEmpty(interviewDetails.getIntrvwrComments())){
			jobIntrvw.setIntrvrCmnts(interviewDetails.getIntrvwrComments());
		}
	}


	/* (non-Javadoc)
	 * @see com.capgemini.job.portal.service.JobInterviewService#deleteScheduleInterview(java.lang.String)
	 */
	@Transactional
	@Override
	public String deleteScheduleInterview(String interviewId) {
		String response = JobMngMntConstants.NO_CONTENT;
		final JobIntrvw jobIntrvw = jobInterviewDetailsDAO.retrieveInterviewDetails(Integer
				.parseInt(interviewId));

		if (jobIntrvw != null) {
			jobInterviewDetailsDAO.deleteJobInterview(jobIntrvw);
		} else{
			response = JobMngMntConstants.NOT_FOUND;
		}
		return response;
	}

	/**
	 * populate the Job Interview details.
	 * @param jobId
	 * @param candidateId
	 * @param interviewDetails
	 * @return
	 */
	private JobIntrvw populateJobInterviewDetails(String jobId, String candidateId,
			InterviewDetails interviewDetails) {
		
		final JobIntrvw jobIntrvw = new JobIntrvw();

		final IntrvwSt intrvwSt = getInterviewStatus(Integer
				.parseInt("1"));
		jobIntrvw.setIntrvwSt(intrvwSt);
		
		final JobCndt jobCndt = jobCandidateDAO.getJobCndtByJobCndtId(Integer
				.parseInt(candidateId));
		
		final Job job = jobDetailsDAO.getJob(jobId);
		
		jobIntrvw.setJob(job);
		jobIntrvw.setJobCndt(jobCndt);
		jobIntrvw.setIntrvrNm(interviewDetails.getIntrvwrName());
		jobIntrvw.setIntrvrPos(interviewDetails.getInterviewerPos());
		jobIntrvw.setIntrvrCmnts(interviewDetails.getIntrvwrComments());
		jobIntrvw.setIntrvwTm(DateUtil.convertStringToTimestamp(interviewDetails.getInterviewDateTime()));

		return jobIntrvw;
	}
	
	@Transactional
	public IntrvwSt getInterviewStatus(final int interviewStsId) {
		return jobInterviewDetailsDAO.getInterviewStatus(interviewStsId);
	}


}
