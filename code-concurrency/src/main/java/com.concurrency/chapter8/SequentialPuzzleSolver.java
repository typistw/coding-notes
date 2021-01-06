package com.concurrency.chapter8;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 串行的谜题解答器
 *
 * @author：jinsheng
 */
public class SequentialPuzzleSolver<P, M> {

    private final Puzzle<P, M> pmPuzzle;
    private final Set<P> seen = new HashSet<>();


    public SequentialPuzzleSolver(Puzzle<P, M> pmPuzzle) {
        this.pmPuzzle = pmPuzzle;
    }

    public List<M> solve(){
        P pos = pmPuzzle.initialPosition();
        return search(new PuzzleNode<>(pos, null, null));
    }

    private List<M> search(PuzzleNode<P, M> node){
        if(!seen.contains(node.pos)){
            seen.add(node.pos);
            if(pmPuzzle.isGoal(node.pos)){
                return node.asMoveList();
            }

            for(M move : pmPuzzle.legalMoves(node.pos)){
                P pos = pmPuzzle.move(node.pos, move);
                PuzzleNode<P, M> child =  new PuzzleNode<>(pos, move, node);
                List<M> result = search(child);
                if(result != null){
                    return result;
                }
            }
        }

        return  null;
    }
}
