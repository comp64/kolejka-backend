package com.tamara.kolejka.model.cards.delivery;

import com.tamara.kolejka.model.enums.ProductType;
import lombok.Getter;

/**
 * Created by g49833 on 08/03/2017.
 */
public class DeliveryCard implements Delivering {

    @Getter
    private final ProductType productType;

    @Getter
    private final int numberOfProductCards;

    public DeliveryCard(ProductType productType, int numberOfProductCards) {
        this.productType = productType;
        this.numberOfProductCards = numberOfProductCards;
    }
}
