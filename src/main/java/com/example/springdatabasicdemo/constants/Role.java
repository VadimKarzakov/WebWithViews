package com.example.springdatabasicdemo.constants;

public enum Role {
    USER("user"),
    ADMIN("admin");
    private final String value;

    Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
};