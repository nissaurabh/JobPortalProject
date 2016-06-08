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
import javax.persistence.Table;

/**
 * @author sryarlag
 *
 */

@Entity
@Table(name="wws_billability")
public class Billability implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="billability_id")
	private Integer billabilityId; 
	
	@Column(name="billability_ds")
	private String billabilityDesc;

	public Integer getBillabilityId() {
		return billabilityId;
	}

	public void setBillabilityId(Integer billabilityId) {
		this.billabilityId = billabilityId;
	}

	public String getBillabilityDesc() {
		return billabilityDesc;
	}

	public void setBillabilityDesc(String billabilityDesc) {
		this.billabilityDesc = billabilityDesc;
	}
	
	
}
