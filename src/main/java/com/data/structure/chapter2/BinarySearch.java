package com.data.structure.chapter2;

/**
 * Desc 二分查找
 *
 * @author weijinsheng
 * @date 2017/8/21 22:50
 */
public class BinarySearch {

    /**
     * O(logN)
     * X 不存在，返回-1
     * @param arr 有序数组
     * @param x 目标值
     * @param <T> 类型
     * @return
     */
    public static <T extends Comparable<? super T>>  int binarySearch(T arr[], T x){
        int low = 0, high = arr.length - 1;
        while (low <= high){
            int mid = (low + high) / 2;
            if(arr[mid].compareTo(x) < 0)
                low = mid + 1;
            else if(arr[mid].compareTo(x) > 0)
                high = mid - 1;
            else
                return mid;
        }
        return -1;
    }
}
