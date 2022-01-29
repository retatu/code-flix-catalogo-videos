package com.codeflix.CFCatalogo.application.web;

import com.codeflix.CFCatalogo.application.service.ICategoryService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
