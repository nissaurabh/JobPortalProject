/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */
package com.capgemini.job.portal.webservice;

import java.net.URISyntaxException;
import java.util.List;

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
import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;

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
	 * @param multipartBody
	 *            the multipartBody
	 * @return the response
	 * @throws URISyntaxException
	 *             the URI syntax exception
	 */
	/*@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Path("/{job-id}")
	public Response addJobCandidate(@PathParam("job-id") final String jobId, JobCandidate jobCandidate,
			List<Attachment> attachments) throws URISyntaxException,Exception;*/

	@POST
	@Consumes("multipart/mixed")
	@Path("/{job-id}")
	public Response addJobCandidate(@PathParam("job-id") final String jobId, /*@Multipart(value="jobCandidate") JobCandidate jobCandidate,*/ 
		   List<Attachment> attachments, String body) throws URISyntaxException,Exception;
	
	
	/**
	 * update candidate to the job .
	 * 
	 * @param jobId
	 *            the jobId
	 * @param candidateId
	 *            the candidateId
	 * @param multipartBody
	 *            the multipartBody
	 * @return the response
	 * @throws URISyntaxException
	 *             the URI syntax exception
	 */
	@PUT
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Path("/{job-id}/{candidate-id}")
	public Response updateJobCandidate(@PathParam("job-id") final String jobId,
			@PathParam("candidate-id") final String candidateId,
			final MultipartBody multipartBody) throws URISyntaxException;

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

}
