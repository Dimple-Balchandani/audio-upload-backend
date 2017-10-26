package com.vs.Syntoy.dbentities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vs.Syntoy.model.FAQsRequest;

@Entity
@Table(name="FAQs")
public class FAQsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="FAQ_id")
	private Long Id;
	
	@Column(name="FAQ_Question")
	private String FAQQuestion;
	
	@Column(name="FAQ_Answer")
	private String FAQAnswer;
	
	public FAQsEntity(){}
	
	public FAQsEntity(FAQsRequest request){
		this.FAQQuestion = request.getFAQQuestion();
		this.FAQAnswer = request.getFAQAnswer();
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getFAQQuestion() {
		return FAQQuestion;
	}

	public void setFAQQuestion(String fAQQuestion) {
		FAQQuestion = fAQQuestion;
	}

	public String getFAQAnswer() {
		return FAQAnswer;
	}

	public void setFAQAnswer(String fAQAnswer) {
		FAQAnswer = fAQAnswer;
	}
	
	
}
