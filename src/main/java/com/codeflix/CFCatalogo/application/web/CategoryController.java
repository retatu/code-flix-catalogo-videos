package com.codeflix.CFCatalogo.application.web;

import com.codeflix.CFCatalogo.application.dto.CategoryDto;
import com.codeflix.CFCatalogo.application.service.ICategoryService;
import com.codeflix.CFCatalogo.domain.entity.Category;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity findAll() {
        try {
            return ResponseEntity.ok().body(this.categoryService.findAll());
        } catch (Exception ex) {

        }
        return null;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody CategoryDto categoryDto) {
        try {
            Category category = this.categoryService.create(categoryDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(category);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }
}
