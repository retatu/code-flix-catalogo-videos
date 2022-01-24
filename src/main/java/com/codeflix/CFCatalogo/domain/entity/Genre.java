package com.codeflix.CFCatalogo.domain.entity;

import java.util.List;
import java.util.UUID;

import com.codeflix.CFCatalogo.domain.entity.BaseEntity;

public class Genre extends BaseEntity {

	private String name;
	private List<Category> categories;

	public Genre() {
	}

	public Genre(UUID id) {
		this.setId(id);
	}

	public Genre(String name) {
		this.name = name;
		super.generateUUID();
	}
	public Genre(UUID id, String name) {
		super.setId(id);
		this.name = name;
	}
	public Genre(String name, List<Category> categories) {
		this.name = name;
		super.generateUUID();
		this.categories = categories;
	}

	public Genre(UUID id, String name, List<Category> categories) {
		super.setId(id);
		this.name = name;
		this.categories = categories;
	}

	public void setName(String name) {
		if (name == null || name.isEmpty())
			throw new IllegalArgumentException("");
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		if (categories == null)
			throw new IllegalArgumentException("");
		this.categories = categories;
	}

	public void addCategory(Category category){
		if (category == null)
			throw new IllegalArgumentException("");
		this.categories.add(category);
	}
	public void removeCategory(Category category){
		if (category == null)
			throw new IllegalArgumentException("");
		this.categories.removeIf(c -> this.categories.contains(category));
	}
}
