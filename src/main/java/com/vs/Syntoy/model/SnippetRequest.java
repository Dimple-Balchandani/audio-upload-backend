package com.vs.Syntoy.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


public class SnippetRequest {
	
	@JsonProperty
	private String snippetName;
	
	@JsonProperty
	private String snippetDesc;

	@JsonProperty
	private Long snippetStartHour;
	
	@JsonProperty
	private Long snippetStartMin;
	
	@JsonProperty
	private Long snippetStartSec;
	
	@JsonProperty
	private Long snippetEndHour;
	
	@JsonProperty
	private Long snippetEndMin;
	
	@JsonProperty
	private Long snippetEndSec;

	@JsonProperty
	private String snippetIdentifier;

	@JsonProperty
	private Long R_value;

	@JsonProperty
	private Long G_value;
	
	@JsonProperty
	private Long B_value;
	
	@JsonProperty
	private Boolean CFD;

	@JsonProperty
	private Long episodeId [];
	
	@JsonProperty
	private Long groupId [];
	
	@JsonProperty
	private Long quesId [];
	
	@JsonProperty
	private String syntlkers;
	
//	@JsonIgnore
//	private Long preSnippets [];
//	
//	@JsonIgnore
//	private Long postSnippets [];

	public String getSyntlkers() {
		return syntlkers;
	}

	public void setSyntlkers(String syntlkers) {
		this.syntlkers = syntlkers;
	}

	public Boolean getCFD() {
		return CFD;
	}

	@JsonIgnore
	public void setCFD(Boolean cFD) {
		CFD = cFD;
	}

	
	public Long[] getEpisodeId() {
		return episodeId;
	}

	public void setEpisodeId(Long[] episodeId) {
		this.episodeId = episodeId;
	}

	public Long[] getGroupId() {
		return groupId;
	}

	public void setGroupId(Long[] groupId) {
		this.groupId = groupId;
	}

	public Long[] getQuesId() {
		return quesId;
	}

	public void setQuesId(Long[] quesId) {
		this.quesId = quesId;
	}

	public String getSnippetName() {
		return snippetName;
	}

	public void setSnippetName(String snippetName) {
		this.snippetName = snippetName;
	}

	public String getSnippetDesc() {
		return snippetDesc;
	}

	public void setSnippetDesc(String snippetDesc) {
		this.snippetDesc = snippetDesc;
	}

	public Long getSnippetStartHour() {
		return snippetStartHour;
	}

	public void setSnippetStartHour(Long snippetStartHour) {
		this.snippetStartHour = snippetStartHour;
	}

	public Long getSnippetStartMin() {
		return snippetStartMin;
	}

	public void setSnippetStartMin(Long snippetStartMin) {
		this.snippetStartMin = snippetStartMin;
	}

	public Long getSnippetStartSec() {
		return snippetStartSec;
	}

	public void setSnippetStartSec(Long snippetStartSec) {
		this.snippetStartSec = snippetStartSec;
	}

	public Long getSnippetEndHour() {
		return snippetEndHour;
	}

	public void setSnippetEndHour(Long snippetEndHour) {
		this.snippetEndHour = snippetEndHour;
	}

	public Long getSnippetEndMin() {
		return snippetEndMin;
	}

	public void setSnippetEndMin(Long snippetEndMin) {
		this.snippetEndMin = snippetEndMin;
	}

	public Long getSnippetEndSec() {
		return snippetEndSec;
	}

	public void setSnippetEndSec(Long snippetEndSec) {
		this.snippetEndSec = snippetEndSec;
	}

	public String getSnippetIdentifier() {
		return snippetIdentifier;
	}

	public void setSnippetIdentifier(String snippetIdentifier) {
		this.snippetIdentifier = snippetIdentifier;
	}


	public Long getR_value() {
		return R_value;
	}

	@JsonIgnore
	public void setR_value(Long r_value) {
		R_value = r_value;
	}

	public Long getG_value() {
		return G_value;
	}

	@JsonIgnore
	public void setG_value(Long g_value) {
		G_value = g_value;
	}


	public Long getB_value() {
		return B_value;
	}

	@JsonIgnore
	public void setB_value(Long b_value) {
		B_value = b_value;
	}


//	public Long[] getPreSnippets() {
//		return preSnippets;
//	}
//
//	public void setPreSnippets(Long[] preSnippets) {
//		this.preSnippets = preSnippets;
//	}
//
//	public Long[] getPostSnippets() {
//		return postSnippets;
//	}
//
//	public void setPostSnippets(Long[] postSnippets) {
//		this.postSnippets = postSnippets;
//	}

	
}
