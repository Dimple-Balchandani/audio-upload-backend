package com.vs.Syntoy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vs.Syntoy.dbentities.UserEntity;

public class UserRequest extends UserEntity{

	@Override
    @JsonIgnore
	public void setId(Long id) {
		super.setId(id);
	}
}
