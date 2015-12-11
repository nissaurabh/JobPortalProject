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
    "active",
    "hired",
    "rejected"
})
@XmlRootElement(name = "jobCndtStats")
public class JobCndtStats implements Serializable{
	
	private String clientName;
	
	private String buName;
	
	private int active;
	
	private int hired;
	
	private int rejected;

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

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getHired() {
		return hired;
	}

	public void setHired(int hired) {
		this.hired = hired;
	}

	public int getRejected() {
		return rejected;
	}

	public void setRejected(int rejected) {
		this.rejected = rejected;
	}
	
}
