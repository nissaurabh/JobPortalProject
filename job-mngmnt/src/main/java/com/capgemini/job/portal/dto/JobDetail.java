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
    "wwsid",
    "clientName",
    "serviceLine",
    "serviceLineCap",
    "roleName",
    "jobStatus",
    "reqBy",
    "reqDate",
    "jobId"
})
@XmlRootElement(name = "job")
public class JobDetail implements Serializable{
	
	private String wwsid;
	
	private String clientName;
	
	private String serviceLine;
	
	private String serviceLineCap;
	
	private String roleName;
	
	private String jobStatus;
	
	private String reqBy;
	
	private String reqDate;
	
	private int jobId;

	public String getWwsid() {
		return wwsid;
	}

	public void setWwsid(String wwsid) {
		this.wwsid = wwsid;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getServiceLine() {
		return serviceLine;
	}

	public void setServiceLine(String serviceLine) {
		this.serviceLine = serviceLine;
	}

	public String getServiceLineCap() {
		return serviceLineCap;
	}

	public void setServiceLineCap(String serviceLineCap) {
		this.serviceLineCap = serviceLineCap;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}

	public String getReqBy() {
		return reqBy;
	}

	public void setReqBy(String reqBy) {
		this.reqBy = reqBy;
	}

	public String getReqDate() {
		return reqDate;
	}

	public void setReqDate(String reqDate) {
		this.reqDate = reqDate;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	
}
