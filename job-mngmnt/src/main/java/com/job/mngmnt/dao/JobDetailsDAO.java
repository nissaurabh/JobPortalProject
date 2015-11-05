package com.job.mngmnt.dao;

import com.job.mngmnt.entities.Account;
import com.job.mngmnt.entities.EmplTyp;
import com.job.mngmnt.entities.Job;
import com.job.mngmnt.entities.JobRole;
import com.job.mngmnt.entities.JobSt;
import com.job.mngmnt.entities.JobStg;

public interface JobDetailsDAO {
	
	public void createJob(Job job);
	
	public void updateJob(Job job);
	
	public void deleteJob(Job job);
	
	public Account getAccount(int acctId);
	
	public EmplTyp getEmplTyp(int emptTypId);
	
	public JobRole getJobRole(int jobRlId);
	
	public JobSt getJobStatus(int jobStsId);
	
	public JobStg getJobStage(int jobStgId);
	
	public Job getJob(String jobId);

}
