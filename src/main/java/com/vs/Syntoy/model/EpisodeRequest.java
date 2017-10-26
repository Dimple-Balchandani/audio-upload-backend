package com.vs.Syntoy.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vs.Syntoy.dbentities.EpisodeEntity;

public class EpisodeRequest extends EpisodeEntity{

	
	@Override
    @JsonIgnore
	public void setId(Long id) {
		super.setId(id);
	}
	
	@Override
	@JsonIgnore
	public void setUploadtime(Date uploadtime) {
		super.setUploadtime(uploadtime);
	}

	
	
}
