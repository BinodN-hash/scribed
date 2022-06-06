package com.app.scribed.model.converter;

import com.app.scribed.model.enums.Status;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter
public class StatusConverter implements AttributeConverter<Status, String> {


    @Override
    public String convertToDatabaseColumn(Status status) {
        return (status == null) ? null : status.getValue();
    }

    @Override
    public Status convertToEntityAttribute(String s) {
        return Stream.of(Status.values()).filter(c -> c.getValue().equals(s)).findFirst()
                .orElse(null);
    }
}
