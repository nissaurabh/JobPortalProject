/**
 * 
 */
package com.capgemini.job.portal.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author sryarlag
 *
 */

@Entity
@Table(name="wws_need_close_reasons")
public class NeedCloseReason implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="close_reason_id")
	private Integer closeReasonId;
	
	@Column(name="close_reason")
	private String closeReason;
	
	@Column(name="close_reason_dtls")
	private String closeReasonDetails;

	public Integer getCloseReasonId() {
		return closeReasonId;
	}

	public void setCloseReasonId(Integer closeReasonId) {
		this.closeReasonId = closeReasonId;
	}

	public String getCloseReason() {
		return closeReason;
	}

	public void setCloseReason(String closeReason) {
		this.closeReason = closeReason;
	}

	public String getCloseReasonDetails() {
		return closeReasonDetails;
	}

	public void setCloseReasonDetails(String closeReasonDetails) {
		this.closeReasonDetails = closeReasonDetails;
	}
	
}
