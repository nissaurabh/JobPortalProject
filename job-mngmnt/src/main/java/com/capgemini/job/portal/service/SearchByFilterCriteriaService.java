/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */
package com.capgemini.job.portal.service;

import java.text.ParseException;
import java.util.Map;

import com.capgemini.job.portal.dto.CandidateDetails;
import com.capgemini.job.portal.dto.InterviewDetails;
import com.capgemini.job.portal.dto.JobDetails;

/**
 * The Class SearchByFilterCriteriaService performs search by filter criteria.
 * 
 * @author ppenamak
 */
public interface SearchByFilterCriteriaService {

	/**
	 * @param queryMap
	 * @return
	 * @throws ParseException 
	 */
	public JobDetails retriveJobDetailsByFilterCriteria(final Map<String, String> queryMap) 
			throws ParseException;
	
	/**
	 * @param queryMap
	 * @return
	 */
	public CandidateDetails retriveCandidateDetailsByFilterCriteria(final Map<String, String> queryMap);
	
	/**
	 * @param queryMap
	 * @return
	 */
	public InterviewDetails retriveInterviewDetailsByFilterCriteria(final Map<String, String> queryMap);
	

}
