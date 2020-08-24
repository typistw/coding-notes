package com.data.structure.chapter7;

/*
 * 希尔排序
 *
 * @author：jinsheng
 * @date：2020/08/22 10:46
 */
public class ShellSort<T extends Comparable<? super T>> {

    public void shellSort(T[] a){
        int j;

        for(int gap = a.length/2; gap > 0; gap /= 2){
            for(int i = gap; i < a.length; i++){
                T  temp = a[i];
                for(j = i; j >= gap && temp.compareTo(a[j-gap]) < 0; j -= gap){
                    a[j] = a[j - gap];
                }
                a[j] = temp;
            }
        }
    }

}
