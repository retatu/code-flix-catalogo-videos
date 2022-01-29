package com.codeflix.CFCatalogo.domain.entity;

import java.util.UUID;
import java.util.regex.Pattern;
import javax.persistence.MappedSuperclass;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "VARBINARY(16)")
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        if (id == null)
            throw new IllegalArgumentException("id is marked as non-null but got null");
        if (this.isValidUUID(id.toString()))
            throw new IllegalArgumentException("id is marked as valid but got invalid");
        this.id = id;
    }

    protected UUID generateUUID() {
        this.id = UUID.randomUUID();
        return this.id;
    }

    protected Boolean isValidUUID(String id) {
        if (id == null)
            return false;
        Pattern UUID_REGEX_PATTERN = Pattern.compile("^[{]?[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}[}]?$");

        return UUID_REGEX_PATTERN.matcher(id).matches();
    }
}
