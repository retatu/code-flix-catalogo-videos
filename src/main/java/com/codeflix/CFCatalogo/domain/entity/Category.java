package com.codeflix.CFCatalogo.domain.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;


@Entity
@Table(name = "categories")
@EqualsAndHashCode
public class Category extends BaseEntity{

  @Column
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
    if(name == null) throw new IllegalArgumentException("name is marked as non-null but got null");
    if(name.isEmpty()) throw new IllegalArgumentException("name is marked as non-blank but got blank");
    this.name = name;
  }
}
