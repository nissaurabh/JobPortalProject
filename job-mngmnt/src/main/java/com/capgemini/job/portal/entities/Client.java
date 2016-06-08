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
@Table(name="wws_client")
public class Client implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="client_id")
	private Integer clientId; 
	
	@Column(name="client_name")
	private String clientName;	
	
	@Column(name="moderated_name")
	private String moderatedName;

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getModeratedName() {
		return moderatedName;
	}

	public void setModeratedName(String moderatedName) {
		this.moderatedName = moderatedName;
	}
	
}
