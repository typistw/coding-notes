package com.concurrency.chapter12;

import org.junit.Assert;
import org.junit.Test;

/*
 * @author：jinsheng
 */
public class TestBoundedBuffer {

    @Test
    public void testIsEmptyWhenConstructed(){
        BoundedBuffer<Integer> bb  = new BoundedBuffer<>(10);
        Assert.assertTrue(bb.isEmapty());
        Assert.assertFalse(bb.isFull());
    }


    @Test
    public void testIsFullAfterPuts() throws InterruptedException {
        int capacity = 10;
        BoundedBuffer<Integer> bb = new BoundedBuffer<>(capacity);
        for (int i = 0 ; i < capacity; i++){
            bb.put(i);
        }

        Assert.assertFalse(bb.isEmapty());
        Assert.assertTrue(bb.isFull());
    }

    @Test
    public void testTakeBlocksWhenEmpty() {
        final BoundedBuffer<Integer> bb = new BoundedBuffer<>(10);
        Thread taker = new Thread(){
            public void run(){
                try {
                    int unused = bb.take();
                    // fail
                }catch (InterruptedException e){

                }
            }
        };

       try {
           taker.start();
           Thread.sleep(1000);
           taker.interrupt();
           taker.join(2000);
           Assert.assertTrue(taker.isAlive());
       }catch (Exception e){
           // fail
       }
    }
}
