package com.data.structure.chapter5;

/*
 * 开放地址发： 探测散列表
 * @author：jinsheng
 * @date：2020/07/27 22:08
 */
public class QuadraticProbingHashTable<T> {

    private static final int DEFAULT_TABLE_SIZE = 11;
    private HashEntry<T>[] array;
    private int currentSize;



    public QuadraticProbingHashTable(){
        this(DEFAULT_TABLE_SIZE);
    }

    public QuadraticProbingHashTable(int size){
        allocateArray(size);
        makeEmpty();
    }

    public void makeEmpty(){
        currentSize = 0;
        for(int i = 0; i < array.length; i++){
            array[i] = null;
        }
    }

    public boolean contains(T val){
        int currentPos = findPos(val);
        return  isActive(currentPos);
    }

    public void inset(T val){
        int currentPost = myhash(val);
        if(isActive(currentPost))
            return;

        array[currentPost] = new HashEntry<T>(val, true);
        if(++ currentSize > array.length/2){
            rehash();
        }
    }

    public void remove(T val){
        int currentPos = myhash(val);
        if(isActive(currentPos)){
            array[currentPos].isActive = false;
        }
    }

    private static  class HashEntry<T>{
        public T element;
        public  boolean isActive;

        public HashEntry(T val){
            this(val, true);
        }

        public HashEntry(T val, boolean i){
            element = val;
            isActive = i;
        }
    }

    private void allocateArray(int arraySize){
        array = new HashEntry[arraySize];
    }

    /**
     *  平方探测进行散列
     * @param val
     * @return
     */
    private int findPos(T val){
        int offSet = 1;
        int currentPos = myhash(val);

        while (array[currentPos] != null && !array[currentPos].element.equals(val)){
            currentPos += offSet;
            offSet += 2;
            if(currentPos >= array.length)
                currentPos -= array.length;
        }

        return currentPos;
    }

    private boolean isActive(int currentPos){
        return array[currentPos] != null && array[currentPos].isActive;
    }

    private int myhash(T val){
        int hashVal = val.hashCode();
        hashVal %= array.length;
        if(hashVal < 0){
            hashVal += array.length;
        }
        return hashVal;
    }

    private void rehash(){
        HashEntry<T>[] oldArray = array;
        allocateArray(nexPrim(oldArray.length * 2));
        currentSize = 0;

        for(int i = 0; i < oldArray.length; i++){
            if(oldArray[i] != null && oldArray[i].isActive){
                inset(oldArray[i].element);
            }
        }
    }

    private static int nexPrim(int n){
        return n;
    }
}
