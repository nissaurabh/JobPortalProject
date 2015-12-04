/**
 * 
 */
package com.capgemini.job.portal.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author ppenamak
 *
 */
@SuppressWarnings("serial")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "wwsid",
    "clnt_nm",
    "srvc_ln_nm",
    "srvc_ln_cap_nm",
    "job_rl_nm",
    "job_sts_nm",
    "reqstr_rm",
    "req_dt"
})
@XmlRootElement
public class JobDetail implements Serializable{
	
	private String wwsid;
	
	private String clnt_nm;
	
	private String srvc_ln_nm;
	
	private String srvc_ln_cap_nm;
	
	private String job_rl_nm;
	
	private String job_sts_nm;
	
	private String reqstr_rm;
	
	private Timestamp req_dt;

	public String getWwsid() {
		return wwsid;
	}

	public void setWwsid(String wwsid) {
		this.wwsid = wwsid;
	}

	public String getClnt_nm() {
		return clnt_nm;
	}

	public void setClnt_nm(String clnt_nm) {
		this.clnt_nm = clnt_nm;
	}

	public String getSrvc_ln_nm() {
		return srvc_ln_nm;
	}

	public void setSrvc_ln_nm(String srvc_ln_nm) {
		this.srvc_ln_nm = srvc_ln_nm;
	}

	public String getSrvc_ln_cap_nm() {
		return srvc_ln_cap_nm;
	}

	public void setSrvc_ln_cap_nm(String srvc_ln_cap_nm) {
		this.srvc_ln_cap_nm = srvc_ln_cap_nm;
	}

	public String getJob_rl_nm() {
		return job_rl_nm;
	}

	public void setJob_rl_nm(String job_rl_nm) {
		this.job_rl_nm = job_rl_nm;
	}

	public String getJob_sts_nm() {
		return job_sts_nm;
	}

	public void setJob_sts_nm(String job_sts_nm) {
		this.job_sts_nm = job_sts_nm;
	}

	public String getReqstr_rm() {
		return reqstr_rm;
	}

	public void setReqstr_rm(String reqstr_rm) {
		this.reqstr_rm = reqstr_rm;
	}

	public Timestamp getReq_dt() {
		return req_dt;
	}

	public void setReq_dt(Timestamp req_dt) {
		this.req_dt = req_dt;
	}
	
	

}
