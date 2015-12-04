/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */
package com.capgemini.job.portal.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.cxf.common.util.CollectionUtils;
import org.springframework.stereotype.Service;

import com.capgemini.job.portal.dao.UserDashboardDAO;
import com.capgemini.job.portal.entities.PortalUser;
import com.capgemini.job.portal.jaxb.User;


/**
 * The Class UserDashboardDAOImpl.
 * 
 * @author sbasired
 */
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

}
