/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */

package com.capgemini.job.portal.webservice.impl;

import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.job.portal.constants.JobMngMntConstants;
import com.capgemini.job.portal.jaxb.JobDetails;
import com.capgemini.job.portal.service.JobDetailsService;
import com.capgemini.job.portal.webservice.JobDetailsWebservice;

/**
 * The Class performs create, update, delete Job CreateJobDetailsWebservice.
 * 
 * @author sbasired
 */
@CrossOriginResourceSharing(allowAllOrigins = true)
@Component("jobDetailsWebservice")
public class JobDetailsWebserviceImpl implements
		JobDetailsWebservice {

	/** Job details service. */
	@Autowired
	private JobDetailsService jobDetailsService;

	/**
	 * create the job.
	 * 
	 * @param jobDetails
	 *            the jobDetails
	 * @return the response
	 * @throws URISyntaxException
	 *             the URI syntax exception
	 */
	@POST
	@Consumes("application/json")
	public Response createJob(JobDetails jobDetails)
			throws URISyntaxException {
		String response = null;
		System.out.println("JobDetails JSON: "+ jobDetails.getAccountId());
		response = jobDetailsService.createJob(jobDetails);
		return Response.ok().header("Access-Control-Allow-Origin", "http://10.81.82.144:8080/job-management-service/").build();
	}

	/**
	 * update the job.
	 * 
	 * @param jobDetails
	 *            the jobDetails
	 * @param jobId
	 *            the jobId
	 * @return the response
	 * @throws URISyntaxException
	 *             the URI syntax exception
	 */
	@PUT
	@Consumes("application/json")
	@Path("/{job-id}")
	public Response updateJob(@PathParam("job-id") final String jobId,
			final JobDetails jobDetails) throws URISyntaxException {
		String response = null;
		response = jobDetailsService.updateJob(jobId, jobDetails);

		return buildResponse(response);
	}

	/**
	 * delete the job.
	 * 
	 * @param jobId
	 *            the jobId
	 * @return the response
	 * @throws URISyntaxException
	 *             the URI syntax exception
	 */
	@DELETE
	@Consumes("application/json")
	@Path("/{job-id}")
	public Response deleteJob(@PathParam("job-id") final String jobId)
			throws URISyntaxException {

		String response = null;

		response = jobDetailsService.deleteJob(jobId);

		return buildResponse(response);
	}
	
	/**
	 * get the job.
	 * 
	 * @param jobId
	 *            the jobId
	 * @return the response
	 * @throws URISyntaxException
	 *             the URI syntax exception
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{job-id}")
	public Response getJob(@PathParam("job-id") final String jobId)
			throws URISyntaxException{
		JobDetails jobDetails = jobDetailsService.getJob(jobId);
		return Response.ok(jobDetails).build();
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
		if (response.equalsIgnoreCase(JobMngMntConstants.NOT_FOUND)) {
			responseObj = Response.status(Status.NOT_FOUND).build();
		} else if (response.equalsIgnoreCase(JobMngMntConstants.OK_STATUS)) {

			responseObj = Response.status(Status.OK).build();
		} else if (response.equalsIgnoreCase(JobMngMntConstants.CREATED)) {

			responseObj = Response.status(Status.CREATED).build();
		}

		return responseObj;
	}

}
