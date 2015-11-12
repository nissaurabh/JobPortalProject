/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */
package com.capgemini.job.portal.webservice;

import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.capgemini.job.portal.jaxb.JobDetails;

/**
 * The Class performs create, update, delete Job CreateJobDetailsWebservice.
 * 
 * @author sbasired
 */
@Path("/jobDetail")
public interface JobDetailsWebservice {

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
	public Response createJob(final String jobDetails)
			throws URISyntaxException;

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
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{job-id}")
	public Response updateJob(@PathParam("job-id") final String jobId,
			final JobDetails jobDetails) throws URISyntaxException;

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
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{job-id}")
	public Response deleteJob(@PathParam("job-id") final String jobId)
			throws URISyntaxException;

}
