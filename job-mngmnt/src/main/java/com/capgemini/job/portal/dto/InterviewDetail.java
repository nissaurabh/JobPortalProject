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
    "interviewerName",
    "interviewerPos",
    "status",
    "intrvwComments",
    "intrvwDateTime"
})
@XmlRootElement(name = "interview")
public class InterviewDetail implements Serializable{
	
	private String interviewerName;
	
	private String interviewerPos;
	
	private String status;
	
	private String intrvwComments;
	
	private String intrvwDateTime;

	public String getInterviewerName() {
		return interviewerName;
	}

	public void setInterviewerName(String interviewerName) {
		this.interviewerName = interviewerName;
	}

	public String getInterviewerPos() {
		return interviewerPos;
	}

	public void setInterviewerPos(String interviewerPos) {
		this.interviewerPos = interviewerPos;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIntrvwComments() {
		return intrvwComments;
	}

	public void setIntrvwComments(String intrvwComments) {
		this.intrvwComments = intrvwComments;
	}

	public String getIntrvwDateTime() {
		return intrvwDateTime;
	}

	public void setIntrvwDateTime(String intrvwDateTime) {
		this.intrvwDateTime = intrvwDateTime;
	}
	
	
}
