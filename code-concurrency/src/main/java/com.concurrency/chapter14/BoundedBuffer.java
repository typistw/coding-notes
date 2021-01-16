package com.concurrency.chapter14;

/*
 * 使用条件队列实现有界缓存(状态转换时，发出通知)
 * @author：jinsheng
 */
public class BoundedBuffer<V> extends BaseBoundedBuffer  {

    public BoundedBuffer(int capacity) {
        super(capacity);
    }

    public synchronized void put(V v) throws InterruptedException {
        while (isFull()){
            wait();
        }
        boolean wasEmpty = isEmpty();
        doPut(v);
        if(wasEmpty)
            notifyAll();
    }

    public synchronized V take() throws InterruptedException {
        while (isEmpty()){
            wait();
        }
        boolean wasFull = isFull();
        V v = (V) doTake();
        if (wasFull)
            notifyAll();
        return v;
    }
}
