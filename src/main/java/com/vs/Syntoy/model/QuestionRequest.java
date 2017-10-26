package com.vs.Syntoy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vs.Syntoy.dbentities.QuestionEntity;

public class QuestionRequest extends QuestionEntity{
	
	@Override
    @JsonIgnore
	public void setId(Long id) {
		super.setId(id);
	}
}
