package com.codeflix.CFCatalogo.infrastructure.mysql;

import com.codeflix.CFCatalogo.domain.entity.Category;
import com.codeflix.CFCatalogo.domain.repository.ICategoryRepository;

import org.springframework.stereotype.Repository;

@Repository
public class MySQLCategoryImplementation implements ICategoryRepository {

	private SpringDataCategoryRepository springDataCategoryRepository;

	public MySQLCategoryImplementation(SpringDataCategoryRepository springDataCategoryRepository){
		this.springDataCategoryRepository = springDataCategoryRepository;
	}

	@Override
	public Iterable<Category> findAllCategories() {
		return this.springDataCategoryRepository.findAll();
	}

}
