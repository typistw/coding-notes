package com.concurrency.chapter12;

import org.junit.Assert;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * @author：jinsheng
 */
public class PutTakeTest {

    private static final ExecutorService pool = Executors.newCachedThreadPool();

    private final AtomicInteger pusSum = new AtomicInteger();
    private final AtomicInteger takeSum = new AtomicInteger();
    private final CyclicBarrier barrier;
    private final BoundedBuffer<Integer> bb;
    private int nTrials, nPairs;

    public static void main(String[] args) {
        new PutTakeTest(10, 10,1000000).test();
        pool.shutdown();
    }

    public PutTakeTest(int capacity, int npairs, int ntrials){
        this.bb = new BoundedBuffer<>(capacity);
        this.nPairs = npairs;
        this.nTrials = ntrials;
        this.barrier = new CyclicBarrier(npairs * 2 + 1);
    }

    void test(){
        try {
            for(int i = 0; i < nPairs; i++){
                pool.execute(new Producer());
                pool.execute(new Consumer());
            }

            // 等待所有线程就绪
            barrier.await();
            // 等待所有线程执行完成
            barrier.await();
            Assert.assertEquals(pusSum.get(), takeSum.get());

        }catch (Exception e){
            throw new RuntimeException();
        }
    }


    private int xorShift(int y){
        y ^= (y << 6);
        y ^= (y >>> 21);
        y ^= (y << 7);
        return y;
    }

    class Producer implements  Runnable{
        @Override
        public void run() {
            try {
                int seed = (this.hashCode()) ^ (int)System.nanoTime();
                int sum = 0;
                barrier.await();
                for(int i = nTrials; i > 0; -- i){
                    bb.put(seed);
                    sum += seed;
                    seed = xorShift(seed);
                }
                pusSum.getAndAdd(sum);
                barrier.await();
            }catch (Exception e){
                throw new RuntimeException();
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            try {
                barrier.await();
                int sum = 0;
                for(int i = nTrials; i > 0; -- i){
                    sum += bb.take();
                }
                takeSum.getAndAdd(sum);
                barrier.await();
            }catch (Exception e){
                throw new RuntimeException();
            }
        }
    }
}
