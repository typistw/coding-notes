package com.leetcode.easy;

/**
 * Given an integer, write a function to determine if it is a power of two.
 *
 * Example 1:
 *
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 * Example 2:
 *
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 * Example 3:
 *
 * Input: 218
 * Output: false
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class PowerOfTwo {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(32));
        System.out.println(isPowerOfTwo(64));
        System.out.println(isPowerOfTwo(218));
        System.out.println(isPowerOfTwo(2147483647));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 1)
            return true;

        for (int i = 0; i < 31; i++) {
            int sum = (int) Math.pow(2, i);
            if (sum == n) {
                return true;
            }
            if(sum > n)
                break;
        }
        return false;
    }

}
