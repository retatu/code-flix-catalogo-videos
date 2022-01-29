package com.codeflix.CFCatalogo.application.service;

import java.util.Optional;
import java.util.UUID;

import com.codeflix.CFCatalogo.domain.entity.Category;
import com.codeflix.CFCatalogo.domain.repository.ICategoryRepository;

import org.springframework.stereotype.Service;

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
    
}
