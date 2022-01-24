package com.codeflix.CFCatalogo;

import org.springframework.boot.SpringApplication;

import com.codeflix.CFCatalogo.domain.entity.Category;
import com.codeflix.CFCatalogo.domain.entity.Genre;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CfCatalogoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CfCatalogoApplication.class, args);
	}

  @Override
  public void run (String... args) throws Exception{
    Genre genre = new Genre("Genre 1");
    Category category = new Category("Category 1");
    genre.addCategory(category);
    System.out.println(genre.getName() + " - " + genre.getId());
    System.out.println(genre.getCategories());
  }

}
