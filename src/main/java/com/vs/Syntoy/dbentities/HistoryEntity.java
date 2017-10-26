package com.vs.Syntoy.dbentities;

import java.util.Date;

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
import com.vs.Syntoy.model.HistoryRequest;

@Entity
@Table(name="history")
public class HistoryEntity {
	
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="history_id")
	private Long Id;
	
	@Column(name="creation_time")
	private Date creationTime;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable=false)
	private UserEntity user;
	
	@Column(name="snippet_ids")
	private String SnippetIds;
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public String getSnippetIds() {
		return SnippetIds;
	}

	public void setSnippetIds(String snippetIds) {
		SnippetIds = snippetIds;
	}
	

}
