/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */
package com.capgemini.job.portal.service;

import com.capgemini.job.portal.dto.CandidateDetail;
import com.capgemini.job.portal.entities.CndtCtg;
import com.capgemini.job.portal.entities.CndtSt;
import com.capgemini.job.portal.entities.CtznshpSt;
import com.capgemini.job.portal.entities.JobCndt;
import com.capgemini.job.portal.entities.ResourceTyp;
import com.capgemini.job.portal.jaxb.JobCandidate;

/**
 * The Class performs add, update, remove Job candidate JobCandidateService.
 * 
 * @author sbasired
 */
public interface JobCandidateService {
	
	/**
	 * add candidate to the Job service.
	 * 
	 * @param jobId
	 *            the jobId
	 * @param jobCandidate
	 *            the jobCandidate
	 * @param bytes
	 *            the bytes
	 * @return the response
	 */
	public String addJobCandidate(final String jobId,
			final JobCandidate jobCandidate, final byte bytes[]);

	/**
	 * update candidate in the job service.
	 * 
	 * @param jobId
	 *            the jobId
	 * @param jobCandidateId
	 *            the jobCandidateId
	 * @param jobCandidate
	 *            the jobCandidate
	  * @param bytes
	 *            the bytes
	 * @return the response
	 */
	public String updateJobCandidate(final String jobId,
			final String jobCandidateId, final JobCandidate jobCandidate, final byte bytes[]);

	/**
	 * remove candidate from the job service.
	 * 
	 * @param jobId
	 *            the jobId
	 * @param jobCandidateId
	 *            the jobCandidateId
	 * @return the response
	 */
	public String deleteJob(final String jobId, final String jobCandidateId);
	
	
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
	 * get the Job Candidate by job id and job candidate id.
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
	 * @param candidateId
	 * @return
	 */
	public CandidateDetail getCandidateDetailsById(final int candidateId);


}
