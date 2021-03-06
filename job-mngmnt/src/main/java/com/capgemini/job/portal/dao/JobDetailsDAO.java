/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */
package com.capgemini.job.portal.dao;

import com.capgemini.job.portal.entities.Account;
import com.capgemini.job.portal.entities.EmplTyp;
import com.capgemini.job.portal.entities.Job;
import com.capgemini.job.portal.entities.JobRole;
import com.capgemini.job.portal.entities.JobSt;
import com.capgemini.job.portal.entities.JobStg;

/**
 * The Class JobDetailsDAO.
 * 
 * @author sbasired
 */
public interface JobDetailsDAO {
	
	/**
	 * create the job.
	 * 
	 * @param job
	 *            the job
	 */
	public void createJob(final Job job);
	
	/**
	 * update the job.
	 * 
	 * @param job
	 *            the job
	 */
	public void updateJob(final Job job);
	
	/**
	 * delete the job.
	 * 
	 * @param job
	 *            the job
	 */
	public void deleteJob(final Job job);
	
	/**
	 * get the account.
	 * 
	 * @param acctId
	 *            the acctId
	 * @return the cccount
	 */
	public Account getAccount(final int acctId);
	
	/**
	 * get the  employee type.
	 * 
	 * @param emptTypId
	 *            the emptTypId
	 * @return the emplTyp
	 */
	public EmplTyp getEmplTyp(final int emptTypId);
	
	/**
	 * get the job role.
	 * 
	 * @param jobRlId
	 *            the jobRlId
	 * @return the jobRole
	 */
	public JobRole getJobRole(final int jobRlId);
	
	/**
	 * get the job status.
	 * 
	 * @param jobStsId
	 *            the jobStsId
	 * @return the jobSt
	 */
	public JobSt getJobStatus(final int jobStsId);
	
	/**
	 * get the job stage.
	 * 
	 * @param jobStgId
	 *            the jobStgId
	 * @return the jobStg
	 */
	public JobStg getJobStage(final int jobStgId);
	
	/**
	 * get the job.
	 * 
	 * @param jobId
	 *            the jobId
	 * @return the job
	 */
	public Job getJob(final String jobId);

}
