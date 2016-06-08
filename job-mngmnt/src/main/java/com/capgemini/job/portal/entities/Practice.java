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
@Table(name="wws_practice")
public class Practice implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="practice_id")
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer practiceId; 
	
	@Column(name="practice_name")
	private String practiceName;

	public Integer getPracticeId() {
		return practiceId;
	}

	public void setPracticeId(Integer practiceId) {
		this.practiceId = practiceId;
	}

	public String getPracticeName() {
		return practiceName;
	}

	public void setPracticeName(String practiceName) {
		this.practiceName = practiceName;
	}
	
	
}
