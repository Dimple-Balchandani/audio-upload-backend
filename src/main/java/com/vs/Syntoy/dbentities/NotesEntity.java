package com.vs.Syntoy.dbentities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vs.Syntoy.model.NotesRequest;

@Entity
@Table(name="notes")
public class NotesEntity {
	
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="notes_id")
	private Long Id;
	
	@Column(name="notes_text")
	private String notesText;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable=false)
	private UserEntity user;
	
	public NotesEntity(){}
	
	public NotesEntity(NotesRequest entity){
		this.notesText = entity.getNotesText();
	}
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNotesText() {
		return notesText;
	}

	public void setNotesText(String notesText) {
		this.notesText = notesText;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	
}
