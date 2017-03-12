package com.tamara.kolejka.model.stocks;

import com.tamara.kolejka.model.cards.product.ProductCard;
import com.tamara.kolejka.model.enums.ProductType;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.EnumMap;


@Slf4j
public class PlayerStockTest {

  @Rule
  public TestName mName = new TestName();

  private PlayerStock playerStock;
  private ProductCard applianceCard;
  private ProductCard kioskCard1;
  private ProductCard kioskCard2;

  @Before
  public void setUp() {
    playerStock = new PlayerStock();
    applianceCard = new ProductCard();
    applianceCard.setProductType(ProductType.APPLIANCE);
    kioskCard1 = new ProductCard();
    kioskCard1.setProductType(ProductType.KIOSK);
    kioskCard2 = new ProductCard();
    kioskCard2.setProductType(ProductType.KIOSK);
  }

  @Test
  public void testSize() {
    log.info("{}: Start", mName.getMethodName());
    Assert.assertEquals(0, playerStock.size());
    log.info("{}: Finished", mName.getMethodName());
  }

  @Test
  public void testGetCounts() {
    log.info("{}: Start", mName.getMethodName());
    EnumMap<ProductType, Integer> counts = new EnumMap<>(ProductType.class);
    counts.put(ProductType.APPLIANCE, 1);
    counts.put(ProductType.CLOTHING, 0);
    counts.put(ProductType.GROCERY, 0);
    counts.put(ProductType.FURNITURE, 0);
    counts.put(ProductType.KIOSK, 2);
    playerStock.addProduct(applianceCard);
    playerStock.addProduct(kioskCard1);
    playerStock.addProduct(kioskCard2);
    Assert.assertEquals(counts, playerStock.getCounts());
    log.info("{}: Finished", mName.getMethodName());
  }

  @Test
  public void testAddProduct() {
    log.info("{}: Start", mName.getMethodName());
    playerStock.addProduct(applianceCard);
    playerStock.addProduct(kioskCard1);
    Assert.assertEquals(2, playerStock.size());
    log.info("{}: Finished", mName.getMethodName());
  }

  @Test
  public void testRemoveProduct() {
    log.info("{}: Start", mName.getMethodName());
    playerStock.addProduct(applianceCard);
    Assert.assertEquals(applianceCard, playerStock.removeProduct(0));
    log.info("{}: Finished", mName.getMethodName());
  }

}