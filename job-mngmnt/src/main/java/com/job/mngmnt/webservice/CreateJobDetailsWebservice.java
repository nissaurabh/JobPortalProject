package com.job.mngmnt.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.job.mmngmnt.jaxb.JobDetails;

@Path("/jobDetail")
public interface CreateJobDetailsWebservice {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createJob(JobDetails jobDetails);
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/job-id")
	public Response updateJob(@PathParam("job-id") String jobId, JobDetails jobDetails);
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/job-id")
	public Response deleteJob(@PathParam("job-id") String jobId);

}
