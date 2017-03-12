package com.tamara.kolejka.model.stocks;

import com.tamara.kolejka.model.cards.product.ProductCard;
import com.tamara.kolejka.model.enums.ProductType;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class PlayerStock {

  private List<ProductCard> stock = new ArrayList<>();

  private EnumMap<ProductType, Integer> counts;

  public PlayerStock() {
    counts = new EnumMap<>(ProductType.class);
    for (ProductType type : ProductType.values()) {
      counts.put(type, 0);
    }
  }

  public int size() {
    return stock.size();
  }

  public void addProduct(ProductCard card) {
    stock.add(card);
    increaseProductCount(card.getProductType());
  }

  private void increaseProductCount(ProductType type) {
    int productCount = counts.get(type);
    counts.put(type, productCount + 1);
  }

  private void decreaseProductCount(ProductType type) {
    int productCount = counts.get(type);
    counts.put(type, productCount - 1);
  }

  public EnumMap<ProductType, Integer> getCounts() {
    return counts;
  }

  public ProductCard removeProduct(int position) {
    ProductCard removedCard = stock.remove(position);
    decreaseProductCount(removedCard.getProductType());
    return removedCard;
  }
}
