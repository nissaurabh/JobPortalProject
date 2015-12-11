/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */
package com.capgemini.job.portal.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.job.portal.constants.JobMngMntConstants;
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

	/* (non-Javadoc)
	 * @see com.capgemini.job.portal.service.UserDashboardService#setUserDashboard(java.lang.String, java.lang.String)
	 */
	@Override
	public String setUserDashboard(final String userId, final String dashboardInput) {
		Map<String, String> dashbrdMap = new HashMap<String, String>();
		if(StringUtils.isNotEmpty(dashboardInput)){
			JSONObject dashboardObj = JSONObject.fromObject(dashboardInput);
			if(dashboardObj.containsKey("type") && "jobDashboard".equalsIgnoreCase(dashboardObj.getString("type"))){
				dashbrdMap.put("jobDashboard", dashboardObj.getString("value"));
			} else if(dashboardObj.containsKey("type") && "cndtDashboard".equalsIgnoreCase(dashboardObj.getString("type"))){
				dashbrdMap.put("cndtDashboard", dashboardObj.getString("value"));
			} else if(dashboardObj.containsKey("type") && "intrvwDashboard".equalsIgnoreCase(dashboardObj.getString("type"))){
				dashbrdMap.put("intrvwDashboard", dashboardObj.getString("value"));
			}
			return userDashboardDAO.setUserDashboard(userId, dashbrdMap);
		}else {
			return JobMngMntConstants.BAD_REQUEST;
		}
	}


}
