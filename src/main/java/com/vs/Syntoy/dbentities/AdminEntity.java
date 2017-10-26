package com.vs.Syntoy.dbentities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vs.Syntoy.model.AdminRequest;

@Entity
@Table(name="admin")
public class AdminEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="admin_id")
	private Long Id;
	
	@Column(name="admin_name")
	private String adminName;
	
	@Column(name="admin_username")
	private String adminUsername;
	
	@Column(name="admin_password")
	private String adminPassword;
	
	public AdminEntity(){}
	
	public AdminEntity(AdminRequest request){
		this.adminName = request.getAdminName();
		this.adminPassword = request.getAdminPassword();
		this.adminUsername = request.getAdminUsername();
	}
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	
}
