package com.job.mngmnt.webservice.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.job.mmngmnt.jaxb.JobDetails;
import com.job.mngmnt.service.JobDetailsService;
import com.job.mngmnt.webservice.CreateJobDetailsWebservice;

@Component("createJobDetailsWebservice")
public class CreateJobDetailsWebserviceImpl implements CreateJobDetailsWebservice {

	@Autowired
	private JobDetailsService jobDetailsService;

	@POST
	@Consumes("application/json")
	public Response createJob(JobDetails jobDetails) {
		
		jobDetailsService.createJob(jobDetails);
		return Response.ok().build();
	}

	@PUT
	@Consumes("application/json")
	@Path("/job-id")
	public Response updateJob(@PathParam("job-id") String jobId,
			JobDetails jobDetails) {
		// TODO Auto-generated method stub
		return Response.ok().build();
	}

	@DELETE
	@Consumes("application/json")
	@Path("/job-id")
	public Response deleteJob(@PathParam("job-id") String jobId) {
		// TODO Auto-generated method stub
		return Response.ok().build();
	}
	
}
