package com.codeflix.CFCatalogo.domain.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.codeflix.CFCatalogo.domain.entity.BaseEntity;

enum CastMemberType {
	TYPE1(1),
	TYPE2(2);

	private Integer type;
	private final static Map values = new HashMap<>();

	private CastMemberType(Integer type) {
		this.type = type;
	}

	static {
		for (CastMemberType type : CastMemberType.values()) {
			values.put(type.type, type);
		}
	}

	public Integer getType() {
		return this.type;
	}

	public static Boolean valueOf(CastMemberType type) {
		CastMemberType CastMemberType = (CastMemberType) values.get(type);
		if (CastMemberType == null)
			return false;
		return true;
	}
}

public class CastMember extends BaseEntity {
	private String name;
	private CastMemberType type;

	public CastMember() {
	}

	public CastMember(UUID id, String name, CastMemberType type) {
		super.setId(id);
		this.name = name;
		this.type = type;
	}
	public CastMember(String name, CastMemberType type) {
		super.generateUUID();
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null) throw new IllegalArgumentException("name is marked as non-null but got null");
		if (name.isEmpty()) throw new IllegalArgumentException("name is marked as non-blank but got null");
		this.name = name;
	}

	public CastMemberType getCastMemberType() {
		return type;
	}

	public void setCastMemberType(CastMemberType type) {
		if (type == null) throw new IllegalArgumentException("type is marked as non-null but got null");
		if (!CastMemberType.valueOf(type)) throw new IllegalArgumentException("type is marked as valid-enum but is not a valid enum");
		this.type = type;
	}

}
