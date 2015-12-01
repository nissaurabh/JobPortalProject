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
	public List<CndtCtg> getCandidateCategory() {
		Query query = entityManager.createQuery("SELECT cndtCtg FROM CndtCtg cndtCtg");
		List<CndtCtg> candtCategories = query.getResultList();
		return candtCategories;
	}

	@Override
	public List<CndtSt> getCandidateStatus() {
		Query query = entityManager.createQuery("SELECT cndtSt FROM CndtSt cndtSt");
		List<CndtSt> candidateStatuses = query.getResultList();
		return candidateStatuses;
	}

	@Override
	public List<CtznshpSt> getCitizenshipStatus() {
		Query query = entityManager.createQuery("SELECT ctznshpSt FROM CtznshpSt ctznshpSt");
		List<CtznshpSt> citizenshipStatuses = query.getResultList();
		return citizenshipStatuses;
	}

	@Override
	public List<EmplTyp> getEmployeeType() {
		Query query = entityManager.createQuery("SELECT emplTyp FROM EmplTyp emplTyp");
		List<EmplTyp> employeeTypeList = query.getResultList();
		return employeeTypeList;
	}

	@Override
	public List<IntrvwSt> getInterviewStatus() {
		Query query = entityManager.createQuery("SELECT intrvwSt FROM IntrvwSt intrvwSt");
		List<IntrvwSt> interviwStatusList = query.getResultList();
		return interviwStatusList;
	}

	@Override
	public List<JobRole> getJobRole() {
		Query query = entityManager.createQuery("SELECT jobRole FROM JobRole jobRole");
		List<JobRole> jobRoleList = query.getResultList();
		return jobRoleList;
	}

	@Override
	public List<JobStg> getJobStage() {
		Query query = entityManager.createQuery("SELECT jobStg FROM JobStg jobStg");
		List<JobStg> jobStgList = query.getResultList();
		return jobStgList;
	}

	@Override
	public List<JobSt> getJobStatus() {
		Query query = entityManager.createQuery("SELECT jobSt FROM JobSt jobSt");
		List<JobSt> jobStList = query.getResultList();
		return jobStList;
	}

	@Override
	public List<ResourceTyp> getResourceType() {
		Query query = entityManager.createQuery("SELECT resourceTyp FROM ResourceTyp resourceTyp");
		List<ResourceTyp> resourceTypList = query.getResultList();
		return resourceTypList;
	}

	@Override
	public List<ServiceLn> getServiceLine() {
		Query query = entityManager.createQuery("SELECT srviceLn FROM ServiceLn srviceLn");
		List<ServiceLn> srviceLnList = query.getResultList();
		return srviceLnList;
	}

	@Override
	public List<ServiceLnCap> getServiceLineCapability() {
		Query query = entityManager.createQuery("SELECT serviceLnCap FROM ServiceLnCap serviceLnCap");
		List<ServiceLnCap> serviceLnCapList = query.getResultList();
		return serviceLnCapList;
	}

}
