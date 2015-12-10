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
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;

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
			@Multipart("jobCandidate") JobCandidate jobCandidate,
			@Multipart("file") Attachment attachment) throws Exception;
	
	
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

}
