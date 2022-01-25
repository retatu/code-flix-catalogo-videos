package com.codeflix.CFCatalogo.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CategoryTests {
	@Test
	public void createCategory(){
		final Category entity = new Category("Category 1");
		assertNotNull(entity);
		assertEquals(entity.getName(), "Category 1");
		assertTrue(entity.isValidUUID(entity.getId().toString()));
	}
	@Test
	public void throwIlligalArgumentExceptionWhenNameIsNull(){
		assertThrows(IllegalArgumentException.class, () -> new Category((String) null));
	}
	@Test
	public void throwIlligalArgumentExceptionWhenIDIsNull(){
		assertThrows(IllegalArgumentException.class, () -> new Category((UUID) null));
	}
	@Test
	public void throwIlligalArgumentExceptionWhenNameIsBlank(){
		assertThrows(IllegalArgumentException.class, () -> new Category(""));
	}
}
