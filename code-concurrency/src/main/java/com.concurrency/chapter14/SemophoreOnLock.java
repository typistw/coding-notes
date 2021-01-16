package com.concurrency.chapter14;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 使用Lock实现信号量
 * @author：jinsheng
 */
public class SemophoreOnLock {

    private final Lock lock = new ReentrantLock();
    private final Condition permitsAvailable = lock.newCondition();
    private int permits;

    SemophoreOnLock(int initialPermits) {
        lock.lock();
        try {
            this.permits = initialPermits;
        } finally {
            lock.unlock();
        }
    }

    public void acquire() throws InterruptedException{
        lock.lock();
        try {
            while (permits <=0 ){
                permitsAvailable.await();
            }
            -- permits;
        }finally {
            lock.unlock();
        }
    }

    public void release(){
        lock.lock();
        try {
            ++ permits;
            permitsAvailable.signal();
        }finally {
            lock.unlock();
        }
    }

}
