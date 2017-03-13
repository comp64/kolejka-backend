package com.tamara.kolejka.model;

import com.tamara.kolejka.model.enums.Color;
import com.tamara.kolejka.model.interfaces.Colored;

public class Player implements Colored {

  private Color color;

  @Override
  public Color getColor() {
    return color;
  }
}
