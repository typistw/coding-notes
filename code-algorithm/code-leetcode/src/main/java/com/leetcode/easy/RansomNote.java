package com.leetcode.easy;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 *
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 *
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 *
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 *
 *
 * Constraints:
 *
 * You may assume that both strings contain only lowercase letters.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class RansomNote {

    public static void main(String[] args) {
        String  ransomNote = "a", magazine = "b";
        String  ransomNote2 = "aa", magazine2 = "aab";
        System.out.println(canConstruct(ransomNote, magazine));
        System.out.println(canConstruct(ransomNote2, magazine2));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] array = new int[26];
        for(int i = 0 ;i < magazine.length(); i++){
            int idx = magazine.charAt(i) - 'a';
            array[idx] += 1;
        }

        for(int i = 0; i < ransomNote.length(); i++){
            int idx = ransomNote.charAt(i) - 'a';
            if(array[idx] == 0)
                return false;

            array[idx] -= 1;
        }

        return true;
    }
}
