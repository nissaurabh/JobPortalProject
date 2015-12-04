/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */
package com.capgemini.job.portal.webservice.impl;

import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


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

}
