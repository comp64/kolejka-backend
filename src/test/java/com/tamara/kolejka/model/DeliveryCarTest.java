package com.tamara.kolejka.model;

import com.tamara.kolejka.model.cards.product.ProductCard;
import com.tamara.kolejka.model.enums.ProductType;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class DeliveryCarTest {

    private final Long ID = Long.valueOf(1L);
    private final ProductType PRODUCT_TYPE = ProductType.APPLIANCE;
    private final String TITLE = "title";
    private final String DESCRIPTION = "description";

    @Rule
    public TestName mName = new TestName();

    private DeliveryCar deliveryCar;

    @Before
    public void setUp() {
        List<ProductCard> cards = new ArrayList<>();
        ProductCard applianceCard = new ProductCard();
        applianceCard.setId(ID);
        applianceCard.setProductType(PRODUCT_TYPE);
        applianceCard.setTitle(TITLE);
        applianceCard.setDescription(DESCRIPTION);
        cards.add(applianceCard);

        deliveryCar = new DeliveryCar(cards);
    }

    @Test
    public void takeTopProduct() throws Exception {
        log.info("{}: Start", mName.getMethodName());
        ProductCard removedCard = deliveryCar.takeTopProduct();
        Assert.assertNotNull(removedCard);
        Assert.assertEquals(ID, removedCard.getId());
        Assert.assertEquals(PRODUCT_TYPE, removedCard.getProductType());
        Assert.assertEquals(TITLE, removedCard.getTitle());
        Assert.assertEquals(DESCRIPTION, removedCard.getDescription());
        Assert.assertEquals(0, deliveryCar.size());
        log.info("{}: Finished", mName.getMethodName());
    }

    @Test
    public void addProduct() throws Exception {
        log.info("{}: Start", mName.getMethodName());
        ProductCard applianceCard = new ProductCard();
        applianceCard.setId(ID);
        applianceCard.setProductType(PRODUCT_TYPE);
        applianceCard.setTitle(TITLE);
        applianceCard.setDescription(DESCRIPTION);
        deliveryCar.addProduct(applianceCard);
        Assert.assertEquals(2, deliveryCar.size());
        log.info("{}: Finished", mName.getMethodName());
    }

    @Test
    public void size() throws Exception {
        log.info("{}: Start", mName.getMethodName());
        Assert.assertEquals(1, deliveryCar.size());
        log.info("{}: Finished", mName.getMethodName());
    }
}
