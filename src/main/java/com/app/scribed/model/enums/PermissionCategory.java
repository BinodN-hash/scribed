package com.app.scribed.model.enums;

public enum PermissionCategory {
    USER_MANAGEMENT("USER_MANAGEMENT"),
    GENERAL("GENERAL"),;

    private final String value;
    private PermissionCategory (String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}
