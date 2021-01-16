package com.concurrency.chapter14;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;

/*
 * 将前提条件的失败传递给调用者
 *
 * @author：jinsheng
 */
public class GrumpyBoundedBuffer<V> extends BaseBoundedBuffer {

    protected GrumpyBoundedBuffer(int capacity) {
        super(capacity);
    }

    public synchronized void put(V v) throws BufferOverflowException{
        // 缓存已满 并不是有界缓存的一个异常条件
        if(isFull()){
            throw  new BufferOverflowException();
        }

        doPut(v);
    }

    public synchronized  V take() throws BufferUnderflowException{
        if(isEmpty()){
            throw  new BufferUnderflowException();
        }
        return (V) doTake();
    }
}
