package com.tamara.kolejka.model.queues;

import com.tamara.kolejka.model.pawns.Pawn;

import java.util.ArrayList;
import java.util.List;

public class BazaarQueue {
  private List<Pawn> queue = new ArrayList<>();

  public List<Pawn> getQueue() {
    return queue;
  }

  public int size() {
    return queue.size();
  }

  public void addPawn(Pawn pawn) {
    queue.add(pawn);
  }

  public Pawn removePawn(int position) {
    return queue.remove(position);
  }
}
