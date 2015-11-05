package com.job.mngmnt.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.job.mmngmnt.jaxb.JobDetails;

@Path("/jobDetail")
public interface CreateJobDetailsWebservice {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response storeJob(JobDetails jobDetails);

}
