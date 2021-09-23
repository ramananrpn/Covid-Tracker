package com.example.java_sample.constants;

public enum Status {
    POSITIVE("positive"),
    NEGATIVE("negative"),
    RECOVERED("recovered");

    public final String status;

    private Status(String status) {
        this.status = status;
    }
}
