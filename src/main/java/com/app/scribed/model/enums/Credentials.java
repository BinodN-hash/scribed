package com.app.scribed.model.enums;

public enum Credentials {

    LOGIN_PASSWORD("L"),;

    private final String value;
    private Credentials(final String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
