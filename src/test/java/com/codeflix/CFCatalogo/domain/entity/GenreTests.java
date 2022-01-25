package com.codeflix.CFCatalogo.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class GenreTests {
	@Test
	public void creatGenreWithNameTest(){
		final Genre entity = new Genre("Genre 1");
		assertNotNull(entity);
		assertEquals(entity.getName(), "Genre 1");
		assertTrue(entity.isValidUUID(entity.getId().toString()));
	}
	@Test
	public void creatGenreWithNameAndCategoriesTest(){
		final Category category1 = new Category("Category 1");
		final Category category2 = new Category("Category 2");
		List<Category> categories = new ArrayList<>();
		categories.add(category1);
		categories.add(category2);
		
		final Genre entity = new Genre("Genre 1", categories);
		assertNotNull(entity);
		assertEquals(entity.getName(), "Genre 1");
		assertTrue(entity.isValidUUID(entity.getId().toString()));
		assertTrue(entity.isValidUUID(entity.getId().toString()));
		assertEquals(2, entity.getCategories().size());
	}
	@Test
	public void throwIlligalArgumentExceptionWhenNameIsNull(){
		assertThrows(IllegalArgumentException.class, () -> new Genre((String) null));
	}
	@Test
	public void throwIlligalArgumentExceptionWhenNameAndCategoriesAreNull(){
		assertThrows(IllegalArgumentException.class, () -> new Genre((String) null, null));
	}
	@Test
	public void throwIlligalArgumentExceptionWhenIDIsNull(){
		assertThrows(IllegalArgumentException.class, () -> new Genre((UUID) null));
	}
	@Test
	public void throwIlligalArgumentExceptionWhenNameIsBlank(){
		assertThrows(IllegalArgumentException.class, () -> new Genre(""));
	}
	@Test
	public void throwIlligalArgumentExceptionWhenNameIsBlankAndCategoriesIsNull(){
		assertThrows(IllegalArgumentException.class, () -> new Genre("", null));
	}
	@Test
	public void addCategoryToGenre(){
		final Genre entity = new Genre("Genre 1");
		assertNotNull(entity);
		assertNotNull(entity.getCategories());
		final Category category1 = new Category("Category 1");
		final Category category2 = new Category("Category 2");

		entity.addCategory(category1);
		entity.addCategory(category2);
		
		assertEquals(2, entity.getCategories().size());
	}
	@Test
	public void removeCategoryToGenre(){
		final Genre entity = new Genre("Genre 1");
		assertNotNull(entity);
		final Category category1 = new Category("Category 1");
		final Category category2 = new Category("Category 2");

		entity.addCategory(category1);
		entity.addCategory(category2);

		assertEquals(2, entity.getCategories().size());
		entity.removeCategory(category1);
		assertEquals(1, entity.getCategories().size());
		entity.removeCategory(category2);
		assertEquals(0, entity.getCategories().size());
		
		assertNotNull(entity.getCategories());
	}
}
