/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */
package com.capgemini.job.portal.service;

import com.capgemini.job.portal.entities.PortalUser;
import com.capgemini.job.portal.jaxb.User;
import com.capgemini.job.portal.jaxb.UserDashboard;

/**
 * The Class performs UserDashboardService.
 * 
 * @author sbasired
 */
public interface UserDashboardService {
	
	
	/**
	 * validate user role and get dashboard data.
	 * 
	 * @param user
	 *            the user
	 * @return the UserDashboard
	 */
	public UserDashboard getUserDashboard(final User user);
	
	
	/**
	 * @param userId
	 * @param dashboardInput
	 * @return
	 */
	public String setUserDashboard(String userId, String dashboardInput);
	

	/**
	 * @param userId
	 * @return
	 */
	public UserDashboard getPortalUserByUserId(String userId);

}
