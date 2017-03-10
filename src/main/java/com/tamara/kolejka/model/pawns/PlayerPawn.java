package com.tamara.kolejka.model.pawns;

import com.tamara.kolejka.model.enums.Color;

public class PlayerPawn implements Pawn {

    private Color color;

    public PlayerPawn(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }
}
