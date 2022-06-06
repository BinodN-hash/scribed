package com.app.scribed.model.converter;

import com.app.scribed.model.enums.PermissionCategory;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class PermissionCategoryConverter implements AttributeConverter<PermissionCategory, String> {


    @Override
    public String convertToDatabaseColumn(PermissionCategory permissionCategory) {
        return (permissionCategory == null) ? null : permissionCategory.name();
    }

    @Override
    public PermissionCategory convertToEntityAttribute(String s) {
        return PermissionCategory.valueOf(s);
    }
}
