/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */
package com.capgemini.job.portal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.job.portal.dao.UserDashboardDAO;
import com.capgemini.job.portal.entities.PortalUser;
import com.capgemini.job.portal.jaxb.User;
import com.capgemini.job.portal.jaxb.UserDashboard;
import com.capgemini.job.portal.service.UserDashboardService;

/**
 * The Class UserDashboardService.
 * 
 * @author sbasired
 */
@Component("userDashboardService")
public class UserDashboardServiceImpl implements UserDashboardService {
	
	@Autowired
	private UserDashboardDAO userDashboardDAO;

	@Override
	public UserDashboard getUserDashboard(User user) {
		
		PortalUser portalUser = userDashboardDAO.userDashboard(user);
		
		UserDashboard userDashboard = new UserDashboard();
		if(portalUser!=null){
			userDashboard.setCandidateDashboard(portalUser.getCandidateDashboard());
			userDashboard.setInterviewDashboard(portalUser.getInterviewDashboard());
			userDashboard.setJobDashboard(portalUser.getJobDashboard());
			userDashboard.setUserId(portalUser.getUserId());
			userDashboard.setUserName(portalUser.getUserName());
			userDashboard.setUserRole(portalUser.getPortalUserRole().getRoleName());
		}
		
		return userDashboard;
	}

}
