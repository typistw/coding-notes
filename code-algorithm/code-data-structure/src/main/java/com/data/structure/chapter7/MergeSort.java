package com.data.structure.chapter7;

/*
 * 归并排序
 *
 * @author：jinsheng
 * @date：2020/08/22 16:12
 */
public class MergeSort<T extends Comparable<? super T>> {

    public void mergeSort(T[] a){
        T[] tempArray = (T[]) new Comparable[a.length];
        mergeSort(a, tempArray, 0, a.length - 1);
    }

    private void mergeSort(T[] a, T[] tempArray, int left, int right){
        if (left < right){
            int middle = (left + right) / 2;
            mergeSort(a, tempArray, left, middle);
            mergeSort(a, tempArray, middle + 1, right);
            merge(a, tempArray, left, middle + 1, right);
        }
    }

    private void merge(T[] a , T[] tempArray, int leftPos, int rightPost, int rightEnd){
        int leftEnd = rightPost - 1;
        int temPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while (leftPos <= leftEnd && rightPost <= rightEnd){
            if(a[leftPos].compareTo(a[rightPost]) <= 0){
                tempArray[temPos ++] = a[leftPos ++];
            }else {
                tempArray[temPos ++] = a[rightPost ++];
            }
        }

        // copy rest of first half
        while (leftPos <= leftEnd){
            tempArray[temPos ++] = a[leftPos ++];
        }

        // copy rest of right half
        while (rightPost <= rightEnd){
            tempArray[temPos ++] = a[rightPost ++];
        }

        // copy tempArray back
        for(int i = 0; i < numElements; i++, rightEnd --){
            a[rightEnd] = tempArray[rightEnd];
        }
    }

}
