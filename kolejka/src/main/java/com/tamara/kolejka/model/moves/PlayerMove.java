package com.tamara.kolejka.model.moves;

import com.tamara.kolejka.model.enums.ProductType;
import com.tamara.kolejka.model.moves.Move;

public class PlayerMove implements Move {

    private final ProductType sourceShop;
    private final int sourcePawnIndex;
    private final ProductType targetShop;
    private final int targetPawnIndex;
    private final ProductType targetDeliveryCar;

    public PlayerMove(ProductType sourceShop, int sourcePawnIndex, ProductType targetShop, int targetPawnIndex, ProductType targetDeliveryCar) {
        this.sourceShop = sourceShop;
        this.sourcePawnIndex = sourcePawnIndex;
        this.targetShop = targetShop;
        this.targetPawnIndex = targetPawnIndex;
        this.targetDeliveryCar = targetDeliveryCar;
    }

    @Override
    public ProductType getSourceShop() {
        return sourceShop;
    }

    @Override
    public int getSourcePawnIndex() {
        return sourcePawnIndex;
    }

    @Override
    public ProductType getTargetShop() {
        return targetShop;
    }

    @Override
    public int getTargetPawnIndex() {
        return targetPawnIndex;
    }

    @Override
    public ProductType getTargetDeliveryCar() {
        return targetDeliveryCar;
    }
}
