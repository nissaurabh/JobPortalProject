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
@XmlRootElement(name = "candidateList")
@XmlType(propOrder = {"activeCount","hiredCount","rejectCount","candidateList"})
public class CandidateDetails implements Serializable{
	
	private int activeCount;
	
	private int hiredCount;
	
	private int rejectCount;
	
	private List<CandidateDetail> candidateList;

	public int getActiveCount() {
		return activeCount;
	}

	public void setActiveCount(int activeCount) {
		this.activeCount = activeCount;
	}

	public int getHiredCount() {
		return hiredCount;
	}

	public void setHiredCount(int hiredCount) {
		this.hiredCount = hiredCount;
	}

	public int getRejectCount() {
		return rejectCount;
	}

	public void setRejectCount(int rejectCount) {
		this.rejectCount = rejectCount;
	}

	public List<CandidateDetail> getCandidateList() {
		return candidateList;
	}

	public void setCandidateList(List<CandidateDetail> candidateList) {
		this.candidateList = candidateList;
	}
	
}
