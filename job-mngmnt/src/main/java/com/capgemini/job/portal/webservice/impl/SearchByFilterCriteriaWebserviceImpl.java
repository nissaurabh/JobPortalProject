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

import org.apache.commons.lang.StringUtils;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
		String response = null;
		try{
			final MultivaluedMap<String, String> multivaluedMap = uriInfo
		                .getQueryParameters();
			final Map<String, String> queryMap = QueryParamUtil.getQueryParamsFrmMultiMap(multivaluedMap);
			String type = queryMap.get("type");
			if ((multivaluedMap.isEmpty()) || StringUtils.isEmpty(type)){
	       	   return Response.status(Status.BAD_REQUEST).build();
			}
			response = searchByFilterCriteriaService.retriveJobDetailsByFilterCriteria(queryMap);
		} catch (Exception e){
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		return buildResponse(response);
	}
	
	/* (non-Javadoc)
	 * @see com.capgemini.job.portal.webservice.SearchByFilterCriteriaWebservice#retrieveCandidateSearchDetails(javax.ws.rs.core.UriInfo)
	 */
	@Override
	public Response retrieveCandidateSearchDetails(final UriInfo uriInfo) throws URISyntaxException {
		String response = null;
		try{
			final MultivaluedMap<String, String> multivaluedMap = uriInfo
		                .getQueryParameters();
			final Map<String, String> queryMap = QueryParamUtil.getQueryParamsFrmMultiMap(multivaluedMap);
			String type = queryMap.get("type");
			if ((multivaluedMap.isEmpty()) || StringUtils.isEmpty(type)){
	       	   return Response.status(Status.BAD_REQUEST).build();
			}
			response = searchByFilterCriteriaService.retriveCandidateDetailsByFilterCriteria(queryMap);
		} catch (Exception e){
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		return buildResponse(response);
	}

	/**
	 * build the response object.
	 * 
	 * @param response
	 *            the response
	 * @return the responseObj
	 * @throws URISyntaxException
	 *             the URI syntax exception
	 */
	private Response buildResponse(final String response)
			throws URISyntaxException {
		Response responseObj = null;
		if (StringUtils.isNotEmpty(response)) {
			responseObj = Response.ok(response).build();
		} else {
			responseObj = Response.status(Status.NOT_FOUND).build();
		}
		return responseObj;
	}

}
