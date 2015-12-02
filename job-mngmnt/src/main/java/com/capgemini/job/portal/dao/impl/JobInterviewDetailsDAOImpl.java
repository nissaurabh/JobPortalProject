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

import com.capgemini.job.portal.dao.JobInterviewDetailsDAO;
import com.capgemini.job.portal.entities.IntrvwSt;
import com.capgemini.job.portal.entities.JobIntrvw;

/**
 * The Class JobDetailsDAO.
 * 
 * @author ppenamak
 */
@SuppressWarnings("unchecked")
@Service("jobInterviewDetailsDAO")
public class JobInterviewDetailsDAOImpl implements JobInterviewDetailsDAO {

	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager entityManager;
	
	@Override
	public void createJobInterview(final JobIntrvw jobIntrvw) {
		
		entityManager.persist(jobIntrvw);

	}

	/* (non-Javadoc)
	 * @see com.capgemini.job.portal.dao.JobInterviewDetailsDAO#getInterviewStatus(int)
	 */
	@Override
	public IntrvwSt getInterviewStatus(int intrvwStsId) {
		IntrvwSt intrvwSt = null;
		final Query query = entityManager.createNamedQuery("intrvwSt.findIntrvwSt");
		query.setParameter("intrvwStsId", intrvwStsId);
		final List<IntrvwSt> intrvwStsList = query.getResultList();
		if(!CollectionUtils.isEmpty(intrvwStsList)){
			intrvwSt = intrvwStsList.get(0);
		}
		return intrvwSt;
	}

	@Override
	public JobIntrvw retrieveInterviewDetails(int jobIntrvwId) {
		JobIntrvw jobIntrvw = null;
		final Query query = entityManager.createNamedQuery("jobIntrvw.getJobIntrvwByIntrvwId");
		query.setParameter("jobIntrvwId", jobIntrvwId);
		final List<JobIntrvw> jobIntrvws = query.getResultList();
		if(!CollectionUtils.isEmpty(jobIntrvws)){
			jobIntrvw = jobIntrvws.get(0);
		}
		return jobIntrvw;
	}
	
	@Override
	public JobIntrvw updateJobInterview(final JobIntrvw jobIntrvw) {
		return entityManager.merge(jobIntrvw);
	}
	
	@Override
	public void deleteJobInterview(final JobIntrvw jobIntrvw) {
		entityManager.remove(jobIntrvw);
	}
	
}