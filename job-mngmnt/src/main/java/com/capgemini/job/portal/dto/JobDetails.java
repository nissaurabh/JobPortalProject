/**
 * 
 */
package com.capgemini.job.portal.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author ppenamak
 *
 */
@SuppressWarnings("serial")
@XmlRootElement(name = "jobList")
@XmlType(propOrder = {"openJobCount","agingJobCount","totalJobCount","jobList","jobAccount","jobBU"})
public class JobDetails implements Serializable{
	
	private int openJobCount;
	
	private int agingJobCount;
	
	private int totalJobCount;
	
	private List<JobDetail> jobList;
	
	private List<JobStats> jobAccount;
	
	private List<JobStats> jobBU;

	public List<JobDetail> getJobList() {
		return jobList;
	}

	public void setJobList(List<JobDetail> jobList) {
		this.jobList = jobList;
	}

	public int getOpenJobCount() {
		return openJobCount;
	}

	public void setOpenJobCount(int openJobCount) {
		this.openJobCount = openJobCount;
	}

	public int getAgingJobCount() {
		return agingJobCount;
	}

	public void setAgingJobCount(int agingJobCount) {
		this.agingJobCount = agingJobCount;
	}

	public int getTotalJobCount() {
		return totalJobCount;
	}

	public void setTotalJobCount(int totalJobCount) {
		this.totalJobCount = totalJobCount;
	}

	public List<JobStats> getJobAccount() {
		return jobAccount;
	}

	public void setJobAccount(List<JobStats> jobAccount) {
		this.jobAccount = jobAccount;
	}

	public List<JobStats> getJobBU() {
		return jobBU;
	}

	public void setJobBU(List<JobStats> jobBU) {
		this.jobBU = jobBU;
	}
	
}
