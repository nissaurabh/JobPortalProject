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
	@SuppressWarnings("unchecked")
	@Override
	public String setUserDashboard(final String userId, final String dashboardInput) {
		JSONObject dashboardObj = JSONObject.fromObject(dashboardInput);
		if(dashboardObj.containsKey("dashboard")){
			JSONArray inputArray = dashboardObj.getJSONArray("dashboard");
			Map<String, String> dashbrdMap = new HashMap<String, String>();
			if(!JSONUtils.isNull(inputArray) && inputArray.size() > 0){
				for (Iterator<JSONObject> iterator = inputArray.iterator(); iterator
						.hasNext();) {
					JSONObject object = (JSONObject) iterator.next();
					if(object.containsKey("type") && "jobDashboard".equalsIgnoreCase(object.getString("type"))){
						dashbrdMap.put("jobDashboard", dashboardObj.getString("value"));
					} else if(object.containsKey("type") && "cndtDashboard".equalsIgnoreCase(object.getString("type"))){
						dashbrdMap.put("cndtDashboard", dashboardObj.getString("value"));
					} else if(object.containsKey("type") && "intrvwDashboard".equalsIgnoreCase(object.getString("type"))){
						dashbrdMap.put("intrvwDashboard", dashboardObj.getString("value"));
					}
					
				}
			}
			return userDashboardDAO.setUserDashboard(userId, dashbrdMap);
		} else {
			return JobMngMntConstants.BAD_REQUEST;
		}
	}

	@Override
	public UserDashboard getPortalUserByUserId(String userId) {
		PortalUser portalUser = userDashboardDAO.getPortalUserByUserId(userId);
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
