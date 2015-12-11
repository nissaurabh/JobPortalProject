/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */
package com.capgemini.job.portal.webservice;

import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.capgemini.job.portal.jaxb.User;

/**
 * The Class performs to get the administrative data JobUtilityWebservice.
 * 
 * @author sbasired
 */
@Path("/userDashboard")
public interface UserDashboardWebservice {
	
	
	/**
	 * create the job.
	 * 
	 * @param jobDetails
	 *            the jobDetails
	 * @return the response
	 * @throws URISyntaxException
	 *             the URI syntax exception
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response getUserDashboard(final User user)
			throws URISyntaxException;

	/**
	 * @param user
	 * @return
	 * @throws URISyntaxException
	 */
	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/setDashboard/{userId}")
	public Response setUserDashboard(@PathParam("userId") final String userId, final String dashboardInput) throws URISyntaxException;

	
	/**
	 * create the job.
	 * 
	 * @param jobDetails
	 *            the jobDetails
	 * @return the response
	 * @throws URISyntaxException
	 *             the URI syntax exception
	 */
	@GET
	@Produces("application/json")
	@Path("/{userId}")
	public Response getPortalUserByUserId(@PathParam("userId") final String userId)
			throws URISyntaxException;
}
