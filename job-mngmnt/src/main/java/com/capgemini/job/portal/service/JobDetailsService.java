/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */
package com.capgemini.job.portal.service;

import com.capgemini.job.portal.entities.Account;
import com.capgemini.job.portal.entities.EmplTyp;
import com.capgemini.job.portal.entities.JobRole;
import com.capgemini.job.portal.entities.JobSt;
import com.capgemini.job.portal.entities.JobStg;
import com.capgemini.job.portal.jaxb.JobDetails;

/**
 * The Class performs create, update, delete Job JobDetailsService.
 * 
 * @author sbasired
 */
public interface JobDetailsService {

	/**
	 * create the job service.
	 * 
	 * @param jobDetails
	 *            the jobDetails
	 * @return the response
	 */
	public String createJob(final JobDetails jobDetails);
	
	/**
	 * update the job service.
	 * @param jobId
	 *            the jobId
	 * @param jobDetails
	 *            the jobDetails
	 * @return the response
	 */
	public String updateJob(final String jobId, final JobDetails jobDetails);
	
	/**
	 * delete the job service.
	 * @param jobId
	 *            the jobId
	 * @return the response
	 */
	public String deleteJob(final String jobId);

	/**
	 * get the account service.
	 * @param acctId
	 *            the acctId
	 * @return account
	 * 			  the acctId
	 */
	public Account getAccount(final int acctId);

	/**
	 * get the employee type service.
	 * @param emptTypId
	 *            the emptTypId
	 * @return emplTyp
	 * 			  the emplTyp
	 */
	public EmplTyp getEmplTyp(final int emptTypId);

	/**
	 * get the job role service.
	 * @param jobRlId
	 *            the jobRlId
	 * @return jobRole
	 * 			  the jobRole
	 */
	public JobRole getJobRole(final int jobRlId);

	/**
	 * get the job status service.
	 * @param jobStsId
	 *            the jobStsId
	 * @return jobSt
	 * 			  the jobSt
	 */
	public JobSt getJobStatus(final int jobStsId);

	/**
	 * get the job stage service.
	 * @param jobStgId
	 *            the jobStgId
	 * @return jobStg
	 * 			  the jobStg
	 */
	public JobStg getJobStage(final int jobStgId);

}
