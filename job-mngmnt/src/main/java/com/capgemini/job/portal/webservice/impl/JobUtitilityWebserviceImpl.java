/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */
package com.capgemini.job.portal.webservice.impl;

import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.job.portal.jaxb.Accounts;
import com.capgemini.job.portal.jaxb.CandidateCategories;
import com.capgemini.job.portal.jaxb.CandidateStatuses;
import com.capgemini.job.portal.jaxb.CitizenshipStatuses;
import com.capgemini.job.portal.jaxb.EmployeeTypes;
import com.capgemini.job.portal.jaxb.InterviewStatuses;
import com.capgemini.job.portal.jaxb.JobRoles;
import com.capgemini.job.portal.jaxb.JobStages;
import com.capgemini.job.portal.jaxb.JobStatuses;
import com.capgemini.job.portal.jaxb.ResourceTypes;
import com.capgemini.job.portal.jaxb.ServiceLineCapabilities;
import com.capgemini.job.portal.jaxb.ServiceLines;
import com.capgemini.job.portal.service.JobUtilityService;
import com.capgemini.job.portal.webservice.JobUtilityWebservice;

/**
 * The Class performs create, update, delete Job CreateJobDetailsWebservice.
 * 
 * @author sbasired
 */
@Component("jobUtilityWebservice")
public class JobUtitilityWebserviceImpl implements JobUtilityWebservice {

	/** Job utility service. */
	@Autowired
	private JobUtilityService jobUtilityService;

	@Override
	@GET
	@Path("/account")
	@Produces("application/json")
	public Response getAccount() throws URISyntaxException {
		Accounts accounts = jobUtilityService.getAccount();
		return Response
				.ok(accounts)
				.header("Access-Control-Allow-Origin",
						"http://10.81.82.144:8080/job-management-service/")
				.build();
		// return Response.ok(accounts).build();
	}

	@Override
	@GET
	@Path("/candidateCategory")
	@Produces("application/json")
	public Response getCandidateCategory() throws URISyntaxException {
		CandidateCategories candidateCategories = jobUtilityService
				.getCandidateCategory();
		return Response
				.ok(candidateCategories)
				.header("Access-Control-Allow-Origin",
						"http://10.81.82.144:8080/job-management-service/")
				.build();
	}

	@Override
	@GET
	@Path("/candidateStatus")
	@Produces("application/json")
	public Response getCandidateStatus() throws URISyntaxException {
		CandidateStatuses candidateStatuses = jobUtilityService
				.getCandidateStatus();
		return Response
				.ok(candidateStatuses)
				.header("Access-Control-Allow-Origin",
						"http://10.81.82.144:8080/job-management-service/")
				.build();
	}

	@Override
	@GET
	@Path("/citizenshipStatus")
	@Produces("application/json")
	public Response getCitizenshipStatus() throws URISyntaxException {
		CitizenshipStatuses citizenshipStatuses = jobUtilityService
				.getCitizenshipStatus();
		return Response
				.ok(citizenshipStatuses)
				.header("Access-Control-Allow-Origin",
						"http://10.81.82.144:8080/job-management-service/")
				.build();
	}

	@Override
	@GET
	@Path("/employeeType")
	@Produces("application/json")
	public Response getEmployeeType() throws URISyntaxException {
		EmployeeTypes employeeTypes = jobUtilityService.getEmployeeType();
		return Response
				.ok(employeeTypes)
				.header("Access-Control-Allow-Origin",
						"http://10.81.82.144:8080/job-management-service/")
				.build();
	}

	@Override
	@GET
	@Path("/interviewStatus")
	@Produces("application/json")
	public Response getInterviewStatus() throws URISyntaxException {
		InterviewStatuses interviewStatuses = jobUtilityService
				.getInterviewStatus();
		return Response
				.ok(interviewStatuses)
				.header("Access-Control-Allow-Origin",
						"http://10.81.82.144:8080/job-management-service/")
				.build();
	}

	@Override
	@GET
	@Path("/jobRole")
	@Produces("application/json")
	public Response getJobRole() throws URISyntaxException {
		JobRoles jobRoles = jobUtilityService.getJobRole();
		return Response
				.ok(jobRoles)
				.header("Access-Control-Allow-Origin",
						"http://10.81.82.144:8080/job-management-service/")
				.build();
	}

	@Override
	@GET
	@Path("/jobStage")
	@Produces("application/json")
	public Response getJobStage() throws URISyntaxException {
		JobStages jobStages = jobUtilityService.getJobStage();
		return Response
				.ok(jobStages)
				.header("Access-Control-Allow-Origin",
						"http://10.81.82.144:8080/job-management-service/")
				.build();
	}

	@Override
	@GET
	@Path("/jobStatus")
	@Produces("application/json")
	public Response getJobStatus() throws URISyntaxException {
		JobStatuses jobStatuses = jobUtilityService.getJobStatus();
		return Response
				.ok(jobStatuses)
				.header("Access-Control-Allow-Origin",
						"http://10.81.82.144:8080/job-management-service/")
				.build();
	}

	@Override
	@GET
	@Path("/resourceType")
	@Produces("application/json")
	public Response getResourceType() throws URISyntaxException {
		ResourceTypes resourceTypes = jobUtilityService.getResourceType();
		return Response
				.ok(resourceTypes)
				.header("Access-Control-Allow-Origin",
						"http://10.81.82.144:8080/job-management-service/")
				.build();
	}

	@Override
	@GET
	@Path("/serviceLine")
	@Produces("application/json")
	public Response getServiceLine() throws URISyntaxException {
		ServiceLines serviceLines = jobUtilityService.getServiceLine();
		return Response
				.ok(serviceLines)
				.header("Access-Control-Allow-Origin",
						"http://10.81.82.144:8080/job-management-service/")
				.build();
	}

	@Override
	@GET
	@Path("/serviceLineCapability")
	@Produces("application/json")
	public Response getServiceLineCapability() throws URISyntaxException {
		ServiceLineCapabilities serviceLineCapabilities = jobUtilityService
				.getServiceLineCapability();
		return Response
				.ok(serviceLineCapabilities)
				.header("Access-Control-Allow-Origin",
						"http://10.81.82.144:8080/job-management-service/")
				.build();
	}

}
