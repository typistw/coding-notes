package com.data.structure.chapter5;

import java.util.LinkedList;
import java.util.List;

/*
 * 分离连接法 解决Hash冲突： 将散列到同一个值的元素保留到一个链表中
 * @author：jinsheng
 * @date：2020/07/21 22:27
 */
public class SeparateChainingHashTable<T> {

    private static  final int DEFAULT_TABLE_SIZE = 101;
    private List<T>[] theLists;
    private int currentSize;

    public SeparateChainingHashTable(){
        this(DEFAULT_TABLE_SIZE);
    }

    public SeparateChainingHashTable(int size){
        theLists = new LinkedList[nextPrime(size)];
        for(int i = 0 ; i < theLists.length; i++){
            theLists[i] = new LinkedList<>();
        }
    }

    public void inset(T val){
        List<T> list = theLists[myhash(val)];
        if(!list.contains(val)){
            list.add(val);

            if(++currentSize > theLists.length){
                rehash();
            }
        }
    }

    public void remove(T val){
        List<T> list = theLists[myhash(val)];
        if(list.contains(val)){
            list.remove(val);
            -- currentSize;
        }
    }

    public boolean constains(T val){
        List<T> list = theLists[myhash(val)];
        return list.contains(val);
    }

    public void makeEmpty(){
        for(int i = 0; i < theLists.length; i++){
            theLists[i].clear();
        }
        currentSize = 0;
    }

    private int myhash(T val){
        int hasVal = val.hashCode();
        hasVal %= theLists.length;

        if(hasVal < 0){
            hasVal += theLists.length;
        }
        return hasVal;
    }

    private void rehash(){
        List<T>[] oldList = theLists;
        theLists = new LinkedList[nextPrime(2 * theLists.length)];
        for(int i = 0; i < theLists.length; i++){
            theLists[i] = new LinkedList<>();
        }

        currentSize = 0;
        for(int i = 0; i < oldList.length; i++){
            for(T item : oldList[i]){
                inset(item);
            }
        }
    }


    private static int nextPrime(int n){
        return 0;
    }

    private static boolean isPrime(int n){
        return false;
    }

}
