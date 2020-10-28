package com.leetcode.easy;

/*
 * Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.



Example 1:

Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 *
 * @author：jinsheng
 */

import com.alibaba.fastjson.JSON;

public class ReverseString {

    public static void main(String[] args) {
        char[] strArr = {'h', 'e', 'l', 'l', 'o' };
        char[] strArr2 = {'H', 'a', 'n', 'n', 'a', 'h' };
        reverseString(strArr);
        reverseString(strArr2);
        System.out.println(JSON.toJSONString(strArr));
        System.out.println(JSON.toJSONString(strArr2));
    }

    public static void reverseString(char[] s) {
        int midIndex = s.length / 2;
        for (int i = 0; i < midIndex; i++) {
            int backIdx = s.length - 1 - i;
            char temp = s[i];
            s[i] = s[backIdx];
            s[backIdx] = temp;
        }
    }
}
