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

import com.capgemini.job.portal.constants.JobMngMntConstants;
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
	
	/* (non-Javadoc)
	 * @see com.capgemini.job.portal.dao.JobInterviewDetailsDAO#createJobInterview(com.capgemini.job.portal.entities.JobIntrvw)
	 */
	@Override
	public String createJobInterview(final JobIntrvw jobIntrvw) {
		JobIntrvw jobIntrvwTemp = retrieveInterviewDetailsByJobAndCandId(jobIntrvw.getJob().getJobId(),jobIntrvw.getJobCndt().getCndtId(),
				jobIntrvw.getIntrvrNm());
		if(null == jobIntrvwTemp){
			entityManager.persist(jobIntrvw);
			return JobMngMntConstants.CREATED;
		} else {
			return JobMngMntConstants.FORBIDDEN;
		}
	}
	
	
	/**
	 * @param jobId
	 * @param cndtId
	 * @param intrvwrName
	 * @return
	 */
	public JobIntrvw retrieveInterviewDetailsByJobAndCandId(int jobId, int cndtId, String intrvwrName) {
		JobIntrvw jobIntrvw = null;
		final Query query = entityManager.createNamedQuery("jobIntrvw.getJobIntrvwByJobIdCndtIdAndIntvrNm");
		query.setParameter("jobId", jobId);
		query.setParameter("cndtId", cndtId);
		query.setParameter("intrvwrName", intrvwrName);
		final List<JobIntrvw> jobIntrvws = query.getResultList();
		if(!CollectionUtils.isEmpty(jobIntrvws)){
			jobIntrvw = jobIntrvws.get(0);
		}
		return jobIntrvw;
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

	/* (non-Javadoc)
	 * @see com.capgemini.job.portal.dao.JobInterviewDetailsDAO#retrieveInterviewDetails(int)
	 */
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
	
	/* (non-Javadoc)
	 * @see com.capgemini.job.portal.dao.JobInterviewDetailsDAO#updateJobInterview(com.capgemini.job.portal.entities.JobIntrvw)
	 */
	@Override
	public JobIntrvw updateJobInterview(final JobIntrvw jobIntrvw) {
		return entityManager.merge(jobIntrvw);
	}
	
	/* (non-Javadoc)
	 * @see com.capgemini.job.portal.dao.JobInterviewDetailsDAO#deleteJobInterview(com.capgemini.job.portal.entities.JobIntrvw)
	 */
	@Override
	public void deleteJobInterview(final JobIntrvw jobIntrvw) {
		entityManager.remove(jobIntrvw);
	}
	
}