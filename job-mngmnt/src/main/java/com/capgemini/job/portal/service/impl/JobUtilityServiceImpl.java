package com.capgemini.job.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.job.portal.dao.JobUtilityDAO;
import com.capgemini.job.portal.entities.Account;
import com.capgemini.job.portal.entities.CndtCtg;
import com.capgemini.job.portal.entities.CndtSt;
import com.capgemini.job.portal.entities.CtznshpSt;
import com.capgemini.job.portal.entities.EmplTyp;
import com.capgemini.job.portal.entities.IntrvwSt;
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
	public CandidateCategories getCandidateCategory() {
		List<CndtCtg> cndtCtgList = jobUtilityDAO
				.getCandidateCategory();
		return getCandidateCategories(cndtCtgList);
	}

	@Override
	public CandidateStatuses getCandidateStatus() {
		List<CndtSt> cndtStList = jobUtilityDAO
				.getCandidateStatus();
		return getCandidateStatus(cndtStList);
	}

	@Override
	public CitizenshipStatuses getCitizenshipStatus() {
		List<CtznshpSt> ctznshpStList = jobUtilityDAO.getCitizenshipStatus();
		return getCitizenshipStatus(ctznshpStList);
	}

	@Override
	public EmployeeTypes getEmployeeType() {
		List<EmplTyp> emplTypStList = jobUtilityDAO.getEmployeeType();
		return getEmployeeType(emplTypStList);
	}

	@Override
	public InterviewStatuses getInterviewStatus() {
		List<IntrvwSt> intrvwStList = jobUtilityDAO.getInterviewStatus();
		return getIntervewStatus(intrvwStList);
	}

	@Override
	public JobRoles getJobRole() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JobStages getJobStage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JobStatuses getJobStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResourceTypes getResourceType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceLines getServiceLine() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceLineCapabilities getServiceLineCapability() {
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

	
	private CandidateCategories getCandidateCategories(List<CndtCtg> cndtCtgList){
		CandidateCategories candidateCategories = new CandidateCategories();
		List<CandidateCategories.CandidateCategory> categoriesList = candidateCategories.getCandidateCategory();
		for(CndtCtg cndtCtg: cndtCtgList){
			CandidateCategories.CandidateCategory jaxbCndtCtg = new CandidateCategories.CandidateCategory();
			jaxbCndtCtg.setCandidateCategoryId(String.valueOf(cndtCtg.getCndtCtgId()));
			jaxbCndtCtg.setCandidateCategoryName(cndtCtg.getCndtCtgNm());
			categoriesList.add(jaxbCndtCtg);
		}
		return candidateCategories;
	}
	
	private CandidateStatuses getCandidateStatus(List<CndtSt> cndtStList){
		CandidateStatuses candidateStatuses = new CandidateStatuses();
		List<CandidateStatuses.CandidateStatus> candidateStatusesList = candidateStatuses.getCandidateStatus();
		for(CndtSt cndtSt: cndtStList){
			CandidateStatuses.CandidateStatus jaxbCndtSt = new CandidateStatuses.CandidateStatus();
			jaxbCndtSt.setCandidateStatusId(String.valueOf(cndtSt.getCndtStsId()));
			jaxbCndtSt.setCandidateStatusName(cndtSt.getCndtStsNm());
			candidateStatusesList.add(jaxbCndtSt);
		}
		return candidateStatuses;
	}
	
	private CitizenshipStatuses getCitizenshipStatus(List<CtznshpSt> ctznshpStList){
		CitizenshipStatuses citizenshipStatuses = new CitizenshipStatuses();
		List<CitizenshipStatuses.CitizenshipStatus> cititzenshipStatusesList = citizenshipStatuses.getCitizenshipStatus();
		for(CtznshpSt ctznshpSt: ctznshpStList){
			CitizenshipStatuses.CitizenshipStatus jaxbCtznshpSt = new CitizenshipStatuses.CitizenshipStatus();
			jaxbCtznshpSt.setCitizenshipStatusId(String.valueOf(ctznshpSt.getCtznShpId()));
			jaxbCtznshpSt.setCitizenshipStatusName(ctznshpSt.getCtznShpNm());
			cititzenshipStatusesList.add(jaxbCtznshpSt);
		}
		return citizenshipStatuses;
	}
	
	private EmployeeTypes getEmployeeType(List<EmplTyp> emplTypStList){
		EmployeeTypes employeeTypes = new EmployeeTypes();
		List<EmployeeTypes.EmployeeType> employeeTypesList = employeeTypes.getEmployeeType();
		for(EmplTyp emplTyp: emplTypStList){
			EmployeeTypes.EmployeeType jaxbEmplTyp = new EmployeeTypes.EmployeeType();
			jaxbEmplTyp.setEmployeeTypeId(String.valueOf(emplTyp.getEmptTypId()));
			jaxbEmplTyp.setEmployeeTypeName(emplTyp.getEmptTypNm());
			employeeTypesList.add(jaxbEmplTyp);
		}
		return employeeTypes;
	}
	
	private InterviewStatuses getIntervewStatus(List<IntrvwSt> intrvwStList){
		InterviewStatuses interviewStatuses = new InterviewStatuses();
		List<InterviewStatuses.InterviewStatus> employeeTypesList = interviewStatuses.getInterviewStatus();
		for(IntrvwSt intrvwSt: intrvwStList){
			InterviewStatuses.InterviewStatus jaxbIntrvwSt = new InterviewStatuses.InterviewStatus();
			jaxbIntrvwSt.setInterviewStatusId(String.valueOf(intrvwSt.getIntrvwStsId()));
			jaxbIntrvwSt.setInterviewStatusName(intrvwSt.getIntrvwStsNm());
			employeeTypesList.add(jaxbIntrvwSt);
		}
		return interviewStatuses;
	}
}
