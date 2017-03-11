package com.tamara.kolejka.model.queues;

import com.tamara.kolejka.model.exceptions.IllegalPawnMoveException;
import com.tamara.kolejka.model.pawns.Pawn;

import java.util.ArrayList;
import java.util.List;

public class ShopQueue {

  private List<Pawn> queue = new ArrayList<>();

  public int size() {
    return queue.size();
  }

  public void addPawn(final Pawn pawn) {
    queue.add(pawn);
  }

  public Pawn removePawn(final int position) {
    return queue.remove(position);
  }

  public void reversePawnsOrder() {
    List<Pawn> reversed = new ArrayList<>();
    for(int idx = queue.size() - 1; idx >= 0; idx--) {
      reversed.add(queue.get(idx));
    }
    queue = reversed;
  }

  public void movePawnBackward(final int position, final int offset) throws IllegalPawnMoveException {
    if (position + offset >= queue.size()) {
      throw new IllegalPawnMoveException();
    }
    for (int idx = position; idx < position + offset; idx++) {
      Pawn temp = queue.get(idx+1);
      queue.set(idx+1, queue.get(idx));
      queue.set(idx, temp);
    }
  }

  public void movePawnForward(final int position, final int offset) throws IllegalPawnMoveException {
    if (position - offset < 0) {
      throw new IllegalPawnMoveException();
    }
    for (int idx = position; idx > position - offset; idx--) {
      Pawn temp = queue.get(idx-1);
      queue.set(idx-1, queue.get(idx));
      queue.set(idx, temp);
    }
  }
}
