package com.tamara.kolejka.model.queues;

import com.tamara.kolejka.model.enums.Color;
import com.tamara.kolejka.model.exceptions.IllegalPawnMoveException;
import com.tamara.kolejka.model.pawns.Pawn;
import com.tamara.kolejka.model.pawns.PlayerPawn;
import com.tamara.kolejka.model.pawns.SpeculatorPawn;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

@Slf4j
public class ShopQueueTest {

  @Rule
  public TestName mName = new TestName();

  private ShopQueue shopQueue;
  private Pawn black;
  private Pawn blue;
  private Pawn green;
  private Pawn yellow;

  @Before
  public void setUp() throws Exception {
    shopQueue = new ShopQueue();
    black = new SpeculatorPawn();
    blue = new PlayerPawn(Color.BLUE);
    green = new PlayerPawn(Color.GREEN);
    yellow = new PlayerPawn(Color.YELLOW);
  }

  @Test
  public void testSize() {
    log.info("{}: Start", mName.getMethodName());
    Assert.assertEquals(0, shopQueue.size());
    log.info("{}: Finished", mName.getMethodName());
  }

  @Test
  public void testAddPawn() {
    log.info("{}: Start", mName.getMethodName());
    shopQueue.addPawn(black);
    Assert.assertEquals(1, shopQueue.size());
    shopQueue.addPawn(blue);
    shopQueue.addPawn(green);
    shopQueue.addPawn(yellow);
    Assert.assertEquals(4, shopQueue.size());
    log.info("{}: Finished", mName.getMethodName());
  }

  @Test
  public void testRemovePawn() {
    log.info("{}: Start", mName.getMethodName());
    shopQueue.addPawn(black);
    Assert.assertEquals(1, shopQueue.size());
    Pawn removedPawn = shopQueue.removePawn(0);
    Assert.assertEquals(black, removedPawn);
    Assert.assertEquals(0, shopQueue.size());
    log.info("{}: Finished", mName.getMethodName());
  }

  @Test
  public void testMovePawnBackward() {
    log.info("{}: Start", mName.getMethodName());
    shopQueue.addPawn(black);
    shopQueue.addPawn(blue);
    shopQueue.addPawn(green);
    shopQueue.addPawn(yellow);
    try {
      shopQueue.movePawnBackward(2, 1);
    } catch (IllegalPawnMoveException e) {
      log.error("{}: {}", mName.getMethodName(), e.getMessage(), e);
    }
    Assert.assertEquals(black, shopQueue.removePawn(0));
    Assert.assertEquals(blue, shopQueue.removePawn(0));
    Assert.assertEquals(yellow, shopQueue.removePawn(0));
    Assert.assertEquals(green, shopQueue.removePawn(0));
    log.info("{}: Finished", mName.getMethodName());
  }

  @Test(expected = IllegalPawnMoveException.class)
  public void testMovePawnBackwardsException() throws IllegalPawnMoveException {
    log.info("{}: Start", mName.getMethodName());
    shopQueue.addPawn(black);
    shopQueue.addPawn(blue);
    shopQueue.addPawn(green);
    shopQueue.addPawn(yellow);
    shopQueue.movePawnBackward(3, 1);
    log.info("{}: Finished", mName.getMethodName());
  }

  @Test
  public void testMovePawnForward() {
    log.info("{}: Start", mName.getMethodName());
    shopQueue.addPawn(black);
    shopQueue.addPawn(blue);
    shopQueue.addPawn(green);
    shopQueue.addPawn(yellow);
    try {
      shopQueue.movePawnForward(2, 2);
    } catch (IllegalPawnMoveException e) {
      log.error("{}: {}", mName.getMethodName(), e.getMessage(), e);
    }
    Assert.assertEquals(green, shopQueue.removePawn(0));
    Assert.assertEquals(black, shopQueue.removePawn(0));
    Assert.assertEquals(blue, shopQueue.removePawn(0));
    Assert.assertEquals(yellow, shopQueue.removePawn(0));
    log.info("{}: Finished", mName.getMethodName());
  }

  @Test(expected = IllegalPawnMoveException.class)
  public void testMovePawnForwardsException() throws IllegalPawnMoveException {
    log.info("{}: Start", mName.getMethodName());
    shopQueue.addPawn(black);
    shopQueue.addPawn(blue);
    shopQueue.addPawn(green);
    shopQueue.addPawn(yellow);
    shopQueue.movePawnForward(3, 4);
    log.info("{}: Finished", mName.getMethodName());
  }

  @Test
  public void testReversePawnsOrder() {
    log.info("{}: Start", mName.getMethodName());
    shopQueue.addPawn(black);
    shopQueue.addPawn(blue);
    shopQueue.addPawn(green);
    shopQueue.addPawn(yellow);
    shopQueue.reversePawnsOrder();
    Assert.assertEquals(yellow, shopQueue.removePawn(0));
    Assert.assertEquals(green, shopQueue.removePawn(0));
    Assert.assertEquals(blue, shopQueue.removePawn(0));
    Assert.assertEquals(black, shopQueue.removePawn(0));
    log.info("{}: Finished", mName.getMethodName());
  }

}