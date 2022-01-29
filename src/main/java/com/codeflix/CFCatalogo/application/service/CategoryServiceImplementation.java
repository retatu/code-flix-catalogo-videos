package com.codeflix.CFCatalogo.application.service;

import java.util.Optional;
import java.util.UUID;

import com.codeflix.CFCatalogo.application.dto.CategoryDto;
import com.codeflix.CFCatalogo.domain.entity.Category;
import com.codeflix.CFCatalogo.domain.repository.ICategoryRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CategoryServiceImplementation implements ICategoryService {

    private ICategoryRepository categoryRepository;

    public CategoryServiceImplementation(ICategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Iterable<Category> findAll() {
        return this.categoryRepository.findAllCategories();
    }

    @Override
    public Optional<Category> findById(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Category create(CategoryDto category) {
        return this.categoryRepository.create(category.toEntity());
    }
    
}
