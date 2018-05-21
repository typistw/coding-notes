package com.data.structure.algorithm;

import java.util.Arrays;

/**
 *  交换排序
 * @author weijinsheng
 * @date 2018/5/21 22:35
 */
public class SwapSort {

    public static void main(String[] args) {
        int[] array = {3,6,1,2,54,38};
        bubbleSort(array);
        quickSort(array);
    }

    /**
     *  1.冒泡排序
     * 原理：比较两个相邻的元素，将值大的元素交换至右端。
       思路：依次比较相邻的两个数，将小数放在前面，大数放在后面。即在第一趟：首先比较第1个和第2个数，将小数放前，大数放后。然后
        比较第2个数和第3个数，将小数放前，大数放后，如此继续，直至比较最后两个数，将小数放前，大数放后。重复第一趟步骤，直至全部
        排序完
     */
    public static void bubbleSort(int ...array) {
        for(int i = 0; i < array.length - 1; i ++){
            // 每进行一次，就有一个数已排好，不用搭理， 故 -i
            for(int j = 0; j < array.length -1 - i; j++){
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println("bubbleSort:");
        Arrays.stream(array).forEach(index ->{
            System.out.print(index + " ");
        });
        System.out.println();

    }

    /**
     * 2.快速排序
     * 选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，将待排序列分成两部分,一部分比基准元素小,
     * 一部分大于等于基准元素,此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分
     * @param array
     */
    public static void quickSort(int ...array){
        if(array.length > 0){
            array = quickSort(array, 0, array.length -1);
            System.out.println("quickSort:");
            Arrays.stream(array).forEach(value ->{
                System.out.print(value + " ");
            });
            System.out.println();
        }
    }

    private static int[] quickSort(int[] a, int low, int high){
        if(low < high){
            int middle = getMiddle(a, low, high);
            quickSort(a, 0, middle - 1);
            quickSort(a, middle + 1, high);
        }
        return a;
    }

    private static int getMiddle(int a[], int low, int high){
        int temp = a[low];
        if(low < high){
            // 找到比基准元素小的元素位置
            while (low < high && a[high] >= temp){
                high --;
            }
            a[low] = a[high];

            //找到比基准元素大的元素位置
            while (low < high && a[low] <= temp){
                low ++;
            }
            a[high] = a[low];
        }
        // 基准元素在恰当的位置
        a[low] = temp;
        return low;
    }

}
