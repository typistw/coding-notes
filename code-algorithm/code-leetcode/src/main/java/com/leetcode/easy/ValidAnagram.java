package com.leetcode.easy;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class ValidAnagram {

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        String s2 = "cat", t2 = "atr";
        System.out.println(isAnagram(s, t));
        System.out.println(isAnagram(s2, t2));
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        int[] baseNum = new int[26];
        for(int i = 0; i < s.length(); i++){
            int idx = s.charAt(i) - 'a';
            baseNum[idx] += 1;
        }

        for(int i = 0; i < t.length(); i++){
            int idx = t.charAt(i) - 'a';
            baseNum[idx] -= 1;
            if(baseNum[idx] < 0)
                return false;
        }

        return true;
    }
}
