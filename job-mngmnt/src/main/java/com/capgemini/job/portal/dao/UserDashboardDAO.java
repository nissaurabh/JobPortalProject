/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */
package com.capgemini.job.portal.dao;

import java.util.Map;

import com.capgemini.job.portal.entities.PortalUser;
import com.capgemini.job.portal.jaxb.User;

/**
 * The Class UserDashboardDAO.
 * 
 * @author sbasired
 */
public interface UserDashboardDAO {
	
	/**
	 *  user dashboard.
	 * 
	 * @param job
	 *            the job
	 * @return the PortalUser
	 */
	public PortalUser userDashboard(final User user);

	/**
	 * @param userId
	 * @param dashboardMap
	 * @return
	 */
	public String setUserDashboard(final String userId, final Map<String, String> dashboardMap);
	
	/**
	 * @param userId
	 * @return
	 */
	public PortalUser getPortalUserByUserId(String userId);
	
}
