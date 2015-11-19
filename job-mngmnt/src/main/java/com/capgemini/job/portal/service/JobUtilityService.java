package com.capgemini.job.portal.service;

import com.capgemini.job.portal.jaxb.Accounts;
import com.capgemini.job.portal.jaxb.CandidateCategory;
import com.capgemini.job.portal.jaxb.CandidateStatus;
import com.capgemini.job.portal.jaxb.CitizenshipStatus;
import com.capgemini.job.portal.jaxb.EmployeeType;
import com.capgemini.job.portal.jaxb.InterviewStatus;
import com.capgemini.job.portal.jaxb.JobRole;
import com.capgemini.job.portal.jaxb.JobStage;
import com.capgemini.job.portal.jaxb.JobStatus;
import com.capgemini.job.portal.jaxb.ResourceType;
import com.capgemini.job.portal.jaxb.ServiceLine;
import com.capgemini.job.portal.jaxb.ServiceLineCapability;

/**
 * The Class performs to get the administrative data JobUtilityService.
 * 
 * @author sbasired
 */
public interface JobUtilityService {
	
	
	/**
	 * get the account details.
	 * @return account
	 * 			  the account
	 */
	public Accounts getAccount();
	
	/**
	 * get the candidate category details.
	 * @return candidateCategory
	 * 			  the candidateCategory
	 */
	public CandidateCategory getCandidateCategory();
	
	/**
	 * get the candidate status details
	 * @return the candidateStatus
	 */
	public CandidateStatus getCandidateStatus();
	
	/**
	 * get the citizenship status details
	 * @return the citizenshipStatus
	 */
	public CitizenshipStatus getCitizenshipStatus();
	
	/**
	 * get the employee type details
	 * @return the employeeType
	 */
	public EmployeeType getEmployeeType();
	
	/**
	 * get the interview status details
	 * @return the InterviewStatus
	 */
	public InterviewStatus getInterviewStatus();
	
	/**
	 * get the job role details
	 * @return the jobRole
	 */
	public JobRole getJobRole();
	
	/**
	 * get the job stage details
	 * @return the jobStage
	 */
	public JobStage getJobStage();
	
	/**
	 * get the job status details
	 * @return the jobStatus
	 */
	public JobStatus getJobStatus();
	
	/**
	 * get the resource type details
	 * @return the resourceType
	 */
	public ResourceType getResourceType();
	
	/**
	 * get the service line details
	 * @return the serviceLine
	 */
	public ServiceLine getServiceLine();
	
	/**
	 * get the service line capability details
	 * @return the serviceLineCapability
	 */
	public ServiceLineCapability getServiceLineCapability();

}
