/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */
package com.capgemini.job.portal.webservice;

import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.capgemini.job.portal.jaxb.InterviewDetails;

/**
 * The Class performs create, update, delete Job CreateJobDetailsWebservice.
 * 
 * @author ppenamak
 */
@Path("/interview")
public interface JobInterviewDetWebservice {

	/**
	 * schedule the interview.
	 * 
	 * @param interviewDetails
	 *            the interviewDetails
	 * @return the response
	 * @throws URISyntaxException
	 *             the URI syntax exception
	 */
	@POST
	@Consumes("application/json")
	@Path("/{job-id}/{candidate-id}")
	public Response scheduleInterview(@PathParam("job-id") final String jobId,
			@PathParam("candidate-id") final String candidateId,
			final InterviewDetails interviewDetails);

	/**
	 * update the scheduled interview.
	 * 
	 * @param interviewDetails
	 *            the jobDinterviewDetailsetails
	 * @param interviewId
	 *            the interviewId
	 * @return the response
	 * @throws URISyntaxException
	 *             the URI syntax exception
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{interview-id}")
	public Response modifyScheduledInterview(@PathParam("interview-id") final String interviewId,
			final InterviewDetails interviewDetails) throws URISyntaxException;

	/**
	 * Cancel the scheduled job.
	 * 
	 * @param interviewId
	 *            the interviewId
	 * @return the response
	 * @throws URISyntaxException
	 *             the URI syntax exception
	 */
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{interview-id}")
	public Response cancelScheduledInterview(@PathParam("interview-id") final String interviewId)
			throws URISyntaxException;
	
	
	/**
	 * @return
	 */
	@GET
    @Path("/retrieveDetails")
    @Produces("application/json")
    public Response getInterviewDetailsById(@Context final UriInfo uriInfo);

}
