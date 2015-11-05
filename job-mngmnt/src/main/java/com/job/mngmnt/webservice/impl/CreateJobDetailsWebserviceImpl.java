package com.job.mngmnt.webservice.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
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
	public Response storeJob(JobDetails jobDetails) {
		
		jobDetailsService.createJob(jobDetails);
		return Response.ok().build();
	}	
	
}
