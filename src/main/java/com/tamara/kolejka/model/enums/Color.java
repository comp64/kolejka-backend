package com.tamara.kolejka.model.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public enum Color {
    BLACK,
    BLUE,
    BROWN,
    GREEN,
    RED,
    YELLOW,
    WHITE;

    @Getter
    private static List<Color> standardColors;

    @Getter
    private static List<Color> extendedColors;

    static {
        standardColors = Arrays.asList(BLACK, BLUE, BROWN, GREEN, RED, YELLOW);
        extendedColors = Arrays.asList(BLACK, BLUE, BROWN, GREEN, RED, YELLOW, WHITE);
    }

    public boolean isPlayer() {
        return BLACK != this;
    }

    public boolean isSpeculator() {
        return BLACK == this;
    }
}
