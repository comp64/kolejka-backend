package com.tamara.kolejka.model.queues;

import com.tamara.kolejka.model.enums.Color;
import com.tamara.kolejka.model.pawns.Pawn;
import com.tamara.kolejka.model.pawns.PlayerPawn;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.ArrayList;

import static org.junit.Assert.*;

@Slf4j
public class BazaarQueueTest {

  @Rule
  public TestName mName = new TestName();

  private BazaarQueue queue;
  private Pawn blue;
  private Pawn red;
  private Pawn green;


  @Before
  public void setUp() {
    queue = new BazaarQueue();
    blue = new PlayerPawn(Color.BLUE);
    red = new PlayerPawn(Color.RED);
    green = new PlayerPawn(Color.GREEN);
  }

  @Test
  public void testGetQueue() {
    log.info("{}: Start", mName.getMethodName());
    Assert.assertNotNull(queue.getQueue());
    Assert.assertTrue(queue.getQueue() instanceof ArrayList);
    log.info("{}: Finished", mName.getMethodName());
  }

  @Test
  public void testSize() {
    log.info("{}: Start", mName.getMethodName());
    Assert.assertEquals(0, queue.size());
    log.info("{}: Finished", mName.getMethodName());
  }

  @Test
  public void testRemovePawn() {
    log.info("{}: Start", mName.getMethodName());
    queue.addPawn(blue);
    Assert.assertEquals(blue, queue.removePawn(0));
    queue.addPawn(red);
    queue.addPawn(green);
    Assert.assertEquals(green, queue.removePawn(1));
    log.info("{}: Finished", mName.getMethodName());
  }

  @Test
  public void testAddPawn() {
    log.info("{}: Start", mName.getMethodName());
    queue.addPawn(blue);
    queue.addPawn(red);
    queue.addPawn(green);
    Assert.assertEquals(3, queue.size());
    log.info("{}: Finished", mName.getMethodName());
  }



}