package com.concurrency.chapter8;

import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;

/*
 * @author：jinsheng
 */
public class ConcurrentPuzzleSolver<P, M> {

    private final Puzzle<P, M> puzzle;
    private final ExecutorService exec;
    private final ConcurrentMap<P, Boolean> seen;
    final ValueLatch<PuzzleNode<P, M>> solution  = new ValueLatch<>();


    public ConcurrentPuzzleSolver(Puzzle<P, M> puzzle, ExecutorService exec, ConcurrentMap<P, Boolean> seen) {
        this.puzzle = puzzle;
        this.exec = exec;
        this.seen = seen;
    }

    public List<M> solve() throws InterruptedException {
        try {
            P p = puzzle.initialPosition();
            exec.execute(newTask(p, null, null));
            // 阻塞，直到找到解答
            PuzzleNode<P, M> solnNode = solution.getValue();
            return solnNode == null ? null : solnNode.asMoveList();
        }finally {
            exec.shutdown();
        }
    }

    protected Runnable newTask(P p, M m, PuzzleNode<P, M> n){
        return new SolverTask(p, m, n);
    }

    class SolverTask extends PuzzleNode<P, M> implements Runnable{

        public SolverTask(P pos, M move, PuzzleNode<P, M> prev) {
            super(pos, move, prev);
        }

        @Override
        public void run() {
            if(solution.isSet() || seen.putIfAbsent(pos, true) != null){
                // 已经找到了答案或者已经遍历了这个位置
                return;
            }

            if(puzzle.isGoal(pos)){
                solution.setValue(this);
            }else {
                for(M m : puzzle.legalMoves(pos)){
                    exec.execute(newTask(puzzle.move(pos, m), m, this));
                }
            }
        }
    }
}
