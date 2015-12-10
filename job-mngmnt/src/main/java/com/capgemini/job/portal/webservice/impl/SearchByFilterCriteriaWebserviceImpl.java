/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */

package com.capgemini.job.portal.webservice.impl;

import java.net.URISyntaxException;
import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.collections.CollectionUtils;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.job.portal.dto.CandidateDetails;
import com.capgemini.job.portal.dto.InterviewDetails;
import com.capgemini.job.portal.dto.JobDetails;
import com.capgemini.job.portal.service.SearchByFilterCriteriaService;
import com.capgemini.job.portal.util.QueryParamUtil;
import com.capgemini.job.portal.webservice.SearchByFilterCriteriaWebservice;

/**
 * The Class performs search based on the filter criteria.
 * 
 * @author ppenamak
 */
@CrossOriginResourceSharing(allowAllOrigins = true)
@Component("searchByFilterCriteriaWebservice")
public class SearchByFilterCriteriaWebserviceImpl implements
	SearchByFilterCriteriaWebservice {
	
	/** Search service. */
	@Autowired
	private SearchByFilterCriteriaService searchByFilterCriteriaService;

	/* (non-Javadoc)
	 * @see com.capgemini.job.portal.webservice.SearchByFilterCriteriaWebservice#retrieveJobSearchDetails(javax.ws.rs.core.UriInfo)
	 */
	@Override
	public Response retrieveJobSearchDetails(final UriInfo uriInfo) throws URISyntaxException {
		JobDetails response = null;
		try{
			final MultivaluedMap<String, String> multivaluedMap = uriInfo
		                .getQueryParameters();
			final Map<String, String> queryMap = QueryParamUtil.getQueryParamsFrmMultiMap(multivaluedMap);
			response = searchByFilterCriteriaService.retriveJobDetailsByFilterCriteria(queryMap);
			if(!CollectionUtils.isNotEmpty(response.getJobList())){
				return Response.status(Status.NOT_FOUND).header("Access-Control-Allow-Origin",
						"http://10.81.82.144:8080/job-management-service/").build();
			}
		} catch (Exception e){
			return Response.status(Status.INTERNAL_SERVER_ERROR).header("Access-Control-Allow-Origin",
					"http://10.81.82.144:8080/job-management-service/").build();
		}
		return Response.ok(response).header("Access-Control-Allow-Origin",
				"http://10.81.82.144:8080/job-management-service/").build();
	}
	
	/* (non-Javadoc)
	 * @see com.capgemini.job.portal.webservice.SearchByFilterCriteriaWebservice#retrieveCandidateSearchDetails(javax.ws.rs.core.UriInfo)
	 */
	@Override
	public Response retrieveCandidateSearchDetails(final UriInfo uriInfo) throws URISyntaxException {
		CandidateDetails response = null;
		try{
			final MultivaluedMap<String, String> multivaluedMap = uriInfo
		                .getQueryParameters();
			final String uri = uriInfo.getBaseUri().toString();
			final Map<String, String> queryMap = QueryParamUtil.getQueryParamsFrmMultiMap(multivaluedMap);
			queryMap.put("uri", uri);
			response = searchByFilterCriteriaService.retriveCandidateDetailsByFilterCriteria(queryMap);
			if(!CollectionUtils.isNotEmpty(response.getCandidateList())){
				return Response.status(Status.NOT_FOUND).header("Access-Control-Allow-Origin",
						"http://10.81.82.144:8080/job-management-service/").build();
			}
		} catch (Exception e){
			return Response.status(Status.INTERNAL_SERVER_ERROR).header("Access-Control-Allow-Origin",
					"http://10.81.82.144:8080/job-management-service/").build();
		}
		return Response.ok(response).header("Access-Control-Allow-Origin",
				"http://10.81.82.144:8080/job-management-service/").build();
	}

	/* (non-Javadoc)
	 * @see com.capgemini.job.portal.webservice.SearchByFilterCriteriaWebservice#retrieveInterviewSearchDetails(javax.ws.rs.core.UriInfo)
	 */
	@Override
	public Response retrieveInterviewSearchDetails(UriInfo uriInfo)
			throws URISyntaxException {
		InterviewDetails response = null;
		try{
			final MultivaluedMap<String, String> multivaluedMap = uriInfo
		                .getQueryParameters();
			final Map<String, String> queryMap = QueryParamUtil.getQueryParamsFrmMultiMap(multivaluedMap);
			response = searchByFilterCriteriaService.retriveInterviewDetailsByFilterCriteria(queryMap);
			if(!CollectionUtils.isNotEmpty(response.getInterviewList())){
				return Response.status(Status.NOT_FOUND).header("Access-Control-Allow-Origin",
						"http://10.81.82.144:8080/job-management-service/").build();
			}
		} catch (Exception e){
			return Response.status(Status.INTERNAL_SERVER_ERROR).header("Access-Control-Allow-Origin",
					"http://10.81.82.144:8080/job-management-service/").build();
		}
		return Response.ok(response).header("Access-Control-Allow-Origin",
				"http://10.81.82.144:8080/job-management-service/").build();
	}
}

