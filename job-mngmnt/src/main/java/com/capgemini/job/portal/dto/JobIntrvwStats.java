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
    "clientName",
    "buName",
    "conducted",
    "success"
})
@XmlRootElement(name = "jobIntrvwStats")
public class JobIntrvwStats implements Serializable{
	
	private String clientName;
	
	private String buName;
	
	private int conducted;
	
	private int success;

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

	public int getConducted() {
		return conducted;
	}

	public void setConducted(int conducted) {
		this.conducted = conducted;
	}

	public int getSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}
	
}
