package com.tamara.kolejka.model.stocks;

import com.tamara.kolejka.model.cards.product.ProductCard;
import com.tamara.kolejka.model.queues.BazaarQueue;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

@Slf4j
public class BazaarStockTest {

  @Rule
  public TestName mName = new TestName();

  private BazaarStock bazaarStock;
  private ProductCard productCard = new ProductCard();

  @Before
  public void setUp() throws Exception {
    bazaarStock = new BazaarStock();
  }

  @Test
  public void testSize() {
    log.info("{}: Start", mName.getMethodName());
    Assert.assertEquals(0, bazaarStock.size());
    log.info("{}: Finished", mName.getMethodName());
  }

  @Test
  public void testAddProduct() {
    log.info("{}: Start", mName.getMethodName());
    bazaarStock.addProduct(productCard);
    Assert.assertEquals(1, bazaarStock.size());
    log.info("{}: Finished", mName.getMethodName());
  }

  @Test
  public void testRemoveProduct() {
    log.info("{}: Start", mName.getMethodName());
    bazaarStock.addProduct(productCard);
    Assert.assertEquals(productCard, bazaarStock.removeProduct(0));
    log.info("{}: Finished", mName.getMethodName());
  }
}