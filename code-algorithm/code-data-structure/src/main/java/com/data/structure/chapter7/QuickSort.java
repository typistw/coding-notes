package com.data.structure.chapter7;

/*
 * @author：jinsheng
 * @date：2020/08/24 22:54
 */
public class QuickSort<T extends Comparable<? super T>> {

    private int CUT_OFF = 10;

    public void quickSort(T[] a){
        quickSort(a, 0, a.length - 1);
    }

    private void quickSort(T[] a, int left, int right){
        if(left + CUT_OFF <= right){
            T pivot = median3(a, left, right);
            // begin partitioning
            int i = left, j = right - 1;
            for(;;){
                while (a[++i].compareTo(pivot) < 0){}
                while (a[--j].compareTo(pivot) > 0){}
                if(i < j){
                    swapReferences(a, i, j);
                }else {
                    break;
                }
            }

            // restore pivot
            swapReferences(a, i, right - 1);
            quickSort(a, left, i -1);
            quickSort(a, i + 1, right);
        }else{
            InsertionSort<T> sort = new InsertionSort<>();
            sort.insertionSort(a);
        }
    }

    /**
     * @param a
     * @param left
     * @param right
     * @param k the desired index (1 minimum) in the entire array.
     */
    private void quickSelect(T[] a, int left, int right, int k){
        InsertionSort<T> sort = new InsertionSort<>();
        if(left + CUT_OFF <= right){
            T pivot = median3(a, left, right);
            int i = left, j = right - 1;
            for(;;){
                while (a[++i].compareTo(pivot) < 0){}
                while (a[--j].compareTo(pivot) > 0){}
                if(i < j){
                    swapReferences(a, i, j);
                }else {
                    break;
                }
            }

            swapReferences(a, i, right - 1);
            if(k <= i){
                quickSelect(a, left, i -1, k);
            }else if( k > i + 1){
                quickSelect(a, i + 1,right, k);
            }else{
                sort.insertionSort(a);
            }
        }else {
            sort.insertionSort(a);
        }
    }

    /**
     *  三中位数分值法： 最小值分在a[left], 最大值分在a[right]
     * @param a
     * @param left
     * @param right
     * @return
     */
    private T median3(T[] a, int left, int right){
        int center = (left + right) / 2;
        if(a[center].compareTo(a[left]) < 0){
            swapReferences(a, center, left);
        }

        if(a[right].compareTo(a[left]) < 0){
            swapReferences(a, right, left);
        }

        if(a[right].compareTo(a[center]) < 0){
            swapReferences(a, right, center);
        }

        // place pivot at position right - 1
        return a[right - 1];
    }

    private void swapReferences(T[] a, int m, int n){
        T item = a[m];
        a[m] = a[n];
        a[n] = item;
    }
}
