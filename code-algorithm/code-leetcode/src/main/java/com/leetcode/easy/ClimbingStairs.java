package com.leetcode.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class ClimbingStairs {

   private static List<Integer> list = new LinkedList<Integer>(){{
       add(0);
       add(1);
       add(2);
    }};

    public static void main(String[] args) {
        int n = 4;
        System.out.println(climbStairs(n) + " : " + climbStairsTwo(n));
    }

    public static int climbStairs(int n) {
        for(int i = 3; i <= n; i++){
            int val = list.get(i - 1) + list.get(i - 2);
            list.add(val);
        }
        return  list.get(n);
    }

    public static int climbStairsTwo(int n){
        return count(n, new int[n + 1]);
    }

    private static int count(int n, int[] array){
        if(array[n] != 0){
            return array[n];
        }

        if(n <= 2){
            array[n] = n;
        }else{
            int sum = count(n - 1, array) + count(n - 2, array);
            array[n] = sum;
        }

        return array[n];
    }

}
