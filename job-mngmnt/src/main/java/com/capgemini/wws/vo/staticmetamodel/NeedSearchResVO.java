/**
 * 
 */
package com.capgemini.wws.vo.staticmetamodel;

import java.util.Date;

import com.capgemini.job.portal.entities.Billability;
import com.capgemini.job.portal.entities.Client;
import com.capgemini.job.portal.entities.Grade;
import com.capgemini.job.portal.entities.Location;
import com.capgemini.job.portal.entities.NeedCloseReason;
import com.capgemini.job.portal.entities.Practice;
import com.capgemini.job.portal.entities.SkillProfile;

/**
 * @author sryarlag
 *
 */
public class NeedSearchResVO {

	private Integer wwsId;
    private String needStatus;
    private Practice practice;
    private Location location;
    private Client client;
    private Grade grade;
    private Billability billability;
    private NeedCloseReason needCloseReason;
    private Date projectStartDate;
    private Date projectEndDate;
    private Date needCloseDate;
    private SkillProfile skillProfile;
    
    public NeedSearchResVO(Integer wwsId, String needStatus, Practice practice, Location location, Client client, Grade grade, Billability billability
    		,NeedCloseReason needCloseReason, Date projectStartDate, Date projectEndDate, Date needCloseDate, SkillProfile skillProfile) {
    	this.wwsId = wwsId;
    	this.needStatus = needStatus;
    	this.practice = practice;
    	this.location = location;
    	this.client = client;
    	this.grade = grade;
    	this.billability = billability;
    	this.needCloseReason = needCloseReason;
    	this.projectStartDate = projectStartDate;
    	this.projectEndDate = projectEndDate;
    	this.needCloseDate = needCloseDate;
    	this.skillProfile = skillProfile;
    }

	public Integer getWwsId() {
		return wwsId;
	}

	public void setWwsId(Integer wwsId) {
		this.wwsId = wwsId;
	}

	public String getNeedStatus() {
		return needStatus;
	}

	public void setNeedStatus(String needStatus) {
		this.needStatus = needStatus;
	}

	public Practice getPractice() {
		return practice;
	}

	public void setPractice(Practice practice) {
		this.practice = practice;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Billability getBillability() {
		return billability;
	}

	public void setBillability(Billability billability) {
		this.billability = billability;
	}

	public NeedCloseReason getNeedCloseReason() {
		return needCloseReason;
	}

	public void setNeedCloseReason(NeedCloseReason needCloseReason) {
		this.needCloseReason = needCloseReason;
	}

	public Date getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public Date getProjectEndDate() {
		return projectEndDate;
	}

	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	public Date getNeedCloseDate() {
		return needCloseDate;
	}

	public void setNeedCloseDate(Date needCloseDate) {
		this.needCloseDate = needCloseDate;
	}

	public SkillProfile getSkillProfile() {
		return skillProfile;
	}

	public void setSkillProfile(SkillProfile skillProfile) {
		this.skillProfile = skillProfile;
	}
    
	    
}
