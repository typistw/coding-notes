package com.leetcode.easy;

import java.math.BigInteger;

/**
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 *
 * Example 1:
 *
 * Input: 4
 * Output: 2
 * Example 2:
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class Sqrt {

    public static void main(String[] args) {
        int x = 4;
        int x2 = 8;
        int x3 = 26;
        int x4 = 2147395600;
        System.out.println(mySqrt(x) + " : " + mySqrtByBinarySearch(x));
        System.out.println(mySqrt(x2) + " : " + mySqrtByBinarySearch(x2));
        System.out.println(mySqrt(x3) + " : " + mySqrtByBinarySearch(x3));
        System.out.println(mySqrt(x4) + " : " + mySqrtByBinarySearch(x4));
    }

    /**
     *  等差级数公式:  1 + 3 + 5 + ... + (2*n -1) = n^2;
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        int index = 0;
        long sum = 0;
        while (sum <= x){
            index ++;
            sum += 2 * index - 1;
        }

        return  index - 1;
    }

    public static int mySqrtByBinarySearch(int x){
        if(x <= 1)
            return 1;

        int  n = x >> 1;
        int top = x, buttom = 0;
        while (true){
            BigInteger sum = BigInteger.valueOf(n).multiply(BigInteger.valueOf(n));
            if(sum.longValue() > x){
                top = n;
                n -= (top- buttom) >> 1;
                if(n == top){
                    return n - 1;
                }
            }else if(sum.longValue() < x){
                buttom = n;
                n += (top - buttom) >> 1;
                if(n == top){
                    return  n;
                }
            }else {
                return  n;
            }
        }
    }

}
