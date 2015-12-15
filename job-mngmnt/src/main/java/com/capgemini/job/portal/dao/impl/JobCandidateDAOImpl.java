package com.capgemini.job.portal.dao.impl;
/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.cxf.common.util.CollectionUtils;
import org.springframework.stereotype.Service;

import com.capgemini.job.portal.dao.JobCandidateDAO;
import com.capgemini.job.portal.entities.CndtCtg;
import com.capgemini.job.portal.entities.CndtSt;
import com.capgemini.job.portal.entities.CtznshpSt;
import com.capgemini.job.portal.entities.JobCndt;
import com.capgemini.job.portal.entities.ResourceTyp;

/**
 * The Class JobCandidateDAO.
 * 
 * @author sbasired
 */
@Service("jobCandidateDAO")
public class JobCandidateDAOImpl implements JobCandidateDAO{

	
	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager entityManager;
	
	@Override
	public void addJobCandidate(final JobCndt jobCndt) {
		entityManager.persist(jobCndt);
	}

	@Override
	public void updateJobCandidate(final JobCndt jobCndt) {
		entityManager.merge(jobCndt);
	}

	@Override
	public void deleteJobCandidate(final JobCndt jobCndt) {
		entityManager.remove(jobCndt);
	}
	
	

	@Override
	public CndtCtg getCndtCtg(final int cadtCtgId) {
		
		CndtCtg cndtCtg = null;
		final Query query = entityManager.createNamedQuery("cndtCtg.findCndtCtg");
		query.setParameter("cndtCtgId", cadtCtgId);
		final List<CndtCtg> cndtCtgList = (List<CndtCtg>) query.getResultList();
		
		if(!CollectionUtils.isEmpty(cndtCtgList)){
			cndtCtg = cndtCtgList.get(0);
		}
		
		return cndtCtg;
	}
	

	@Override
	public CndtSt getCndtSt(final int cndtStId) {
		
		CndtSt cndtSt = null;
		final Query query = entityManager.createNamedQuery("cndtSt.findCndtSt");
		query.setParameter("cndtStsId", cndtStId);
		final List<CndtSt> cndtStList = (List<CndtSt>) query.getResultList();
		
		if(!CollectionUtils.isEmpty(cndtStList)){
			cndtSt = cndtStList.get(0);
		}
		
		return cndtSt;
	}
	
	@Override
	public CtznshpSt getCtznshpSt(final int ctznshpStId) {
		
		CtznshpSt ctznshpSt = null;
		final Query query = entityManager.createNamedQuery("ctznshpSt.findctznshpSt");
		query.setParameter("ctznShpId", ctznshpStId);
		final List<CtznshpSt> ctznshpStList = (List<CtznshpSt>) query.getResultList();
		
		if(!CollectionUtils.isEmpty(ctznshpStList)){
			ctznshpSt = ctznshpStList.get(0);
		}
		
		return ctznshpSt;
	}
	

	@Override
	public ResourceTyp getResourceTyp(final int resourceTypId) {
		
		ResourceTyp resourceTyp = null;
		final Query query = entityManager.createNamedQuery("resourceTyp.findResourceTyp");
		query.setParameter("resTypId", resourceTypId);
		final List<ResourceTyp> resourceTypList = (List<ResourceTyp>) query.getResultList();
		
		if(!CollectionUtils.isEmpty(resourceTypList)){
			resourceTyp = resourceTypList.get(0);
		}
		
		return resourceTyp;
	}
	
	@Override
	public JobCndt getJobCndtByJobIdAndJobCndtId(final int jobId, final int jobCndtId){
		
		JobCndt jobCndt = null;
		final Query query = entityManager.createNamedQuery("jobCndt.findByJobIdAndJobCndtId");
		query.setParameter("cndtId", jobCndtId);
		query.setParameter("jobId", jobId);
		final List<JobCndt> jobCndtList = (List<JobCndt>) query.getResultList();
		
		if(!CollectionUtils.isEmpty(jobCndtList)){
			jobCndt = jobCndtList.get(0);
		}
		
		return jobCndt;
	}
	
	
	@Override
	public JobCndt getJobCndtByJobCndtId(final int jobCndtId){
		
		JobCndt jobCndt = null;
		final Query query = entityManager.createNamedQuery("jobCndt.findJobCndt");
		query.setParameter("cndtId", jobCndtId);
		final List<JobCndt> jobCndtList = (List<JobCndt>) query.getResultList();
		
		if(!CollectionUtils.isEmpty(jobCndtList)){
			jobCndt = jobCndtList.get(0);
		}
		
		return jobCndt;
	}

}
