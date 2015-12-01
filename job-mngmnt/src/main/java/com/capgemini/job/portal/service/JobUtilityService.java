package com.capgemini.job.portal.service;

import com.capgemini.job.portal.jaxb.Accounts;
import com.capgemini.job.portal.jaxb.CandidateCategories;
import com.capgemini.job.portal.jaxb.CandidateStatuses;
import com.capgemini.job.portal.jaxb.CitizenshipStatuses;
import com.capgemini.job.portal.jaxb.EmployeeTypes;
import com.capgemini.job.portal.jaxb.InterviewStatuses;
import com.capgemini.job.portal.jaxb.JobRoles;
import com.capgemini.job.portal.jaxb.JobStages;
import com.capgemini.job.portal.jaxb.JobStatuses;
import com.capgemini.job.portal.jaxb.ResourceTypes;
import com.capgemini.job.portal.jaxb.ServiceLineCapabilities;
import com.capgemini.job.portal.jaxb.ServiceLines;

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
	 * @return CandidateCategories
	 * 			  the CandidateCategories
	 */
	public CandidateCategories getCandidateCategory();
	
	/**
	 * get the candidate status details
	 * @return the candidatesStatuses
	 */
	public CandidateStatuses getCandidateStatus();
	
	/**
	 * get the citizenship status details
	 * @return the citizenshipStatuses
	 */
	public CitizenshipStatuses getCitizenshipStatus();
	
	/**
	 * get the employee type details
	 * @return the employeeTypes
	 */
	public EmployeeTypes getEmployeeType();
	
	/**
	 * get the interview status details
	 * @return the InterviewStatuses
	 */
	public InterviewStatuses getInterviewStatus();
	
	/**
	 * get the job role details
	 * @return the jobRoles
	 */
	public JobRoles getJobRole();
	
	/**
	 * get the job stage details
	 * @return the jobStages
	 */
	public JobStages getJobStage();
	
	/**
	 * get the job status details
	 * @return the jobStatuses
	 */
	public JobStatuses getJobStatus();
	
	/**
	 * get the resource type details
	 * @return the ResourceTypes
	 */
	public ResourceTypes getResourceType();
	
	/**
	 * get the service line details
	 * @return the ServiceLines
	 */
	public ServiceLines getServiceLine();
	
	/**
	 * get the service line capability details
	 * @return the ServiceLineCapabilities
	 */
	public ServiceLineCapabilities getServiceLineCapability();

}
