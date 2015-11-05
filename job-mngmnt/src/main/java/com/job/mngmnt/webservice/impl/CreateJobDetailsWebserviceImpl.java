/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */

package com.job.mngmnt.webservice.impl;

import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.job.mngmnt.constants.JobMngMntConstants;
import com.job.mngmnt.jaxb.JobDetails;
import com.job.mngmnt.service.JobDetailsService;
import com.job.mngmnt.webservice.CreateJobDetailsWebservice;

/**
 * The Class performs create, update, delete Job CreateJobDetailsWebservice.
 * 
 * @author sbasired
 */
@Component("createJobDetailsWebservice")
public class CreateJobDetailsWebserviceImpl implements
		CreateJobDetailsWebservice {

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
	public Response createJob(final JobDetails jobDetails)
			throws URISyntaxException {
		String response = null;
		response = jobDetailsService.createJob(jobDetails);
		return buildResponse(response);
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
