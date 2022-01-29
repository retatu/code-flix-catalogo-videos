package com.codeflix.CFCatalogo.infrastructure.mysql;

import java.util.UUID;

import com.codeflix.CFCatalogo.domain.entity.Category;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface SpringDataCategoryRepository extends PagingAndSortingRepository<Category, UUID> {

}
