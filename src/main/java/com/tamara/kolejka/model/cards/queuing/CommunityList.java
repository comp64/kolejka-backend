package com.tamara.kolejka.model.cards.queuing;

import com.tamara.kolejka.model.GameContext;
import com.tamara.kolejka.model.enums.Color;
import com.tamara.kolejka.model.enums.ProductType;
import com.tamara.kolejka.model.moves.Move;
import com.tamara.kolejka.model.queues.ShopQueue;

public class CommunityList implements QueuingCard {

  private static final String TITLE = "Community List";
  private static final String DESCRIPTION = "A community list that entitles people to certain places in the queue has been drawn up.";
  private static final String INSTRUCTION = "Pick up the whole queue between your two fingers and turn it back to front so that the last pawn is now first.";

  private final Color color;

  public CommunityList(Color color) {
    this.color = color;
  }

  @Override
  public Color getColor() {
    return color;
  }

  @Override
  public String getTitle() {
    return TITLE;
  }

  @Override
  public String getDescription() {
    return DESCRIPTION;
  }

  @Override
  public String getInstruction() {
    return INSTRUCTION;
  }

  @Override
  public void performQueueJumping(Move move, GameContext gameContext) {
    if (canPlay(move, gameContext)) {
      ProductType sourceShopQueue = move.getSourceShop();
      ShopQueue shopQueue = gameContext.getQueues().get(sourceShopQueue);
      shopQueue.reversePawnsOrder();
    }
  }

  @Override
  public boolean canPlay(Move move, GameContext gameContext) {
    ProductType sourceShopQueue = move.getSourceShop();
    ShopQueue shopQueue = gameContext.getQueues().get(sourceShopQueue);
    return shopQueue.size() > 0;
  }
}
