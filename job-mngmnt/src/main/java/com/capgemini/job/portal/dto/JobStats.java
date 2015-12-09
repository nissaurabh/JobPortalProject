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
    "open",
    "aging"
})
@XmlRootElement(name = "jobStats")
public class JobStats implements Serializable{
	
	private String clientName;
	
	private String buName;
	
	private int open;
	
	private int aging;

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

	public int getOpen() {
		return open;
	}

	public void setOpen(int open) {
		this.open = open;
	}

	public int getAging() {
		return aging;
	}

	public void setAging(int aging) {
		this.aging = aging;
	}
	
}
