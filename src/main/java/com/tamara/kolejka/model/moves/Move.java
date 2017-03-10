package com.tamara.kolejka.model.moves;

import com.tamara.kolejka.model.enums.ProductType;

public interface Move {
    ProductType getSourceShop();
    int getSourcePawnIndex();
    ProductType getTargetShop();
    int getTargetPawnIndex();
    ProductType getTargetDeliveryCar();
}
