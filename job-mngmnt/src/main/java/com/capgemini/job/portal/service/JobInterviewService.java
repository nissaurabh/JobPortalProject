/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */
package com.capgemini.job.portal.service;

import java.util.List;

import com.capgemini.job.portal.dto.InterviewDetail;
import com.capgemini.job.portal.jaxb.InterviewDetails;

/**
 * The Class JobInterviewService performs schedule, modify and cancel interviews.
 * 
 * @author ppenamak
 */
public interface JobInterviewService {

	
	/**
	 * @param jobId
	 * @param candidateId
	 * @param interviewDetails
	 * @return
	 */
	public String scheduleInterview(final String jobId, final String candidateId, 
			final InterviewDetails interviewDetails);
	
	
	/**
	 * @param interviewId
	 * @param interviewDetails
	 * @return
	 */
	public String updateScheduledInterview(final String interviewId, final InterviewDetails interviewDetails);
	
	/**
	 * delete the interview scheduled.
	 * @param interviewId
	 *            the interviewId
	 * @return the response
	 */
	public String deleteScheduleInterview(final String interviewId);
	
	/**
	 * @param interviewId
	 * @return
	 */
	public InterviewDetail getInterviewDetailsById(final String interviewId);
	
	/**
	 * @param candidateId
	 * @return
	 */
	public List<InterviewDetail> getInterviewDetailsByCandidateId(final String candidateId);


	/**
	 * @param jobId
	 * @param candidateId
	 * @return
	 */
	public List<InterviewDetail> getInterviewDetailsByJobIdAndCndtId(final String jobId, final String candidateId);

}
