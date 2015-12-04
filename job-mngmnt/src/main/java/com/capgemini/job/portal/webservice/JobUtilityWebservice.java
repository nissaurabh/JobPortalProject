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
import javax.ws.rs.core.Response;

/**
 * The Class performs to get the administrative data JobUtilityWebservice.
 * 
 * @author sbasired
 */
@Path("/jobUtility")
public interface JobUtilityWebservice {
	
	/**
	 * get the account details
	 * @return the response
	 * @throws URISyntaxException
	 *             the URI syntax exception
	 */
	@GET
	@Path("/account")
	@Produces("application/json")
	public Response getAccount()
			throws URISyntaxException;
	
	/**
	 * get the candidate category details
	 * @return the response
	 * @throws URISyntaxException
	 *             the URI syntax exception
	 */
	@GET
	@Path("/candidateCategory")
	@Produces("application/json")
	public Response getCandidateCategory()
			throws URISyntaxException;
	
	/**
	 * get the candidate status details
	 * @return the response
	 * @throws URISyntaxException
	 *             the URI syntax exception
	 */
	@GET
	@Path("/candidateStatus")
	@Produces("application/json")
	public Response getCandidateStatus()
			throws URISyntaxException;
	
	/**
	 * get the citizenship status details
	 * @return the response
	 * @throws URISyntaxException
	 *             the URI syntax exception
	 */
	@GET
	@Path("/citizenshipStatus")
	@Produces("application/json")
	public Response getCitizenshipStatus()
			throws URISyntaxException;
	
	/**
	 * get the employee type details
	 * @return the response
	 * @throws URISyntaxException
	 *             the URI syntax exception
	 */
	@GET
	@Path("/employeeType")
	public Response getEmployeeType()
			throws URISyntaxException;
	
	/**
	 * get the interview status details
	 * @return the response
	 * @throws URISyntaxException
	 *             the URI syntax exception
	 */
	@GET
	@Path("/interviewStatus")
	@Produces("application/json")
	public Response getInterviewStatus()
			throws URISyntaxException;
	
	/**
	 * get the job role details
	 * @return the response
	 * @throws URISyntaxException
	 *             the URI syntax exception
	 */
	@GET
	@Path("/jobRole")
	@Produces("application/json")
	public Response getJobRole()
			throws URISyntaxException;
	
	/**
	 * get the job stage details
	 * @return the response
	 * @throws URISyntaxException
	 *             the URI syntax exception
	 */
	@GET
	@Path("/jobStage")
	@Produces("application/json")
	public Response getJobStage()
			throws URISyntaxException;
	
	/**
	 * get the job status details
	 * @return the response
	 * @throws URISyntaxException
	 *             the URI syntax exception
	 */
	@GET
	@Path("/jobStatus")
	@Produces("application/json")
	public Response getJobStatus()
			throws URISyntaxException;
	
	/**
	 * get the resource type details
	 * @return the response
	 * @throws URISyntaxException
	 *             the URI syntax exception
	 */
	@GET
	@Path("/resourceType")
	@Produces("application/json")
	public Response getResourceType()
			throws URISyntaxException;
	
	/**
	 * get the service line details
	 * @return the response
	 * @throws URISyntaxException
	 *             the URI syntax exception
	 */
	@GET
	@Path("/serviceLine")
	@Produces("application/json")
	public Response getServiceLine()
			throws URISyntaxException;
	
	/**
	 * get the service line capability details
	 * @return the response
	 * @throws URISyntaxException
	 *             the URI syntax exception
	 */
	@GET
	@Path("/serviceLineCapability")
	@Produces("application/json")
	public Response getServiceLineCapability()
			throws URISyntaxException;
	
	/**
	 * get the service line capability details
	 * @return the response
	 * @throws URISyntaxException
	 *             the URI syntax exception
	 */
	/*@GET
	@Path("/serviceLineCapability")
	@Produces("application/json")
	public Response getServiceLineCapabilityByServiceLineId()
			throws URISyntaxException;*/

}
