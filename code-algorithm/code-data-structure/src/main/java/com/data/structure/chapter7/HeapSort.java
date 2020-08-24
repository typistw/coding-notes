package com.data.structure.chapter7;

/*
 * 堆排序
 *
 * @author：jinsheng
 * @date：2020/08/22 15:29
 */
public class HeapSort<T extends Comparable<? super T>> {

    public void heapSort(T[] a){
        for(int i = a.length/2; i >=0 ;i --){
            // build heap
            percolateDown(a, i, a.length);
        }

        for(int i = a.length - 1; i >= 0; i--){
            //deleteMax
            swapReferences(a, 0, i);
            percolateDown(a, 0, i);
        }
    }


    private int leftChild(int i ){
        return  2 * i + 1;
    }

    private void percolateDown(T[] a, int i, int n){
        int child;
        T temp;
        for(temp = a[i]; leftChild(i) < n; i = child){
            child = leftChild(i);
            if(child != n - 1 && a[child].compareTo(a[child  + 1]) < 0){
                child ++;
            }
            if(temp.compareTo(a[child]) < 0){
                a[i] = a[child];
            }else{
                break;
            }
        }
        a[i] = temp;
    }

    private void swapReferences(T[] a, int m, int n){
        T item = a[m];
        a[m] = a[n];
        a[n] = item;
    }
}
