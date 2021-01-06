package com.concurrency.chapter8;

import java.util.LinkedList;
import java.util.List;

/*
 * @author：jinsheng
 */
public class PuzzleNode<P, M> {

    final P pos;
    final M move;
    final  PuzzleNode<P, M> prev;

    public PuzzleNode(P pos, M move, PuzzleNode<P, M> prev) {
        this.pos = pos;
        this.move = move;
        this.prev = prev;
    }

    List<M> asMoveList(){
        List<M> list = new LinkedList<>();
        for(PuzzleNode<P, M> n = this; n.move != null; n = n.prev){
            list.add(0, n.move);
        }

        return list;
    }
}
