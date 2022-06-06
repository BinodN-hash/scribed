package com.app.scribed.model.converter;

import com.app.scribed.model.enums.Credentials;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter
public class CredentialsConverter implements AttributeConverter<Credentials, String> {

    @Override
    public String convertToDatabaseColumn(Credentials attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public Credentials convertToEntityAttribute(String dbData) {
        return Stream.of(Credentials.values()).filter(c -> c.getValue().equals(dbData)).findFirst()
                .orElse(null);
    }
}
