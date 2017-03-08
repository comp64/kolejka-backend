package com.tamara.kolejka.model.cards.queuing;

import com.tamara.kolejka.model.interfaces.Colored;

/**
 * Created by g49833 on 08/03/2017.
 */
public interface QueuingCard extends Colored {
    String getTitle();
    String getDescription();
    String getInstruction();

    void performQueueJumping();
    boolean canPlay();
}
