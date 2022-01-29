package com.codeflix.CFCatalogo.domain.repository;

import com.codeflix.CFCatalogo.domain.entity.Category;

public interface ICategoryRepository {
	Iterable<Category> findAllCategories();
    Category create (Category category);
}
