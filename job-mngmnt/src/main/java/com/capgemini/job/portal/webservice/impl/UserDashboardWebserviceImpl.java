/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */
package com.capgemini.job.portal.webservice.impl;

import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.job.portal.constants.JobMngMntConstants;
import com.capgemini.job.portal.jaxb.User;
import com.capgemini.job.portal.jaxb.UserDashboard;
import com.capgemini.job.portal.service.UserDashboardService;
import com.capgemini.job.portal.webservice.UserDashboardWebservice;

/**
 * The Class UserDashboardWebservice.
 * 
 * @author sbasired
 */
@CrossOriginResourceSharing(allowAllOrigins = true)
@Component("userDashboardWebservice")
public class UserDashboardWebserviceImpl implements UserDashboardWebservice{

	
	@Autowired
	private UserDashboardService userDashboardService;
	
	@Override
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response getUserDashboard(User user) throws URISyntaxException {
		UserDashboard userDashboard = userDashboardService.getUserDashboard(user);
		return Response
				.ok(userDashboard)
				.header("Access-Control-Allow-Origin",
						"http://10.81.82.144:8080/job-management-service/")
				.build();
	}

	@Override
	public Response setUserDashboard(final String userId, final String dashboardInput)
			throws URISyntaxException {
		String response = userDashboardService.setUserDashboard(userId, dashboardInput);
		return buildResponse(response);
	}
	
	/**
	 * get user dashboard urls.
	 * 
	 * @param userId
	 *            the userId
	 * @return the response
	 * @throws URISyntaxException
	 *             the URI syntax exception
	 */
	@GET
	@Produces("application/json")
	@Path("/{userId}")
	public Response getPortalUserByUserId(@PathParam("userId") final String userId)
			throws URISyntaxException{
		
		UserDashboard userDashboard = userDashboardService.getPortalUserByUserId(userId);
		return Response.ok(userDashboard).build();
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
		} else if (response.equalsIgnoreCase(JobMngMntConstants.BAD_REQUEST)) {
			responseObj = Response.status(Status.BAD_REQUEST);
		}
		return responseObj.header("Access-Control-Allow-Origin",
				"http://10.81.82.144:8080/job-management-service/").build();
	}
	

}
