/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */
package com.capgemini.job.portal.dao;

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
	 */
	public void createJobInterview(final JobIntrvw jobIntrvw);

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

}
