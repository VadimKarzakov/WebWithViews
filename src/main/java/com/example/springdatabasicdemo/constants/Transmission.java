package com.example.springdatabasicdemo.constants;

public enum Transmission {

    MANUAL("manual"),
    AUTOMATIC("automatic");

    private String value;

    Transmission(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
