package com.tamara.kolejka.model.stocks;

import com.tamara.kolejka.model.cards.product.ProductCard;
import com.tamara.kolejka.model.enums.ProductType;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.List;

import static org.junit.Assert.*;

@Slf4j
public class ShopStockTest {

  @Rule
  public TestName mName = new TestName();

  private final Long ID = Long.valueOf(1L);
  private final ProductType PRODUCT_TYPE = ProductType.APPLIANCE;
  private final String TITLE = "title";
  private final String DESCRIPTION = "description";

  private ShopStock shopStock;
  private ProductCard applianceCard;
  private ProductCard kioskCard;
  private ProductCard groceryCard;

  @Before
  public void setUp() {
    shopStock = new ShopStock(PRODUCT_TYPE);

    applianceCard = new ProductCard();
    applianceCard.setId(ID);
    applianceCard.setProductType(PRODUCT_TYPE);
    applianceCard.setTitle(TITLE);
    applianceCard.setDescription(DESCRIPTION);

    kioskCard = new ProductCard();
    kioskCard.setId(ID);
    kioskCard.setProductType(ProductType.KIOSK);
    kioskCard.setTitle(TITLE);
    kioskCard.setDescription(DESCRIPTION);

    groceryCard = new ProductCard();
    groceryCard.setId(ID);
    groceryCard.setProductType(ProductType.GROCERY);
    groceryCard.setTitle(TITLE);
    groceryCard.setDescription(DESCRIPTION);
  }

  @Test
  public void testSize() {
    log.info("{}: Start", mName.getMethodName());
    Assert.assertEquals(0, shopStock.size());
    log.info("{}: Finished", mName.getMethodName());
  }

  @Test
  public void testRemoveStock() {
    log.info("{}: Start", mName.getMethodName());
    shopStock.addProduct(applianceCard);
    Assert.assertEquals(applianceCard, shopStock.removeProduct(0));
    log.info("{}: Finished", mName.getMethodName());
  }

  @Test
  public void testAddProduct() {
    log.info("{}: Start", mName.getMethodName());
    shopStock.addProduct(applianceCard);
    Assert.assertEquals(1, shopStock.size());
    log.info("{}: Finished", mName.getMethodName());
  }

  @Test
  public void testListAll() {
    log.info("{}: Start", mName.getMethodName());
    shopStock.addProduct(applianceCard);
    List<ProductCard> cards = shopStock.listAll();
    Assert.assertNotNull(cards);
    Assert.assertEquals(1, cards.size());
    log.info("{}: Finished", mName.getMethodName());
  }

  @Test
  public void testRemoveFirstCorrespondingProductOrRandom() {
    log.info("{}: Start", mName.getMethodName());
    shopStock.addProduct(applianceCard);
    shopStock.addProduct(kioskCard);
    shopStock.addProduct(groceryCard);
    Assert.assertEquals(applianceCard, shopStock.removeFirstCorrespondingProductOrRandom());
    ProductCard testCard = shopStock.removeFirstCorrespondingProductOrRandom();
    Assert.assertTrue(testCard.getProductType() != PRODUCT_TYPE);
    log.info("{}: Finished", mName.getMethodName());
  }
}