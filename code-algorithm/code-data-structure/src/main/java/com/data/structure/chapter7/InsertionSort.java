package com.data.structure.chapter7;

/*
 * 插入排序
 *
 * @author：jinsheng
 * @date：2020/08/22 10:22
 */
public class InsertionSort<T extends Comparable<? super T> > {

    public void insertionSort(T[] A){
        int j ;
        for(int i = 1; i < A.length; i++){
            T item = A[i];
            for(j = i; j > 0 && item.compareTo(A[j -1]) < 0; j--){
                A[j] = A[j - 1];
            }

            A[j] = item;
        }
    }
}
