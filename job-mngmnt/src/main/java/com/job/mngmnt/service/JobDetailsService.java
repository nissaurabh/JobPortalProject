package com.job.mngmnt.service;

import com.job.mmngmnt.jaxb.JobDetails;
import com.job.mngmnt.entities.Account;
import com.job.mngmnt.entities.EmplTyp;
import com.job.mngmnt.entities.JobRole;
import com.job.mngmnt.entities.JobSt;
import com.job.mngmnt.entities.JobStg;


public interface JobDetailsService {

	public void createJob(JobDetails jobDetails);
	
	public void updateJob(String jobId, JobDetails jobDetails);
	
	public void deleteJob(String jobId);

	public Account getAccount(int acctId);

	public EmplTyp getEmplTyp(int emptTypId);

	public JobRole getJobRole(int jobRlId);

	public JobSt getJobStatus(int jobStsId);

	public JobStg getJobStage(int jobStgId);

}
