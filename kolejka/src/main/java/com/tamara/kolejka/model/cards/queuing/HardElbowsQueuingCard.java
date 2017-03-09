package com.tamara.kolejka.model.cards.queuing;

import com.tamara.kolejka.model.enums.Color;
import com.tamara.kolejka.model.moves.Move;
import lombok.Getter;

/**
 * Created by g49833 on 08/03/2017.
 */
public class HardElbowsQueuingCard implements QueuingCard {

    private static final String TITLE = "Hard Elbows";

    private static final String DESCRIPTION = "You cannot patiently wait while there is a much queue boorishness going around.";

    private static final String INSTRUCTION = "Draw one queue card. You will have additional turn of the queue jumping.";

    @Getter
    private final Color color;

    public HardElbowsQueuingCard(Color color) {
        this.color = color;
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
    public void performQueueJumping(Move move) {
        // TODO: finish this
    }

    @Override
    public boolean canPlay(Move move) {
        // TODO: finish this
        return false;
    }
}
