package com.tamara.kolejka.model.enums;

public enum Color {
    BLACK,
    BLUE,
    BROWN,
    GREEN,
    RED,
    YELLOW;

    public boolean isPlayer() {
        return BLACK != this;
    }

    public boolean isSpeculator() {
        return BLACK == this;
    }
}
