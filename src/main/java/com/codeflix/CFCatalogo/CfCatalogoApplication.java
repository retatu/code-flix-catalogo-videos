package com.codeflix.CFCatalogo;

import com.codeflix.CFCatalogo.domain.repository.ICategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CfCatalogoApplication {

	@Autowired
	ICategoryRepository iCategoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(CfCatalogoApplication.class, args);
	}

}
