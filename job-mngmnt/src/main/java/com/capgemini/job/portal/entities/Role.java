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
@Table(name="wws_role")
public class Role implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="role_id")
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer roleId;
	
	@Column(name="role_name")
	private String roleName;
	
	@Column(name="role")
	private String role;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
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
	
}
