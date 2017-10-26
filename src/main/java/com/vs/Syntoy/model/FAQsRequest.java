package com.vs.Syntoy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vs.Syntoy.dbentities.FAQsEntity;

public class FAQsRequest extends FAQsEntity{

	@Override
    @JsonIgnore
	public void setId(Long id) {
		super.setId(id);
	}
}
