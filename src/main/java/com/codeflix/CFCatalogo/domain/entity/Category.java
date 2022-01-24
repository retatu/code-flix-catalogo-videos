package com.codeflix.CFCatalogo.domain.entity;

import java.util.UUID;

public class Category{
  private UUID uuid;
  private String name;

  public Category() {}
  public Category(String name) {}
  public Category(UUID uuid, String name) {}

  public String getName() {
    return name;
  }

  public void setName(String name) throws IllegalArgumentException {
    if(name == null || name.isEmpty()) throw new IllegalArgumentException("")
    this.name = name;
  }
}
