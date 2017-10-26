package com.vs.Syntoy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vs.Syntoy.dbentities.AdminEntity;

public class AdminRequest extends AdminEntity{

	@Override
    @JsonIgnore
	public void setId(Long id) {
		super.setId(id);
	}
}
