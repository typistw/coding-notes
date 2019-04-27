package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @author：jinsheng
 * @date：2019/04/15 22:38
 */
public class PalindromeNumber {
    /**
     * 描述：
     *      一个整数位回为文数的定义：正读、倒叙读都为同一个数
     * example 1:
     *      input: 121
     *      output: true
     * example 2:
     *      input: -121
     *      output: false
     * example 3:
     *      input: 10
     *      output: false
     * 思考：
     *      考虑在没有把数字转字符串的情况下解决这个问题
     * @param args
     */
    public static void main(String[] args) {
        int ex = 121, ex2 = -121, ex3 = 10;
        System.out.println(isPalindromeByString(ex) + " " + isPalindromeByString(ex2) + " " + isPalindromeByString(ex3));
        System.out.println(isPalindrome(ex) + " " + isPalindrome(ex2) + " " + isPalindrome(ex3));
    }

    private static boolean isPalindrome(int x){
        if(x < 0)
            return false;
        if(x == 0)
            return true;

        List<Integer> list = new ArrayList<>();
        while (x > 0){
            int temp = x % 10;
            list.add(temp);
            x = x /10;
        }
        int begin = 0, end = list.size() - 1;
        boolean isPalindrome = true;
        while (begin < end){
            if(list.get(begin).equals(list.get(end)) ){
                begin ++;
                end --;
                continue;
            }

            isPalindrome = false;
            break;
        }
        return  isPalindrome;
    }

    private static boolean isPalindromeByString(int x){
        if(x < 0)
            return false;
        if(x == 0)
            return true;

        char[] chars = String.valueOf(x).toCharArray();
        int beging = 0;
        int end = chars.length - 1;
        boolean isPalindrome = true;
        while (beging < end){
            if(chars[beging] == chars[end]){
                beging ++;
                end --;
                continue;
            }
            isPalindrome = false;
            break;
        }
        return isPalindrome;
    }
}
