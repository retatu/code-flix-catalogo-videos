package com.codeflix.CFCatalogo.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.codeflix.CFCatalogo.domain.entity.BaseEntity;

public class Genre extends BaseEntity {

	private String name;
	private List<Category> categories = new ArrayList<>();

	public Genre() {
	}

	public Genre(UUID id) {
		this.setId(id);
	}

	public Genre(String name) {
		this.setName(name);
		super.generateUUID();
	}
	public Genre(UUID id, String name) {
		super.setId(id);
		this.setName(name);
	}
	public Genre(String name, List<Category> categories) {
		this.setName(name);
		super.generateUUID();
		this.setCategories(categories);
	}

	public Genre(UUID id, String name, List<Category> categories) {
		super.setId(id);
		this.setName(name);
		this.setCategories(categories);
	}

	public void setName(String name) {
		if (name == null) throw new IllegalArgumentException("name is marked as non-null but got null");
		if (name.isEmpty()) throw new IllegalArgumentException("name is marked as non-blank but got blank");
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
			throw new IllegalArgumentException("categories is marked as non-null but got null");
		this.categories = categories;
	}

	public void addCategory(Category category){
		if (category == null)
			throw new IllegalArgumentException("category is marked as non-null but got null");
		this.categories.add(category);
	}
	public void removeCategory(Category category){
		if (category == null)
			throw new IllegalArgumentException("category is marked as non-null but got null");
		this.categories.removeIf(c -> c.equals(category));
	}
}
