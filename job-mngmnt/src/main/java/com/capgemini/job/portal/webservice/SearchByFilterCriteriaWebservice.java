/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */
package com.capgemini.job.portal.webservice;

import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * The Class performs create, update, delete Job CreateJobDetailsWebservice.
 * 
 * @author ppenamak
 */
@Path("/")
public interface SearchByFilterCriteriaWebservice {

	
	
	/**
	 * @param uriInfo
	 * @return
	 * @throws URISyntaxException
	 */
	@GET
	@Produces("application/json")
	@Path("jobSearch")
	public Response retrieveJobSearchDetails(@Context final UriInfo uriInfo) throws URISyntaxException;
	
	
	/**
	 * @param uriInfo
	 * @return
	 * @throws URISyntaxException
	 */
	@GET
	@Produces("application/json")
	@Path("candidateSearch")
	public Response retrieveCandidateSearchDetails(@Context final UriInfo uriInfo) throws URISyntaxException;
	
	/**
	 * @param uriInfo
	 * @return
	 * @throws URISyntaxException
	 */
	@GET
	@Produces("application/json")
	@Path("interviewSearch")
	public Response retrieveInterviewSearchDetails(@Context final UriInfo uriInfo) throws URISyntaxException;

}
