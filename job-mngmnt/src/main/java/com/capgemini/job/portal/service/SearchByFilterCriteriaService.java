/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */
package com.capgemini.job.portal.service;

import java.io.IOException;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

/**
 * The Class SearchByFilterCriteriaService performs search by filter criteria.
 * 
 * @author ppenamak
 */
public interface SearchByFilterCriteriaService {

	/**
	 * @param queryMap
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	public String retriveJobDetailsByFilterCriteria(final Map<String, String> queryMap) throws JsonGenerationException, JsonMappingException, IOException;
	
	/**
	 * @param queryMap
	 * @return
	 */
	public String retriveCandidateDetailsByFilterCriteria(final Map<String, String> queryMap);
	

}
