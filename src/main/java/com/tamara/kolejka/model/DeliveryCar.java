package com.tamara.kolejka.model;

import com.tamara.kolejka.model.cards.product.ProductCard;

import java.util.List;

public class DeliveryCar {

    private List<ProductCard> stock;

    public DeliveryCar() {
    }

    public DeliveryCar(List<ProductCard> stock) {
        this.stock = stock;
    }

    public ProductCard takeTopProduct() {
        return stock.remove(stock.size()-1);
    }

    public void addProduct(ProductCard productCard) {
        stock.add(productCard);
    }

    public int size() {
        return stock.size();
    }

}
