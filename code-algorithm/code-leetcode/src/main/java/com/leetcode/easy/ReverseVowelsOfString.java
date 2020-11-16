package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 *
 * Input: "hello"
 * Output: "holle"
 * Example 2:
 *
 * Input: "leetcode"
 * Output: "leotcede"
 * Note:
 * The vowels does not include the letter "y".
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class ReverseVowelsOfString {

    public static void main(String[] args) {
        String str = "hello", str2 = "leetcode";
        System.out.println(reverseVowels(str));
        System.out.println(reverseVowels(str2));
    }

    public static String reverseVowels(String s) {
        if (s == null || s.equals(""))
            return s;
        int left = 0;
        int right = s.length() - 1;
        List<Character> vowelList = new ArrayList<Character>() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
            add('A');
            add('E');
            add('I');
            add('O');
            add('U');
        }};

        char[] chars = s.toCharArray();
        while ( left < right) {
            char leftChar = chars[left];
            char rightChar = chars[right];
            if (vowelList.contains(leftChar) && vowelList.contains(rightChar)) {
                chars[left] = rightChar;
                chars[right] = leftChar;
                left ++;
                right --;
            } else {
                if (!vowelList.contains(chars[left])) {
                    left ++;
                }
                if (!vowelList.contains(chars[right])) {
                    right --;
                }
            }
        }

        return String.valueOf(chars);
    }

}
