package com.app.scribed.model.converter;

import com.app.scribed.model.enums.GroupType;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;
import java.util.stream.Stream;

@Convert
public class GroupTypeConverter implements AttributeConverter<GroupType, String> {


    @Override
    public String convertToDatabaseColumn(GroupType groupType) {
        return (groupType == null) ? null : groupType.getValue();
    }

    @Override
    public GroupType convertToEntityAttribute(String s) {
        return Stream.of(GroupType.values()).filter(t -> t.getValue().equals(s)).findFirst()
                .orElse(null);
    }
}
