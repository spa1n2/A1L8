package com.example.a1l8.models;

import java.io.Serializable;

public class TextModel implements Serializable {
    private String text;

    public TextModel(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
