package com.concurrency.chapter12;

import java.util.concurrent.Semaphore;

/*
 * 基于信号量的有界缓存
 * @author：jinsheng
 */
public class BoundedBuffer<E> {

    private final Semaphore availableItem, availableSpace;
    private final E[] items;
    private int putPosition = 0, takePosition  = 0;

    public BoundedBuffer(int capacity){
        availableItem = new Semaphore(0);
        availableSpace  =new Semaphore(capacity);
        items = (E[])new Object[capacity];
    }

    public boolean isEmapty(){
        return availableItem.availablePermits() == 0;
    }

    public boolean isFull(){
        return availableSpace.availablePermits() == 0;
    }

    public void put(E x) throws InterruptedException {
        availableSpace.acquire();
        doInsert(x);
        availableItem.release();
    }

    public E take() throws InterruptedException {
        availableItem.acquire();
        E item = doExtract();
        availableSpace.release();
        return item;
    }

    private synchronized void doInsert(E x){
        int i = putPosition;
        items[i] = x;
        putPosition = (++i == items.length) ? 0 : i;
    }

    private synchronized E doExtract(){
        int i = putPosition;
        E x = items[i];
        items[i] = null;
        takePosition = (++i == items.length) ? 0 : i;
        return x;
    }
}
