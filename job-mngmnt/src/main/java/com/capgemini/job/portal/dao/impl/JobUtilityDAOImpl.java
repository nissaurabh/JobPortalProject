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

import org.springframework.stereotype.Service;

import com.capgemini.job.portal.dao.JobUtilityDAO;
import com.capgemini.job.portal.entities.Account;
import com.capgemini.job.portal.entities.CndtCtg;
import com.capgemini.job.portal.entities.CndtSt;
import com.capgemini.job.portal.entities.CtznshpSt;
import com.capgemini.job.portal.entities.EmplTyp;
import com.capgemini.job.portal.entities.IntrvwSt;
import com.capgemini.job.portal.entities.JobRole;
import com.capgemini.job.portal.entities.JobSt;
import com.capgemini.job.portal.entities.JobStg;
import com.capgemini.job.portal.entities.ResourceTyp;
import com.capgemini.job.portal.entities.ServiceLn;
import com.capgemini.job.portal.entities.ServiceLnCap;

/**
 * The Class JobUtilityDAOImpl.
 * 
 * @author sbasired
 */
@Service("jobUtilityDAO")
public class JobUtilityDAOImpl implements JobUtilityDAO{
	
	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager entityManager;

	@Override
	public List<Account> getAccount() {
		
		final Query query = entityManager.createNamedQuery("account.getAccount");
		final List<Account> List = (List<Account>) query.getResultList();

		return List;
	}

	@Override
	public CndtCtg getCandidateCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CndtSt getCandidateStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CtznshpSt getCitizenshipStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmplTyp getEmployeeType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IntrvwSt getInterviewStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JobRole getJobRole() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JobStg getJobStage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JobSt getJobStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResourceTyp getResourceType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceLn getServiceLine() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceLnCap getServiceLineCapability() {
		// TODO Auto-generated method stub
		return null;
	}

}
