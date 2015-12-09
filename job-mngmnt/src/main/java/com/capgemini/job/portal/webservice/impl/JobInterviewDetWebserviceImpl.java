/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */

package com.capgemini.job.portal.webservice.impl;

import java.net.URISyntaxException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
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
			} else if(response.equalsIgnoreCase(JobMngMntConstants.FORBIDDEN)){
				return Response.status(Status.FORBIDDEN).header("Access-Control-Allow-Origin",
						"http://10.81.82.144:8080/job-management-service/").build();
			} else {
				return Response.status(Status.BAD_REQUEST).header("Access-Control-Allow-Origin",
						"http://10.81.82.144:8080/job-management-service/").build();
			}
		} catch(Exception e){
			System.out.println("Error : "+ e.getMessage());
			return Response.status(Status.INTERNAL_SERVER_ERROR).header("Access-Control-Allow-Origin",
					"http://10.81.82.144:8080/job-management-service/").build();
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
				return Response.status(Status.NOT_FOUND).header("Access-Control-Allow-Origin",
						"http://10.81.82.144:8080/job-management-service/").build();
			}
		} catch(Exception e){
			System.out.println("Error : "+ e.getMessage());
			return Response.status(Status.INTERNAL_SERVER_ERROR).header("Access-Control-Allow-Origin",
					"http://10.81.82.144:8080/job-management-service/").build();
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
	

	/**
	 * build the response object.
	 * 
	 * @param response
	 *            the response
	 * @return the responseObj
	 * @throws URISyntaxException
	 *             the URI syntax exception
	 */
	private Response buildResponse(final String response)
			throws URISyntaxException {
		ResponseBuilder responseObj = null;
		if (response.equalsIgnoreCase(JobMngMntConstants.NOT_FOUND)) {
			responseObj = Response.status(Status.NOT_FOUND);
		} else if (response.equalsIgnoreCase(JobMngMntConstants.OK_STATUS)) {

			responseObj = Response.status(Status.OK);
		} else if (response.equalsIgnoreCase(JobMngMntConstants.CREATED)) {

			responseObj = Response.status(Status.CREATED);
		}
		return responseObj.header("Access-Control-Allow-Origin",
				"http://10.81.82.144:8080/job-management-service/").build();
	}

}
