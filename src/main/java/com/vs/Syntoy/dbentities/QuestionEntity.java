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
import com.vs.Syntoy.model.QuestionRequest;

@Entity
@Table(name="question")
public class QuestionEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="question_id")
	private Long Id;
	
	@Column(name="question_text")
	private String questionText;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "question_snippet", joinColumns = {
	@JoinColumn(name = "questionId", nullable = false) },
		inverseJoinColumns = { @JoinColumn(name = "snippetId",
		nullable = false, updatable = false) })
	private Set<SnippetEntity> snippet = new HashSet<SnippetEntity>();
	
	public QuestionEntity(){}
	
	public QuestionEntity(QuestionRequest request){
		this.questionText = request.getQuestionText();
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public Set<SnippetEntity> getSnippet() {
		return snippet;
	}

	public void setSnippet(Set<SnippetEntity> snippet) {
		this.snippet = snippet;
	}

}
