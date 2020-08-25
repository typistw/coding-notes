package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), for N > 1.
 * Given N, calculate F(N).
 *
 *
 *
 * Example 1:
 *
 * Input: 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * Example 2:
 *
 * Input: 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * Example 3:
 *
 * Input: 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 *
 * Note:
 *
 * 0 ≤ N ≤ 30.
 *
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class FibonacciNumber {

    public static void main(String[] args) {
        System.out.println(fib(10));
        System.out.println(fibByDP(10));
        System.out.println(fibByDPAndCut(10));
    }

    public static int fib(int N) {
        return fibByRecursion(N);
//        return fibByDP(N);
//        return  fibByDPAndCut(N);
    }

    /**
     *  递归
     * @param n
     * @return
     */
    public static int fibByRecursion(int n){
        if(n == 0)
            return 0;
        if(n == 1 || n == 2)
            return 1;
        return fibByRecursion(n-1) + fibByRecursion(n - 2);
    }

    /**
     *  动态规划
     * @param n
     * @return
     */
    public static int fibByDP(int n){
        List<Integer> baseList = new ArrayList<Integer>(){{
            add(0);
            add(1);
            add(1);
        }};

        if(baseList.size() > n){
            return baseList.get(n);
        }

        for(int i = baseList.size(); i <= n; i++){
            int sum = baseList.get(i - 1) + baseList.get(i - 2);
            baseList.add(sum);
        }

        return baseList.get(n);
    }

    /**
     *  动态 + 裁剪
     * @param n
     * @return
     */
    public static int fibByDPAndCut(int n){
        if(n == 0)
            return 0;

        int pre = 0, current = 1;
        for(int  i = 2; i <= n; i++){
            int sum = pre + current;
            pre = current;
            current = sum;
        }
        return  current;
    }

}
