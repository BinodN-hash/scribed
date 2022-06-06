package com.app.scribed.model.enums;

public enum Status {

    ACTIVE("A"),
    BLOCKED("B"),;

    private final String value;
    private Status (final String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    public boolean isEnabled(){
        return this == ACTIVE;
    }


}
