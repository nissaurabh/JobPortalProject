/**
 * 
 */
package com.capgemini.job.portal.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * @author sryarlag
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "wwsId",
    "skillCategory",
    "skill",
    "roleName",
    "role",
    "existingSkillId",
    "existingRoleId",
    "defineNewSkill",
    "defineNewRole"
})

public class SkillProfileJAXB {
	
	private String wwsId;
	
	private String skillCategory;
	
	private String skill;
	
	private String roleName;
	
	private String role;
	
	private String existingSkillId;
	
	private String existingRoleId;
	
	private String defineNewSkill;
	
	private String defineNewRole;

	public String getWwsId() {
		return wwsId;
	}

	public void setWwsId(String wwsId) {
		this.wwsId = wwsId;
	}

	public String getSkillCategory() {
		return skillCategory;
	}

	public void setSkillCategory(String skillCategory) {
		this.skillCategory = skillCategory;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getExistingSkillId() {
		return existingSkillId;
	}

	public void setExistingSkillId(String existingSkillId) {
		this.existingSkillId = existingSkillId;
	}

	public String getExistingRoleId() {
		return existingRoleId;
	}

	public void setExistingRoleId(String existingRoleId) {
		this.existingRoleId = existingRoleId;
	}

	public String getDefineNewSkill() {
		return defineNewSkill;
	}

	public void setDefineNewSkill(String defineNewSkill) {
		this.defineNewSkill = defineNewSkill;
	}

	public String getDefineNewRole() {
		return defineNewRole;
	}

	public void setDefineNewRole(String defineNewRole) {
		this.defineNewRole = defineNewRole;
	}


}
