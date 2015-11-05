/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */
package com.job.mngmnt.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.cxf.common.util.CollectionUtils;
import org.springframework.stereotype.Service;

import com.job.mngmnt.dao.JobDetailsDAO;
import com.job.mngmnt.entities.Account;
import com.job.mngmnt.entities.EmplTyp;
import com.job.mngmnt.entities.Job;
import com.job.mngmnt.entities.JobRole;
import com.job.mngmnt.entities.JobSt;
import com.job.mngmnt.entities.JobStg;

/**
 * The Class JobDetailsDAO.
 * 
 * @author sbasired
 */
@Service("jobDetailsDAO")
public class JobDetailsDAOImpl implements JobDetailsDAO {

	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager entityManager;

	@Override
	public void createJob(final Job job) {
		
		entityManager.persist(job);

	}
	
	@Override
	public void updateJob(final Job job) {
		entityManager.merge(job);		
	}

	@Override
	public void deleteJob(final Job job) {
		
		entityManager.remove(job);
		
	}
	
	@Override
	public Job getJob(final String jobId){
		
		Job job = null;
		
		final Query query = entityManager.createNamedQuery("job.findJob");
		query.setParameter("jobId", Integer.parseInt(jobId));
		final List<Job> jobList = (List<Job>) query.getResultList();
		
		if(!CollectionUtils.isEmpty(jobList)){
			job = jobList.get(0);
		}
		return job;
		
	}

	@Override
	public Account getAccount(final int acctId) {
		Account accout = null;
		final Query query = entityManager.createNamedQuery("account.findAccount");
		query.setParameter("clntId", acctId);
		final List<Account> acctList = (List<Account>) query.getResultList();
		
		if(!CollectionUtils.isEmpty(acctList)){
			accout = acctList.get(0);
		}
		
		return accout;

	}
	
	@Override
	public EmplTyp getEmplTyp(final int emptTypId) {
		EmplTyp emplTyp = null;
		final Query query = entityManager.createNamedQuery("emplTyp.findEmplTyp");
		query.setParameter("emptTypId", emptTypId);
		final List<EmplTyp> emplTypList = (List<EmplTyp>) query.getResultList();
		
		if(!CollectionUtils.isEmpty(emplTypList)){
			emplTyp = emplTypList.get(0);
		}
		
		return emplTyp;

	}
	
	@Override
	public JobRole getJobRole(final int jobRlId) {
		JobRole jobRole = null;
		final Query query = entityManager.createNamedQuery("jobRole.findJobRole");
		query.setParameter("jobRlId", jobRlId);
		final List<JobRole> jobRoleList = (List<JobRole>) query.getResultList();
		
		if(!CollectionUtils.isEmpty(jobRoleList)){
			jobRole = jobRoleList.get(0);
		}
		
		return jobRole;

	}
	
	@Override
	public JobSt getJobStatus(final int jobStsId) {
		JobSt jobSt = null;
		final Query query = entityManager.createNamedQuery("jobSt.findJobSt");
		query.setParameter("jobStsId", jobStsId);
		final List<JobSt> jobStList = (List<JobSt>) query.getResultList();
		
		if(!CollectionUtils.isEmpty(jobStList)){
			jobSt = jobStList.get(0);
		}
		
		return jobSt;

	}
	
	@Override
	public JobStg getJobStage(final int jobStgId) {
		JobStg jobStg = null;
		final Query query = entityManager.createNamedQuery("jobStg.findJobStgId");
		query.setParameter("jobStgId", jobStgId);
		final List<JobStg> jobStgList = (List<JobStg>) query.getResultList();
		
		if(!CollectionUtils.isEmpty(jobStgList)){
			jobStg = jobStgList.get(0);
		}
		
		return jobStg;

	}

}