package com.tamara.kolejka.model;

import com.tamara.kolejka.model.enums.ProductType;
import com.tamara.kolejka.model.queues.BazaarQueue;
import com.tamara.kolejka.model.queues.ShopQueue;
import com.tamara.kolejka.model.stocks.BazaarStock;
import com.tamara.kolejka.model.stocks.ShopStock;
import lombok.Getter;

import java.util.EnumMap;

public class GameContext {

  @Getter
  private EnumMap<ProductType, ShopQueue> queues;

  @Getter
  private EnumMap<ProductType, ShopStock> shops;

  @Getter
  private EnumMap<ProductType, DeliveryCar> deliveryCars;

  @Getter
  private BazaarQueue bazaarQueue;

  @Getter
  private EnumMap<ProductType, BazaarStock> bazaarStocks;

  public GameContext() {
    queues = new EnumMap<>(ProductType.class);
    shops = new EnumMap<>(ProductType.class);
    deliveryCars = new EnumMap<>(ProductType.class);
    bazaarQueue = new BazaarQueue();
    bazaarStocks = new EnumMap<>(ProductType.class);

    for (ProductType type : ProductType.values()) {
      queues.put(type, new ShopQueue());
      shops.put(type, new ShopStock(type));
      deliveryCars.put(type, new DeliveryCar());
      bazaarStocks.put(type, new BazaarStock());
    }
  }
}
