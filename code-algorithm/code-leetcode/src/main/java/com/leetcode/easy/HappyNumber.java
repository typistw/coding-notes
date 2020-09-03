package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Write an algorithm to determine if a number n is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * Return True if n is a happy number, and False if not.
 *
 * Example:
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappy(1));
    }

    public static  boolean isHappy(int n) {
        List<Integer> sumList = new ArrayList<>();
        sumList.add(n);
        List<Integer> digitList = new ArrayList<>();
        boolean isHappy = false;
        while (true){
            digitList.clear();
            while (n != 0){
                int digit = n % 10;
                n /= 10;
                digitList.add(digit);
            }
            int sum = 0;
            for(Integer item : digitList){
                sum += item * item;
            }

            if(sum == 1){
                isHappy = true;
                break;
            }

            if(sumList.contains(sum)){
                break;
            }

            sumList.add(sum);
            n = sum;
        }
        return  isHappy;
    }

}
