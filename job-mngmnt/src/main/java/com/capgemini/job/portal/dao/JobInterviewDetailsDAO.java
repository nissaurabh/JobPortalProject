/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */
package com.capgemini.job.portal.dao;

import java.util.List;

import com.capgemini.job.portal.entities.IntrvwSt;
import com.capgemini.job.portal.entities.JobIntrvw;

/**
 * The Class JobInterviewDetailsDAO.
 * 
 * @author ppenamak
 */
public interface JobInterviewDetailsDAO {
	
	/**
	 * create the job interview.
	 * 
	 * @param jobIntrvw
	 *            the jobIntrvw
	 * @return 
	 */
	public String createJobInterview(final JobIntrvw jobIntrvw);

	/**
	 * @param intrvwStId
	 * @return
	 */
	public IntrvwSt getInterviewStatus(final int intrvwStId);
	
	/**
	 * @param interviewId
	 * @return
	 */
	public JobIntrvw retrieveInterviewDetails(final int interviewId);

	/**
	 * @param jobIntrvw
	 */
	public void deleteJobInterview(final JobIntrvw jobIntrvw);

	/**
	 * @param jobIntrvw
	 * @return 
	 */
	public JobIntrvw updateJobInterview(JobIntrvw jobIntrvw);
	
	/**
	 * @param cndtId
	 * @return
	 */
	public List<JobIntrvw> retrieveInterviewDetailsByCandId(final int cndtId);

	/**
	 * @param jobId
	 * @param cndtId
	 * @return
	 */
	public List<JobIntrvw> retrieveInterviewDetailsByJobIdandCandId(final int jobId, final int cndtId);

}
