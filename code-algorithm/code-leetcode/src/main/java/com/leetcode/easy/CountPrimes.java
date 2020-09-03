package com.leetcode.easy;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * Example:
 *
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class CountPrimes {

    public static void main(String[] args) {
        System.out.println(countPrimes(72));
    }

    public static int countPrimes(int n) {
        int count = 0;
        boolean[] notPrimes = new boolean[n];
        for(int i = 2; i < n; i++){
            if(!notPrimes[i]){
                count ++;
                for(int j = 2; i * j < n; j++){
                    notPrimes[i * j] = true;
                }
            }
        }
        return count;
    }

}
