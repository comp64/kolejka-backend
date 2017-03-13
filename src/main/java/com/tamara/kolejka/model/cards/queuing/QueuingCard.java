package com.tamara.kolejka.model.cards.queuing;

import com.tamara.kolejka.model.GameContext;
import com.tamara.kolejka.model.interfaces.Colored;
import com.tamara.kolejka.model.moves.Move;

public interface QueuingCard extends Colored {
    String getTitle();
    String getDescription();
    String getInstruction();

    void performQueueJumping(Move move, GameContext gameContext);
    boolean canPlay(Move move, GameContext gameContext);
}
