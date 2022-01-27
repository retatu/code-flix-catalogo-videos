package com.codeflix.CFCatalogo.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class VideoTests {
	@Test
	public void throwIlligalArgumentExceptionWhenTitleIsNullTest() {
		assertThrows(IllegalArgumentException.class, () -> new Video(null, "", 123, false));
	}
	@Test
	public void throwIlligalArgumentExceptionWhenTitleIsBlankTest() {
		assertThrows(IllegalArgumentException.class, () -> new Video("", "", 123, false));
	}
	@Test
	public void throwIlligalArgumentExceptionWhenYearLaunchedIsNullTest() {
		assertThrows(IllegalArgumentException.class, () -> new Video("Video 1", "", null, false));
	}
	@Test
	public void throwIlligalArgumentExceptionWhenYearLaunchedIsZeroTest() {
		assertThrows(IllegalArgumentException.class, () -> new Video("Video 1", "", 0, false));
	}
	@Test
	public void throwIlligalArgumentExceptionWhenTitleIsGreaterThanTodayTest() {
		assertThrows(IllegalArgumentException.class, () -> new Video("Video 1", "", 2026, false));
	}

	@Test
	public void creatVideoWithTitleAndYearLaunchedTest(){
		int a = 123;
		final Video entity = new Video("Video 1", "Description", a, false);
		assertNotNull(entity);
		assertEquals(entity.getTitle(), "Video 1");
		assertTrue(entity.isValidUUID(entity.getId().toString()));
	}

	@Test
	public void creatVideoWithTitleAndYearLaunchedAndRatingAndDurationTest(){
		final Video entity = new Video("Video 1", "Description", 2020, false, "Rating 10", (Float) 10.2f);
		assertNotNull(entity);
		assertEquals(entity.getTitle(), "Video 1");
		assertTrue(entity.isValidUUID(entity.getId().toString()));
		assertFalse(entity.isOpened());
	}

	@Test
	public void creatVideoWithoutFiles(){
    final Category category1 = new Category("Category 1");
		final Category category2 = new Category("Category 2");
		List<Category> categories = new ArrayList<>();
    categories.add(category1);
    categories.add(category2);
    
    final Genre genre1 = new Genre("Genre 1");
		final Genre genre2 = new Genre("Genre 2");
		List<Genre> genres = new ArrayList<>();
    genres.add(genre1);
    genres.add(genre2);
    
    final CastMember castMember1 = new CastMember("CastMember 1");
		final CastMember castMember2 = new CastMember("CastMember 2");
		List<CastMember> castMembers = new ArrayList<>();
    castMembers.add(castMember1);
    castMembers.add(castMember2);

		final Video entity = new Video("Title", "Description", 2020, 15.4F, categories, genres, castMembers) ;
		
    assertNotNull(entity);
		assertTrue(entity.isValidUUID(entity.getId().toString()));
    assertNotNull(entity.getCategories());
    assertNotNull(entity.getGenres());
    assertNotNull(entity.getCastMembers());
		assertEquals(2, entity.getCategories().size());
		assertEquals(2, entity.getGenres().size());
		assertEquals(2, entity.getCastMembers().size());
	}
  
  @Test
  public void creatVideoWithAddRemoveCategories(){
    final Category category1 = new Category("Category 1");
		assertTrue(category1.isValidUUID(category1.getId().toString()));
		final Category category2 = new Category("Category 2");
		assertTrue(category2.isValidUUID(category2.getId().toString()));

		final Video entity = new Video("Title", "Description", 2020, 15.4F);

    entity.addCategory(category1);
		assertEquals(1, entity.getCategories().size());
    entity.addCategory(category2);
		assertEquals(2, entity.getCategories().size());
	
    entity.removeCategory(category1);
		assertEquals(1, entity.getCategories().size());
    entity.removeCategory(category2);
		assertEquals(0, entity.getCategories().size());
	}
  
  @Test
  public void creatVideoWithAddRemoveGenre(){
    final Genre genre1 = new Genre("Genre 1");
		assertTrue(genre1.isValidUUID(genre1.getId().toString()));
		final Genre genre2 = new Genre("Genre 2");
		assertTrue(genre2.isValidUUID(genre2.getId().toString()));

		final Video entity = new Video("Title", "Description", 2020, 15.4F);

    entity.addGenre(genre1);
		assertEquals(1, entity.getGenres().size());
    entity.addGenre(genre2);
		assertEquals(2, entity.getGenres().size());
    
    entity.removeGenre(genre1);
		assertEquals(1, entity.getGenres().size());
    entity.removeGenre(genre2);
		assertEquals(0, entity.getGenres().size());
	}
  
  @Test
  public void creatVideoWithAddRemoveCastMember(){
    final CastMember castMember1 = new CastMember("CastMember 1");
		assertTrue(castMember1.isValidUUID(castMember1.getId().toString()));
		final CastMember castMember2 = new CastMember("CastMember 2");
		assertTrue(castMember2.isValidUUID(castMember2.getId().toString()));

		final Video entity = new Video("Title", "Description", 2020, 15.4F);

    entity.addCastMember(castMember1);
		assertEquals(1, entity.getCastMembers().size());
    entity.addCastMember(castMember2);
		assertEquals(2, entity.getCastMembers().size());
	
    entity.removeCastMember(castMember1);
		assertEquals(1, entity.getCastMembers().size());
    entity.removeCastMember(castMember2);
		assertEquals(0, entity.getCastMembers().size());
	}

}
