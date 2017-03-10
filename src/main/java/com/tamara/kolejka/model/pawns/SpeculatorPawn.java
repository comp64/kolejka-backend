package com.tamara.kolejka.model.pawns;

import com.tamara.kolejka.model.enums.Color;

public class SpeculatorPawn implements Pawn {

    @Override
    public Color getColor() {
        return Color.BLACK;
    }
}
