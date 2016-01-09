/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */
package com.capgemini.job.portal.dao;

import java.util.List;

import com.capgemini.job.portal.entities.CndtCtg;
import com.capgemini.job.portal.entities.CndtSt;
import com.capgemini.job.portal.entities.CtznshpSt;
import com.capgemini.job.portal.entities.JobCndt;
import com.capgemini.job.portal.entities.ResourceTyp;

/**
 * The Class JobCandidateDAO.
 * 
 * @author sbasired
 */
public interface JobCandidateDAO {
	
	/**
	 * add candidate to the Job.
	 * 
	 * @param jobCndt
	 *            the jobCndt
	 * @return the response
	 */
	public void addJobCandidate(final JobCndt jobCndt);

	/**
	 * update candidate in the job.
	 * 
	 * @param jobCndt
	 *            the jobCndt
	 * @return the response
	 */
	public void updateJobCandidate(final JobCndt jobCndt);

	/**
	 * remove candidate from the job.
	 * 
	 * @param jobCndt
	 *            the jobCndt
	 * @return the response
	 */
	public void deleteJobCandidate(final JobCndt jobCndt);
	
	/**
	 * get the candidate category.
	 * @param cadtCtgId
	 *            the cadtCtgId
	 * @return cndtCtg
	 * 			  the cndtCtg
	 */
	public CndtCtg getCndtCtg(final int cadtCtgId);
	
	/**
	 * get the Candidate Status.
	 * @param cndtStId
	 *            the cndtStId
	 * @return cdtSt
	 * 			  the cndtSt
	 */
	public CndtSt getCndtSt(final int cndtStId);
	
	/**
	 * get the citizenship status.
	 * @param ctznshpStId
	 *            the ctznshpStId
	 * @return ctznshpSt
	 * 			  the ctznshpSt
	 */
	public CtznshpSt getCtznshpSt(final int ctznshpStId);
	
	/**
	 * get the Resource type.
	 * @param resourceTypId
	 *            the resourceTypId
	 * @return resourceTyp
	 * 			  the resourceTyp
	 */
	public ResourceTyp getResourceTyp(final int resourceTypId);
	
	/**
	 * get the Job Candidate.
	 * @param jobId
	 *            the jobId
	 * @param jobCndtId
	 *            the jobCndtId
	 * @return jobCndt
	 * 			  the jobCndt
	 */
	public JobCndt getJobCndtByJobIdAndJobCndtId(final int jobId, final int jobCndtId);
	
	/**
	 * get the Job Candidate by job candidate id.
	 * 
	 * @param jobCndtId
	 *            the jobCndtId
	 * @return jobCndt
	 * 			  the jobCndt
	 */
	public JobCndt getJobCndtByJobCndtId(final int jobCndtId);
	
	/**
	 * get the Job Candidate by job id.
	 * 
	 * @param jobId
	 *            the jobId
	 * @return List<JobCndt>
	 * 			  the List<JobCndt>
	 */
	public List<JobCndt> getJobCndtsByJobId(final int jobId);

}
