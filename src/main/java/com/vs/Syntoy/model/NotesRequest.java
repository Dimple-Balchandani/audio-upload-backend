package com.vs.Syntoy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NotesRequest {

	@JsonProperty
	private String NotesText;
	
	@JsonProperty
	private Long UserId;

	public String getNotesText() {
		return NotesText;
	}

	@JsonIgnore
	public void setNotesText(String notesText) {
		NotesText = notesText;
	}

	public Long getUserId() {
		return UserId;
	}

	@JsonIgnore
	public void setUserId(Long userId) {
		UserId = userId;
	}
	
	
}
