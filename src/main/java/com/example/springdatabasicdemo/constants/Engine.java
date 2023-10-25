package com.example.springdatabasicdemo.constants;

public enum Engine {

    GASOLIN(1),
    DIESEL(2),
    ELECTRIC(3),
    HYBRID(4);

    private final int value;

    Engine(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
