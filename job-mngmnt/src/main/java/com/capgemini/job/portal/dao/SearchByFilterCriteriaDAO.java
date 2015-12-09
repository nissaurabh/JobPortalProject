/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */
package com.capgemini.job.portal.dao;

import java.util.List;
import java.util.Map;

import com.capgemini.job.portal.dto.CandidateDetail;
import com.capgemini.job.portal.dto.InterviewDetail;
import com.capgemini.job.portal.dto.JobDetail;


/**
 * The Class SearchByFilterCriteriaDAO.
 * 
 * @author ppenamak
 */
public interface SearchByFilterCriteriaDAO {
	
	/**
	 * @param jobFilterMap
	 * @return
	 */
	public List<JobDetail> getJobDetailsByFilterCriteria(final Map<String, String> jobFilterMap);
	
	/**
	 * @param candidateFilterMap
	 * @return
	 */
	public List<CandidateDetail> getCandidateDetailsByFilterCriteria(final Map<String, String> candidateFilterMap);
	
	/**
	 * @param intrvwFilterMap
	 * @return
	 */
	public List<InterviewDetail> getInterviewDetailsByFilterCriteria(final Map<String, String> intrvwFilterMap);

}
