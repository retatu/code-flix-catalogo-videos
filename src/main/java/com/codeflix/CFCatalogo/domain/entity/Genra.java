package com.codeflix.CFCatalogo.domain.entity;

import java.util.UUID;

import com.codeflix.CFCatalogo.domain.entity.BaseEntity;

public class Genra extends BaseEntity{

	private String name;

	public Genra(){}
	public Genra(UUID id){
		this.setId(id);
	}
	public Genra(String name){
		this.name = name;
		super.generateUUID();
	}
	public Genra(UUID id, String name){
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
