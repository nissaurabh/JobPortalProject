/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */

package com.capgemini.job.portal.webservice.impl;

import java.net.URISyntaxException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.job.portal.constants.JobMngMntConstants;
import com.capgemini.job.portal.jaxb.InterviewDetails;
import com.capgemini.job.portal.service.JobInterviewService;
import com.capgemini.job.portal.webservice.JobInterviewDetWebservice;

/**
 * The Class performs create, update, delete Job CreateJobDetailsWebservice.
 * 
 * @author ppenamak
 */
@CrossOriginResourceSharing(allowAllOrigins = true)
@Component("jobInterviewDetWebservice")
public class JobInterviewDetWebserviceImpl implements
		JobInterviewDetWebservice {

	/** Job Interview service. */
	@Autowired
	private JobInterviewService jobInterviewService;

	/* (non-Javadoc)
	 * @see com.capgemini.job.portal.webservice.JobInterviewDetWebservice#scheduleInterview(com.capgemini.job.portal.jaxb.InterviewDetails)
	 */
	@Override
	public Response scheduleInterview(final String jobId, final String candidateId,
			InterviewDetails interviewDetails){
		String response = null;
		try{
			System.out.println("interviewDetails : "+ interviewDetails.getIntrvwrName());
			System.out.println("Job Id : "+ jobId);
			response = jobInterviewService.scheduleInterview(jobId, candidateId, interviewDetails);
			if (response.equalsIgnoreCase(JobMngMntConstants.CREATED)) {
				return Response.status(Status.CREATED).header("Access-Control-Allow-Origin", "http://localhost:8080/job-management-service/").build();
			} else {
				return Response.status(Status.BAD_REQUEST).build();
			}
		} catch(Exception e){
			System.out.println("Error : "+ e.getMessage());
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}

	/* (non-Javadoc)
	 * @see com.capgemini.job.portal.webservice.JobInterviewDetWebservice#modifyScheduledInterview(java.lang.String, java.lang.String, java.lang.String, com.capgemini.job.portal.jaxb.InterviewDetails)
	 */
	@Override
	public Response modifyScheduledInterview(String interviewId, InterviewDetails interviewDetails)
			throws URISyntaxException {
		String response = null;
		try{
			System.out.println("interviewDetails : "+ interviewDetails.getIntrvwrName());
			System.out.println("Interview Id : "+ interviewId);
			response = jobInterviewService.updateScheduledInterview(interviewId, interviewDetails);
			if (response.equalsIgnoreCase(JobMngMntConstants.OK_STATUS)) {
				return Response.status(Status.OK).header("Access-Control-Allow-Origin", "http://localhost:8080/job-management-service/").build();
			} else {
				return Response.status(Status.NOT_FOUND).build();
			}
		} catch(Exception e){
			System.out.println("Error : "+ e.getMessage());
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	/* (non-Javadoc)
	 * @see com.capgemini.job.portal.webservice.JobInterviewDetWebservice#cancelScheduledInterview(java.lang.String)
	 */
	@Override
	public Response cancelScheduledInterview(String interviewId)
			throws URISyntaxException {
		String response = null;

		response = jobInterviewService.deleteScheduleInterview(interviewId);

		return buildResponse(response);
	}
	

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
