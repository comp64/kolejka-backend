package com.tamara.kolejka.model.cards.product;

import com.tamara.kolejka.model.enums.ProductType;
import com.tamara.kolejka.model.interfaces.Produced;
import lombok.Getter;
import lombok.Setter;

public class ProductCard implements Produced {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private ProductType productType;
}
