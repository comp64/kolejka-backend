package com.tamara.kolejka.model.stocks;

import com.tamara.kolejka.model.cards.product.ProductCard;
import com.tamara.kolejka.model.enums.ProductType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShopStock {

  private List<ProductCard> stock = new ArrayList<>();

  private ProductType productType;

  public ShopStock(ProductType productType) {
    this.productType = productType;
  }

  public int size() {
    return stock.size();
  }

  public void addProduct(ProductCard card) {
    stock.add(card);
  }

  public ProductCard removeProduct(int position) {
    return stock.remove(position);
  }

  public List<ProductCard> listAll() {
    return stock;
  }

  public ProductCard removeFirstCorrespondingProductOrRandom() {
    for (int idx = stock.size() - 1; idx >= 0; idx--) {
      if (stock.get(idx).getProductType() == productType) {
        return stock.remove(idx);
      }
    }

    Random random = new Random();
    int randomPosition = random.nextInt(stock.size());
    return stock.remove(randomPosition);
  }
}
