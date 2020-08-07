package com.data.structure.chapter2;

import org.junit.Before;
import org.junit.Test;

/**
 * Desc
 *
 * @author weijinsheng
 * @date 2017/8/21 22:58
 */
public class BinarySearchTest {

    private Integer[] arr ;

    @Before
    public void initData(){
        arr = new Integer[]{-10,-2,3,5,6,8,10};
    }

    @Test
    public void testBinarySearch(){
        System.out.println(BinarySearch.binarySearch(arr, 6));
        System.out.println(BinarySearch.binarySearch(arr, 100));
    }
}
