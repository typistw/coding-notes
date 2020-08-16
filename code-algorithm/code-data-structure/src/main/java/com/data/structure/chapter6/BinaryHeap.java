package com.data.structure.chapter6;

import java.nio.BufferUnderflowException;

/*
 * 二叉堆：
 *  1、结构性质
 *      堆是一科完全填满的二叉树
 *      数组实现： 对于数组中任意一位置 i 上的元素，其左儿子位置在 2*i； 右儿子在左儿子后的单元（2*i + 1）；父亲节点则在位置 i/2 上；
 *  2、堆序性质
 *      让操作快速的执行(想要快速的找出最小元): 对于每一个节点X(根节点除外),X的父节点的中关键字 小于或等于 X中的关键字
 *
 *
 * @author：jinsheng
 * @date：2020/08/09 15:36
 */
public class BinaryHeap<T extends Comparable<? super T>> {

    private final static int DEFAULT_CAPACITY = 10;
    private int currentSize;
    private T[] array;

    public BinaryHeap(){
        currentSize = 0;
        array = (T[])new Comparable[DEFAULT_CAPACITY + 1];
    }

    public BinaryHeap(int capacity){
        currentSize = 0;
        array = (T[])new Comparable[capacity + 1];
    }

    public BinaryHeap(T[] items){
        currentSize = items.length;

        array = (T[]) new Comparable[(currentSize + 2)* 11 /10];

        int i = 1;
        for(T item : items){
            array[i++] = item;
        }

        buildHeap();
    }

    public void insert(T val){
        // percolate up
        if(currentSize == array.length - 1){
            enlargeArray(array.length * 2 + 1);
        }

        int hole = ++ currentSize;
        for(; hole > 1 && val.compareTo(array[hole/2]) < 0; hole /=2){
            array[hole] = array[hole/2];
        }
        array[hole] = val;
    }

    public T deleteMin(){
        if(isEmpty())
            throw  new BufferUnderflowException();

        T item = findMin();
        // 最后一个节点做下沉过滤
        array[1] = array[currentSize--];
        percolateDown(1);
        return item;
    }

    public T findMin(){
        return array[1];
    }

    public boolean isEmpty(){
        return array[1] == null;
    }

    public void makeEmpty(){
        for(int i = 1; i <= currentSize; i++){
            array[i] = null;
        }

        currentSize = 0;
    }

    private void percolateDown(int hole){
        int child = 0;
        T tmp = array[hole];

        for(; hole * 2 <= currentSize; hole = child){
            // 左儿子节点位置
            child = hole * 2;
            if(child != currentSize && array[child + 1].compareTo(array[child]) < 0){
                child ++;
            }

            if(array[child].compareTo(tmp) < 0){
                array[hole] = array[child];
            }else{
                break;
            }
        }

        array[hole] = tmp;
    }

    private void buildHeap(){
        for(int i = currentSize/2; i > 0; i--){
            percolateDown(i);
        }
    }

    private void enlargeArray(int newSize){
        T[] oldAry = array;
        array = (T[]) new Comparable[newSize];
        for(int i = 1; i < oldAry.length; i++){
            array[i] = oldAry[i];
        }
    }
}
