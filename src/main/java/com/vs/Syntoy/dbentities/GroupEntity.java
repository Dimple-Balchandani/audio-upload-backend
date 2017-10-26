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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vs.Syntoy.model.GroupRequest;

@Entity
@Table(name="groups")
public class GroupEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="group_id")
	private Long Id;
	
	@Column(name="group_identifier")
	private String groupIdentifier;
	
	@Column(name="group_nickname")
	private String groupNickname;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "group_snippet", joinColumns = {
			@JoinColumn(name = "groupid", nullable = false) },
	inverseJoinColumns = { @JoinColumn(name = "snippetId",
					nullable = false, updatable = false) })
	private Set<SnippetEntity> snippet = new HashSet<SnippetEntity>();

	public GroupEntity(){}
	
	public GroupEntity(GroupRequest request){
		this.groupIdentifier = request.getGroupIdentifier();
		this.groupNickname = request.getGroupNickname();
	}
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getGroupIdentifier() {
		return groupIdentifier;
	}

	public void setGroupIdentifier(String groupIdentifier) {
		this.groupIdentifier = groupIdentifier;
	}

	public String getGroupNickname() {
		return groupNickname;
	}

	public void setGroupNickname(String groupNickname) {
		this.groupNickname = groupNickname;
	}

	public Set<SnippetEntity> getSnippet() {
		return snippet;
	}

	public void setSnippet(Set<SnippetEntity> snippet) {
		this.snippet = snippet;
	}
	
	
}


