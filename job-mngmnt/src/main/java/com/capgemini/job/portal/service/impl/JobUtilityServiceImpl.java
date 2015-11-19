package com.capgemini.job.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.job.portal.dao.JobUtilityDAO;
import com.capgemini.job.portal.entities.Account;
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
import com.capgemini.job.portal.service.JobUtilityService;

/**
 * The Class performs to get the administrative details JobDetailsService.
 * 
 * @author sbasired
 */
@Component("jobUtilityService")
public class JobUtilityServiceImpl implements JobUtilityService{

	@Autowired
	private JobUtilityDAO jobUtilityDAO;
	
	@Transactional
	@Override
	public Accounts getAccount() {
		List<Account> acctList = jobUtilityDAO
				.getAccount();
		return getAccounts(acctList);
	}

	@Override
	public CandidateCategory getCandidateCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CandidateStatus getCandidateStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CitizenshipStatus getCitizenshipStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeType getEmployeeType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InterviewStatus getInterviewStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JobRole getJobRole() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JobStage getJobStage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JobStatus getJobStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResourceType getResourceType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceLine getServiceLine() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceLineCapability getServiceLineCapability() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Accounts getAccounts(List<Account> acctList){
		Accounts accounts = new Accounts();
		List<Accounts.Account> acctsList = accounts.getAccount();
		for(Account account: acctList){
			Accounts.Account jaxbAccount = new Accounts.Account();
			jaxbAccount.setAccountId(String.valueOf(account.getClntId()));
			jaxbAccount.setAccountName(account.getClntNm());
			acctsList.add(jaxbAccount);
		}
		return accounts;
	}

}
