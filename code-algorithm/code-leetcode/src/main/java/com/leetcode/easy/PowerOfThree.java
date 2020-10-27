package com.leetcode.easy;

/**
 * Given an integer, write a function to determine if it is a power of three.
 *
 * Example 1:
 *
 * Input: 27
 * Output: true
 * Example 2:
 *
 * Input: 0
 * Output: false
 * Example 3:
 *
 * Input: 9
 * Output: true
 * Example 4:
 *
 * Input: 45
 * Output: false
 * Follow up:
 * Could you do it without using any loop / recursion?
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class PowerOfThree {

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));
        System.out.println(isPowerOfThree(0));
        System.out.println(isPowerOfThree(9));
        System.out.println(isPowerOfThree(45));
        System.out.println(isPowerOfThree(1));
    }

    public static boolean isPowerOfThree(int n) {
        while (n >= 3 && n % 3 == 0){
            n /= 3;
        }
        return n == 1;
    }
}
