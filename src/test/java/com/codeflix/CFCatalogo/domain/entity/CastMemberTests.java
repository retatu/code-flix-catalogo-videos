package com.codeflix.CFCatalogo.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CastMemberTests {
	@Test
	public void createCastMemberWithNameTest(){
		final CastMember entity = new CastMember("CastMember 1");
		assertNotNull(entity);
		assertEquals(entity.getName(), "CastMember 1");
		assertTrue(entity.isValidUUID(entity.getId().toString()));
    assertNull(entity.getType());
	}	
  
  @Test
  @EnumSource(value = CastMemberType.class)
	public void createCastMemberWithNameAndTypeTest(){
		final CastMember entity = new CastMember("CastMember 1", CastMemberType.TYPE1);
		assertNotNull(entity);
		assertEquals(entity.getName(), "CastMember 1");
		assertTrue(entity.isValidUUID(entity.getId().toString()));
		assertNotNull(entity.getType());
    assertTrue(CastMemberType.valueOf(entity.getType()));
    assertEquals(CastMemberType.TYPE1, entity.getType());
	}

	@Test
	public void throwIlligalArgumentExceptionWhenNameIsNull(){
		assertThrows(IllegalArgumentException.class, () -> new CastMember(null));
	}
	@Test
	public void throwIlligalArgumentExceptionWhenNameIsBlank(){
		assertThrows(IllegalArgumentException.class, () -> new CastMember(""));
	}
  
	@Test
	public void throwIlligalArgumentExceptionWhenNameIsNullAndTypeIsNull(){
		assertThrows(IllegalArgumentException.class, () -> new CastMember(null, null));
	}
	@Test
	public void throwIlligalArgumentExceptionWhenNameIsBlankAndTypeIsNull(){
		assertThrows(IllegalArgumentException.class, () -> new CastMember("", null));
	}
	@Test
	public void throwIlligalArgumentExceptionWhenTypeIsNull(){
		assertThrows(IllegalArgumentException.class, () -> new CastMember("Cast Member 1", null));
	}
	@Test
	public void throwIlligalArgumentExceptionWhenTypeIsNotValid() throws IllegalArgumentException{
		assertThrows(IllegalArgumentException.class, () -> {
      CastMember entity = mock(CastMember.class);
      doThrow(IllegalArgumentException.class).when(entity).setType(CastMemberType.TYPE2);
      entity.setName("Cast Member 1");
      entity.setType(CastMemberType.TYPE2);
    });
	}
}
