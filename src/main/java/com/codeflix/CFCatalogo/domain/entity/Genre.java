package com.codeflix.CFCatalogo.domain.entity;

import java.util.UUID;

import com.codeflix.CFCatalogo.domain.entity.BaseEntity;

public class Genre extends BaseEntity{

	private String name;

	public Genre(){}
	public Genre(UUID id){
		this.setId(id);
	}
	public Genre(String name){
		this.name = name;
		super.generateUUID();
	}
	public Genre(UUID id, String name){
		super.setId(id);
		this.name = name;
	}


	public void setName(String name) {
		if(name == null || name.isEmpty()) throw new IllegalArgumentException("");
		this.name = name;
	}

	public String getName() {
	  	return name;
	}
}
