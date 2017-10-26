package com.vs.Syntoy.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HistoryRequest {

	@JsonProperty
	private List<String> SnippetIds;

	public List<String> getSnippetIds() {
		return SnippetIds;
	}

	public void setSnippetIds(List<String> snippetIds) {
		SnippetIds = snippetIds;
	}
	

}
