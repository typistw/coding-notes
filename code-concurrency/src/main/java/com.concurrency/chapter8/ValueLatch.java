package com.concurrency.chapter8;

import java.util.concurrent.CountDownLatch;

/*
 * @author：jinsheng
 */
public class ValueLatch<T> {

    private T value = null;
    private final CountDownLatch down = new CountDownLatch(1);

    public boolean isSet(){
        return down.getCount() == 0;
    }

    public synchronized void setValue(T newValue){
        if(!isSet()){
            value = newValue;
            down.countDown();
        }
    }

    public T getValue() throws InterruptedException {
        down.await();
        synchronized (this){
            return value;
        }
    }
}
