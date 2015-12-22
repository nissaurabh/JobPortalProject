/**
 * 
 */
package com.capgemini.job.portal.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author ppenamak
 *
 */
@SuppressWarnings("serial")
@XmlType(propOrder = {
    "cndtName",
    "cndtResume",
    "resourceType",
    "cntrctrRate",
    "cndtStatus",
    "ctznStatus",
    "roleName",
    "cndtId",
    "clientName",
    "buName",
    "primarySkills",
    "jobId"
})
@XmlRootElement(name = "candidateDtl")
public class CandidateDetail implements Serializable{
	
	private String cndtName;
	
	private String cndtResume;
	
	private String resourceType;
	
	private String cntrctrRate;
	
	private String cndtStatus;
	
	private String ctznStatus;
	
	private String roleName;
	
	private int cndtId;
	
	private String clientName;
	
	private String buName;
	
	private String primarySkills;
	
	private int jobId;

	public String getCndtName() {
		return cndtName;
	}

	public void setCndtName(String cndtName) {
		this.cndtName = cndtName;
	}

	public String getCndtResume() {
		return cndtResume;
	}

	public void setCndtResume(String cndtResume) {
		this.cndtResume = cndtResume;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getCntrctrRate() {
		return cntrctrRate;
	}

	public void setCntrctrRate(String cntrctrRate) {
		this.cntrctrRate = cntrctrRate;
	}

	public String getCndtStatus() {
		return cndtStatus;
	}

	public void setCndtStatus(String cndtStatus) {
		this.cndtStatus = cndtStatus;
	}

	public String getCtznStatus() {
		return ctznStatus;
	}

	public void setCtznStatus(String ctznStatus) {
		this.ctznStatus = ctznStatus;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getCndtId() {
		return cndtId;
	}

	public void setCndtId(int cndtId) {
		this.cndtId = cndtId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getBuName() {
		return buName;
	}

	public void setBuName(String buName) {
		this.buName = buName;
	}

	public String getPrimarySkills() {
		return primarySkills;
	}

	public void setPrimarySkills(String primarySkills) {
		this.primarySkills = primarySkills;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
}
