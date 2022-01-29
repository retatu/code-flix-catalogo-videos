package com.codeflix.CFCatalogo.application.service;

import java.util.Optional;
import java.util.UUID;

import com.codeflix.CFCatalogo.application.dto.CategoryDto;
import com.codeflix.CFCatalogo.domain.entity.Category;

public interface ICategoryService {
    Iterable<Category> findAll();
    Optional<Category> findById(UUID id);
    Category create(CategoryDto category);
}
