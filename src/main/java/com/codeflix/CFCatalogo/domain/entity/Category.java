package com.codeflix.CFCatalogo.domain.entity;

import java.util.UUID;

import com.codeflix.CFCatalogo.domain.entity.BaseEntity;

public class Category extends BaseEntity{
	private String name;

	public Category() {
	}

	public Category(UUID id) {
		super.setId(id);
	}

	public Category(String name) {
		super.generateUUID();
		this.setName(name);
	}
	
	public Category(UUID id, String name) {
		super.setId(id);
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws IllegalArgumentException {
    if(name == null || name.isEmpty()) throw new IllegalArgumentException("");
    this.name = name;
  }
}
