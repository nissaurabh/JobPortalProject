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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;

import com.capgemini.job.portal.jaxb.JobCandidate;

/**
 * The Class performs add, update, remove Job candidate JobCandidateWebservice.
 * 
 * @author sbasired
 */
@Path("/candidate")
public interface JobCandidateWebservice {

	/**
	 * add candidate to the job .
	 * 
	 * @param jobId
	 *            the jobId
	 * @param jobCandidate
	 *            the jobCandidate
	 * @param attachment
	 *            the attachment
	 * @return the response
	 * @throws URISyntaxException
	 *             the URI syntax exception
	 */
	@POST
	@Path("/{job-id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response addJobCandidate(@PathParam("job-id") final String jobId,
			@Multipart("jobCandidate") String jobCandidate,
			@Multipart("file") Attachment attachment) throws Exception;
	
	
	/**
	 * @param jobId
	 * @param candidateId
	 * @param jobCandidate
	 * @param attachment
	 * @return
	 * @throws Exception
	 */
	@PUT
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Path("/{job-id}/{candidate-id}")
	public Response updateJobCandidate(@PathParam("job-id") final String jobId,
			@PathParam("candidate-id") final String candidateId,
			@Multipart("jobCandidate") JobCandidate jobCandidate,
			@Multipart("file") Attachment attachment) throws Exception;

	/**
	 * remove candidate from the job .
	 * 
	 * @param jobId
	 *            the jobId
	 * @param jobCandidate
	 *            the jobCandidate
	 * @return the response
	 * @throws URISyntaxException
	 *             the URI syntax exception
	 */
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{job-id}/{candidate-id}")
	public Response deleteJobCandidate(@PathParam("job-id") final String jobId,
			@PathParam("candidate-id") final String candidateId)
			throws URISyntaxException;
	
	/**
	 * @param candidateId
	 * @return
	 */
	@GET
    @Path("/download/{candidate_id}")
    @Produces("application/msword")
    public Response downloadCandidateResume(@PathParam("candidate_id")final int candidateId);
	
	
	/**
	 * @param candidateId
	 * @return
	 */
	@GET
    @Path("/retrieveDetails/{candidate_id}")
    @Produces("application/json")
    public Response getCandidateDetails(@PathParam("candidate_id")final int candidateId);
	
	/**
	 * @param candidateId
	 * @return
	 */
	@GET
    @Path("/retrieveCandidateDetails/{job_id}")
    @Produces("application/json")
    public Response getCandidateDetailsByJobId(@PathParam("candidate_id")final int jobId);

}
