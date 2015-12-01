/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */
package com.capgemini.job.portal.dao;

import java.util.List;

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
 * The Class JobUtilityDAO.
 * 
 * @author sbasired
 */
public interface JobUtilityDAO {
	
	/**
	 * get the account details.
	 * @return account
	 * 			  the account
	 */
	public List<Account> getAccount();
	
	/**
	 * get the candidate category details.
	 * @return CndtCtg
	 * 			  the CndtCtg
	 */
	public List<CndtCtg> getCandidateCategory();
	
	/**
	 * get the candidate status details
	 * @return the CndtSt
	 */
	public List<CndtSt> getCandidateStatus();
	
	/**
	 * get the citizenship status details
	 * @return the CtznshpSt
	 */
	public List<CtznshpSt> getCitizenshipStatus();
	
	/**
	 * get the employee type details
	 * @return the EmplTyp
	 */
	public List<EmplTyp> getEmployeeType();
	
	/**
	 * get the interview status details
	 * @return the IntrvwSt
	 */
	public List<IntrvwSt> getInterviewStatus();
	
	/**
	 * get the job role details
	 * @return the JobRole
	 */
	public List<JobRole> getJobRole();
	
	/**
	 * get the job stage details
	 * @return the JobStg
	 */
	public List<JobStg> getJobStage();
	
	/**
	 * get the job status details
	 * @return the JobSt
	 */
	public List<JobSt> getJobStatus();
	
	/**
	 * get the resource type details
	 * @return the ResourceTyp
	 */
	public List<ResourceTyp> getResourceType();
	
	/**
	 * get the service line details
	 * @return the ServiceLn
	 */
	public List<ServiceLn> getServiceLine();
	
	/**
	 * get the service line capability details
	 * @return the ServiceLnCap
	 */
	public List<ServiceLnCap> getServiceLineCapability();

}
