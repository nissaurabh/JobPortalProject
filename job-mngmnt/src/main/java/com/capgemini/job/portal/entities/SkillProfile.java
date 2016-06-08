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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author sryarlag
 *
 */

@Entity
@Table(name="wws_skill_profile")
public class SkillProfile implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="wws_skill_profile_id")
	private Integer skillProfileId; 
	
	@OneToOne
	@JoinColumn(name="role_id")
	private Role role;
	
	/*@OneToMany(mappedBy="skillId")
	private List<Skill> skills;*/
	
	@OneToOne
	@JoinColumn(name="skill_id")
	private Skill skill;
	
	@Column(name="taleo_id")
	private String taleoId;

	public Integer getSkillProfileId() {
		return skillProfileId;
	}

	public void setSkillProfileId(Integer skillProfileId) {
		this.skillProfileId = skillProfileId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public String getTaleoId() {
		return taleoId;
	}

	public void setTaleoId(String taleoId) {
		this.taleoId = taleoId;
	}

}