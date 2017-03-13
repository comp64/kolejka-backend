package com.tamara.kolejka.model.cards.queuing;

import com.tamara.kolejka.model.GameContext;
import com.tamara.kolejka.model.enums.Color;
import com.tamara.kolejka.model.moves.Move;

/**
 * Created by tamara on 12/03/2017.
 */
public class FriendInTheWorkersPartyProvincialCommitteeQueuingCard implements QueuingCard {

  private static final String TITLE = "Friend in the Workers  Party Provincial Committee";
  private static final String DESCRIPTION = "A friend has tipped you off about the delivery schedule.";
  private static final String INSTRUCTION = "Peek at the top two delivery cards.";

  private final Color color;

  public FriendInTheWorkersPartyProvincialCommitteeQueuingCard(Color color) {
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

  }

  @Override
  public boolean canPlay(Move move, GameContext gameContext) {
    return false;
  }
}
