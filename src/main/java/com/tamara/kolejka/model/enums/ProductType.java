package com.tamara.kolejka.model.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public enum ProductType {
    APPLIANCE,
    CLOTHING,
    FURNITURE,
    GROCERY,
    KIOSK,
    VODKA;

    @Getter
    private static List<ProductType> standardProductTypes;

    @Getter
    private static List<ProductType> extendedProductTypes;

    static {
        standardProductTypes = Arrays.asList(APPLIANCE, CLOTHING, FURNITURE, GROCERY, KIOSK);
        extendedProductTypes = Arrays.asList(APPLIANCE, CLOTHING, FURNITURE, GROCERY, KIOSK, VODKA);
    }
}
