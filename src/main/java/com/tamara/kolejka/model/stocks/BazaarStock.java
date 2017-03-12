package com.tamara.kolejka.model.stocks;

import com.tamara.kolejka.model.cards.product.ProductCard;

import java.util.ArrayList;
import java.util.List;

public class BazaarStock {
  private List<ProductCard> stock = new ArrayList<>();

  public int size() {
    return stock.size();
  }

  public void addProduct(ProductCard card) {
    stock.add(card);
  }

  public ProductCard removeProduct(int position) {
    return stock.remove(position);
  }
}
