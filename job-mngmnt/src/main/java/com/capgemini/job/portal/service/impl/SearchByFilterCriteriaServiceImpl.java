/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */
package com.capgemini.job.portal.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.job.portal.dao.SearchByFilterCriteriaDAO;
import com.capgemini.job.portal.dto.JobDetail;
import com.capgemini.job.portal.service.SearchByFilterCriteriaService;

/**
 * The Class implements SearchByFilterCriteriaService interface to performs search by filter criteria.
 * 
 * @author ppenamak
 */
@Service("searchByFilterCriteriaService")
public class SearchByFilterCriteriaServiceImpl implements SearchByFilterCriteriaService {
	
	@Autowired
	private SearchByFilterCriteriaDAO searchByFilterCriteriaDAO;


	/* (non-Javadoc)
	 * @see com.capgemini.job.portal.service.SearchByFilterCriteriaService#retriveJobDetailsByFilterCriteria(java.util.Map)
	 */
	@Override
	public String retriveJobDetailsByFilterCriteria(Map<String, String> queryMap) throws JsonGenerationException, 
	JsonMappingException, IOException {
		List<JobDetail> jobDetList = searchByFilterCriteriaDAO.getJobDetailsByFilterCriteria(queryMap);
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(jobDetList);
	}

	/* (non-Javadoc)
	 * @see com.capgemini.job.portal.service.SearchByFilterCriteriaService#retriveCandidateDetailsByFilterCriteria(java.util.Map)
	 */
	@Override
	public String retriveCandidateDetailsByFilterCriteria(
			Map<String, String> queryMap) {
		// TODO Auto-generated method stub
		return null;
	}

	/*select a.wwsid, c.srvc_ln_nm, d.srvc_ln_cap_nm, b.job_rl_nm,e.job_sts_nm, a.reqstr_rm,a.req_dt  
	from job a, job_role b, service_ln c, service_ln_cap d, job_sts e where b.job_rl_id = a.job_rl_id
	and d.srvc_ln_cap_id = b.srvc_ln_cap_id
	and d.srvc_ln_id = c.srvc_ln_id
	and e.job_sts_id=a.job_sts_id
	and a.own_rm = 'RM3';*/

}
