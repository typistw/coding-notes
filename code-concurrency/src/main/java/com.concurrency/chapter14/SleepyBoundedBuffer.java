package com.concurrency.chapter14;

/*
 * 通过轮询与休眠来实现简单的阻塞
 *  @author：jinsheng
 */
public class SleepyBoundedBuffer<V> extends BaseBoundedBuffer {

    protected SleepyBoundedBuffer(int capacity) {
        super(capacity);
    }

    public void put(V v) throws InterruptedException {
        while (true){
            synchronized (this){
                if(!isFull()){
                    doPut(v);
                    return;
                }
            }

            Thread.sleep(10 * 1000);
        }
    }

    public V take() throws InterruptedException {
        while (true){
            synchronized (this){
                if(!isEmpty()){
                    return (V) doTake();
                }
            }

            Thread.sleep(10 * 1000);
        }
    }
}
