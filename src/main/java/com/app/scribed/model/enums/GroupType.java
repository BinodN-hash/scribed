package com.app.scribed.model.enums;

public enum GroupType {
    SUPER_ADMIN("SA"),
    ADMIN("A"),
    STUDENT("S"),
    TEACHER("T");

    private final String value;
    private GroupType(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
