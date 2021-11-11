package com.console.university.model;

public enum Degree {
    ASSISTANT("assistant"),
    ASSOCIATE_PROFESSOR("associate professor"),
    PROFESSOR("professor");

    private final String degree;

    Degree(String degree) {
        this.degree = degree;
    }

    public String getValue() {
        return degree;
    }
}
