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
		return Response.ok(accounts).header("Access-Control-Allow-Origin", "http://10.81.82.144:8080/job-management-service/").build();
		//return Response.ok(accounts).build();
	}

	@Override
	@GET
	@Path("/candidateCategory")
	@Produces("application/json")
	public Response getCandidateCategory() throws URISyntaxException {
		CandidateCategories candidateCategories = jobUtilityService.getCandidateCategory();
		return Response.ok(candidateCategories).header("Access-Control-Allow-Origin", "http://10.81.82.144:8080/job-management-service/").build();
	}

	@Override
	@GET
	@Path("/candidateStatus")
	@Produces("application/json")
	public Response getCandidateStatus() throws URISyntaxException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GET
	@Path("/citizenshipStatus")
	@Produces("application/json")
	public Response getCitizenshipStatus() throws URISyntaxException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GET
	@Path("/employeeType")
	@Produces("application/json")
	public Response getEmployeeType() throws URISyntaxException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GET
	@Path("/interviewStatus")
	@Produces("application/json")
	public Response getInterviewStatus() throws URISyntaxException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GET
	@Path("/jobRole")
	@Produces("application/json")
	public Response getJobRole() throws URISyntaxException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GET
	@Path("/jobStage")
	@Produces("application/json")
	public Response getJobStage() throws URISyntaxException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GET
	@Path("/jobStatus")
	@Produces("application/json")
	public Response getJobStatus() throws URISyntaxException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GET
	@Path("/resourceType")
	@Produces("application/json")
	public Response getResourceType() throws URISyntaxException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GET
	@Path("/serviceLine")
	@Produces("application/json")
	public Response getServiceLine() throws URISyntaxException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GET
	@Path("/serviceLineCapability")
	@Produces("application/json")
	public Response getServiceLineCapability() throws URISyntaxException {
		// TODO Auto-generated method stub
		return null;
	}

}
