package com.concurrency.chapter8;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * @author：jinsheng
 */
public class PuzzleSolver<P, M> extends ConcurrentPuzzleSolver<P, M> {

    private final AtomicInteger taskCount = new AtomicInteger();

    public PuzzleSolver(Puzzle<P, M> puzzle, ExecutorService exec, ConcurrentMap<P, Boolean> seen) {
        super(puzzle, exec, seen);
    }

    protected Runnable newTask(P p, M m, PuzzleNode<P,M> n){
        return  new CountingSolverTask(p ,m , n);
    }

    class CountingSolverTask extends ConcurrentPuzzleSolver.SolverTask{

        public CountingSolverTask(Object pos, Object move, PuzzleNode prev) {
            super(pos, move, prev);
            taskCount.incrementAndGet();
        }

        public void run(){
            try {
                super.run();
            }finally {
                if(taskCount.decrementAndGet() == 0){
                    solution.setValue(null);
                }
            }
        }
    }
}
