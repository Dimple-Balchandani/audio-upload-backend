package com.vs.Syntoy.dbentities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vs.Syntoy.model.UserRequest;

@Entity
@Table(name="user")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long Id;
	
	@Column(name="user_Firstname")
	private String userFirstname;
	
	@Column(name="user_Lastname")
	private String userLastname;
	
	@Column(name="user_email")
	private String userEmail;
	
	@Column(name="user_password")
	private String userPassword;
	
	@Column(name="user_avatar_url")
	private String avatarUrl;
	
	@Column
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	private Set<NotesEntity> notes= new HashSet<NotesEntity>();

	@Column
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	private Set<HistoryEntity> history= new HashSet<HistoryEntity>();

	public UserEntity(){}
	
	public UserEntity(UserRequest request){
		this.userFirstname = request.getUserFirstname();
		this.userLastname = request.getUserLastname();
		this.userEmail = request.getUserEmail();
		this.avatarUrl = request.getAvatarUrl();
		this.userPassword = request.getUserPassword();
	}

	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getUserFirstname() {
		return userFirstname;
	}


	public void setUserFirstname(String userFirstname) {
		this.userFirstname = userFirstname;
	}


	public String getUserLastname() {
		return userLastname;
	}


	public void setUserLastname(String userLastname) {
		this.userLastname = userLastname;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public String getAvatarUrl() {
		return avatarUrl;
	}


	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}


	public Set<NotesEntity> getNotes() {
		return notes;
	}


	public void setNotes(Set<NotesEntity> notes) {
		this.notes = notes;
	}


	public Set<HistoryEntity> getHistory() {
		return history;
	}


	public void setHistory(Set<HistoryEntity> history) {
		this.history = history;
	}
	
	
}	
	
