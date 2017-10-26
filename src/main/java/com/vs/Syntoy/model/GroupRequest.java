package com.vs.Syntoy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vs.Syntoy.dbentities.GroupEntity;

public class GroupRequest extends GroupEntity{

	@Override
    @JsonIgnore
	public void setId(Long id) {
		super.setId(id);
	}
}
