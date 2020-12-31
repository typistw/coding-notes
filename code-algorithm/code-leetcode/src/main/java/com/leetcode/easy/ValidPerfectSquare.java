package com.leetcode.easy;

/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Follow up: Do not use any built-in library function such as sqrt.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 16
 * Output: true
 * Example 2:
 *
 * Input: num = 14
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= num <= 2^31 - 1
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class ValidPerfectSquare {

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(4));
        System.out.println(isPerfectSquare(9));
        System.out.println(isPerfectSquare(100));
        System.out.println(isPerfectSquare(122));
        System.out.println(isPerfectSquare(808201));
    }

    public static boolean isPerfectSquare(int num) {
        if(num == 1)
            return true;

        int left = 0, right = num / 2;
        while (true){
            int sum = right * right;
            if(sum < 0 || sum > num){
                right /= 2;
            }else {
                left = right;
                right *= 2;
                break;
            }
        }

        for(int i = left; i <= right; i++){
            int sum = i * i;
            if(sum == num){
                return true;
            }

            if(sum > num)
                break;;
        }

        return false;
    }

}
