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
@XmlRootElement(name = "interviewList")
@XmlType(propOrder = {"conductedCount","successCount","interviewList"})
public class InterviewDetails implements Serializable{
	
	private int conductedCount;
	
	private int successCount;
	
	private List<InterviewDetail> interviewList;

	public int getConductedCount() {
		return conductedCount;
	}

	public void setConductedCount(int conductedCount) {
		this.conductedCount = conductedCount;
	}

	public int getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(int successCount) {
		this.successCount = successCount;
	}

	public List<InterviewDetail> getInterviewList() {
		return interviewList;
	}

	public void setInterviewList(List<InterviewDetail> interviewList) {
		this.interviewList = interviewList;
	}
	
}
