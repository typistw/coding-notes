package com.leetcode.easy;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Example 1:
 *
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * Example 2:
 *
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * Note: Your solution should be in logarithmic time complexity.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class FactorialTrailingZeroes {

    public static void main(String[] args) {
        System.out.println(trailingZeroes(30));
        System.out.println(trailingZeroes(95));
        System.out.println(trailingZeroes(1429));
        System.out.println(trailingZeroes(4383));
    }

    /**
     * TrailingZeroes is basically counting the number of factor 10.
     * 10 = 2 times 5
     * Because n is factorial, there are definitely much more 2 than 5. So we only need to count the number of 5 in given factorial n.
     * n = 5 -> 5 * 4 * 3 * 2 * 1 count = 5/5 + 0 = 1
     * n = 10 -> 10 * 9 * 8 * 7 * 6 * 5* 4 * 3 * 2 * 1. count = 10/5 + 0 = 2
     * n = 50 count = 50/5 + trailingZeroes(10) = 10 + 2 = 12
     * 50(two fives) 45 40 35 30 25(two fives) 20 15 10 5 -> 12 fives
     * n = 100 count = 100/5 + trailingZeroes(20) = 20 + 4 = 24
     *
     * @param n
     * @return
     */
    public static int trailingZeroes(int n) {
        int countZero = 0;
        while (n > 0){
            countZero += n / 5;
            n /= 5;
        }
       return countZero;
    }
}
