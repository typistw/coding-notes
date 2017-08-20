package com.data.structure.chapter2;

import org.junit.Before;
import org.junit.Test;

/**
 * Desc
 *
 * @author weijinsheng
 * @date 2017/8/20 18:10
 */
public class MaxSubsequenceSumTest {

    private int arr[];

    @Before
    public void initDate(){
        arr = new int[]{-100,67,-2,11,-4,13,-5,-2,8,-6,2,78,-67,23,12};
    }

    @Test
    public void testMaxSubSum1(){
        long start = System.currentTimeMillis();
        int maxSum = MaxSubsequenceSum.maxSubSum1(arr);
        long time = System.currentTimeMillis() - start;
        System.out.println("maxSubSum1 = " + maxSum + ", ms = " + time);
    }

    @Test
    public void testMaxSubSum2(){
        long start = System.currentTimeMillis();
        int maxSum = MaxSubsequenceSum.maxSubSum2(arr);
        long time = System.currentTimeMillis() - start;
        System.out.println("maxSubSum2 = " + maxSum + ", ms = " + time);
    }

    @Test
    public void testMaxSubSum3(){
        long start = System.currentTimeMillis();
        int maxSum = MaxSubsequenceSum.maxSubSum3(arr);
        long time = System.currentTimeMillis() - start;
        System.out.println("maxSubSum3 = " + maxSum + ", ms = " + time);
    }

    @Test
    public void testMaxSubSum4(){
        long start = System.currentTimeMillis();
        int maxSum = MaxSubsequenceSum.maxSubSum4(arr);
        long time = System.currentTimeMillis() - start;
        System.out.println("maxSubSum4 = " + maxSum + ", ms = " + time);
    }
}
