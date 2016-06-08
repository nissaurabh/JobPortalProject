/**
 * 
 */
package com.capgemini.job.portal.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author sryarlag
 *
 */

@Entity
@Table(name="wws_closed_needs")
public class ClosedNeed implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="wws_id")
	private Integer wwsId; //Id
	
	@Column(name="closing_reason")
	private String closingReason;//Closing Reason
	
	@Column(name="closing_reason_details")
	private String closingReasonDetails;//Detail Closing Reason
	
	@Column(name="closing_reason_comment")
	private String closingReasonComment;//Comment Closing Reason
	
	@Column(name="closing_reason_comment_details")
	private String closingReasonCommentDtls;//Detail Comment Closing Reason
	
	@Column(name="close_date")
	private Date closeDate; //Close Date
	
	@Column(name="skill_comment")
	private String skillComment;//Skill Comment

	@Column(name="need_reason")
	private String needReason;//Need Reason

	public Integer getWwsId() {
		return wwsId;
	}

	public void setWwsId(Integer wwsId) {
		this.wwsId = wwsId;
	}

	public String getClosingReason() {
		return closingReason;
	}

	public void setClosingReason(String closingReason) {
		this.closingReason = closingReason;
	}

	public String getClosingReasonDetails() {
		return closingReasonDetails;
	}

	public void setClosingReasonDetails(String closingReasonDetails) {
		this.closingReasonDetails = closingReasonDetails;
	}

	public String getClosingReasonComment() {
		return closingReasonComment;
	}

	public void setClosingReasonComment(String closingReasonComment) {
		this.closingReasonComment = closingReasonComment;
	}

	public String getClosingReasonCommentDtls() {
		return closingReasonCommentDtls;
	}

	public void setClosingReasonCommentDtls(String closingReasonCommentDtls) {
		this.closingReasonCommentDtls = closingReasonCommentDtls;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public String getSkillComment() {
		return skillComment;
	}

	public void setSkillComment(String skillComment) {
		this.skillComment = skillComment;
	}

	public String getNeedReason() {
		return needReason;
	}

	public void setNeedReason(String needReason) {
		this.needReason = needReason;
	}

	
}
