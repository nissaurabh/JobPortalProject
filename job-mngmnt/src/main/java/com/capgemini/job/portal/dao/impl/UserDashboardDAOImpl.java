/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */
package com.capgemini.job.portal.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.cxf.common.util.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.job.portal.constants.JobMngMntConstants;
import com.capgemini.job.portal.dao.UserDashboardDAO;
import com.capgemini.job.portal.entities.PortalUser;
import com.capgemini.job.portal.jaxb.User;


/**
 * The Class UserDashboardDAOImpl.
 * 
 * @author sbasired
 */
@SuppressWarnings("unchecked")
@Service("userDashboardDAO")
public class UserDashboardDAOImpl implements UserDashboardDAO{
	
	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager entityManager;

	@Override
	public PortalUser userDashboard(User user) {
		PortalUser portalUser = null;
		final Query query = entityManager
				.createQuery("SELECT portalUser FROM PortalUser portalUser where userId=:userId and password=:password");
		query.setParameter("userId", user.getUserId());
		query.setParameter("password", user.getPassword());
		final List<PortalUser> portalUserList = (List<PortalUser>) query.getResultList();
		
		if(!CollectionUtils.isEmpty(portalUserList)){
			portalUser = portalUserList.get(0);
		}
		
		return portalUser;
	}
	
	/* (non-Javadoc)
	 * @see com.capgemini.job.portal.dao.UserDashboardDAO#setUserDashboard(java.lang.String, java.util.Map)
	 */
	@Transactional
	@Override
	public String setUserDashboard(final String userId, final Map<String, String> dashboardMap) {
		try{
			PortalUser user = getPortalUserByUserId(userId);
			if(null != user){
				if(dashboardMap.containsKey("jobDashboard")){
					user.setJobDashboard(dashboardMap.get("jobDashboard"));
				}
				if(dashboardMap.containsKey("cndtDashboard")){
					user.setCandidateDashboard(dashboardMap.get("cndtDashboard"));
				}
				if(dashboardMap.containsKey("intrvwDashboard")){
					user.setInterviewDashboard(dashboardMap.get("intrvwDashboard"));
				}
				entityManager.merge(user);
				return JobMngMntConstants.CREATED;
			}
			return JobMngMntConstants.NOT_FOUND;
		} catch(Exception e){
			return JobMngMntConstants.ERROR;
		}
	}

	/**
	 * @param userId
	 * @return
	 */
	private PortalUser getPortalUserByUserId(String userId) {
		PortalUser portalUser = null;
		final Query query = entityManager
				.createQuery("SELECT portalUser FROM PortalUser portalUser where userId=:userId");
		query.setParameter("userId",userId);
		final List<PortalUser> portalUserList = (List<PortalUser>) query.getResultList();
		if(!CollectionUtils.isEmpty(portalUserList)){
			portalUser = portalUserList.get(0);
		}
		return portalUser;
	}

}
