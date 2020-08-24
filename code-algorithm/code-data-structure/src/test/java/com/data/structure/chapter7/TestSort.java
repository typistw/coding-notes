package com.data.structure.chapter7;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/*
 * @author：jinsheng
 * @date：2020/08/22 10:29
 */
public class TestSort {

    @Test
    public  void testInsertionSort(){
        InsertionSort<Integer> insertionSort = new InsertionSort<>();
        Integer[] array = {34, 8, 84, 51, 32, 21};
        insertionSort.insertionSort(array);

        System.out.println(JSON.toJSONString(array));
    }

    @Test
    public void testShellSort(){
        ShellSort<Integer> shellSort = new ShellSort<>();
        Integer[] array = {81, 94, 11, 96, 12, 35, 17, 95, 28,58, 41, 75, 15};
        shellSort.shellSort(array);
        System.out.println(JSON.toJSONString(array));
    }

    @Test
    public void testHeapSort(){
        HeapSort<Integer> heapSort = new HeapSort<>();
        Integer[] array = {53,26,58,31,41,97,59};
        heapSort.heapSort(array);
        System.out.println(JSON.toJSONString(array));
    }

    @Test
    public void testMergeSort(){
        MergeSort<Integer> mergeSort  = new MergeSort<>();
        Integer[] array = {1,13,24,2,15,27,38};
        mergeSort.mergeSort(array);
        System.out.println(JSON.toJSONString(array));
    }

    @Test
    public void testQuickSort(){
        QuickSort<Integer> quickSort = new QuickSort<>();
        Integer[] array = {8,1,4,9,0,3,5,2,7,6};
        quickSort.quickSort(array);
        System.out.println(JSON.toJSONString(array));
    }
}
