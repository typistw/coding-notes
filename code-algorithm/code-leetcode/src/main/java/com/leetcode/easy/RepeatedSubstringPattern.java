package com.leetcode.easy;

/**
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 *
 *
 *
 * Example 1:
 *
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 *
 * Input: "aba"
 * Output: False
 * Example 3:
 *
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class RepeatedSubstringPattern {

    public static void main(String[] args) {
        String s = "abab";
        String s2 = "aba";
        String s3 = "abcabcabcabc";
        String s4 = "abcabc";
        String s5 = "ababababab";
        System.out.println(repeatedSubstringPattern(s));
        System.out.println(repeatedSubstringPattern(s2));
        System.out.println(repeatedSubstringPattern(s3));
        System.out.println(repeatedSubstringPattern(s4));
        System.out.println(repeatedSubstringPattern(s5));
    }

    public static boolean repeatedSubstringPattern(String s) {
        if(s.length() == 1)
            return false;

        int loop = s.length() / 2;
        while (loop >= 1){
            String str  = s;
            if(s.length() % loop == 0){
                if(judgmentNSubStr(str, loop)){
                    return true;
                }
            }
            loop --;
        }
        return false;
    }

    private static boolean judgmentNSubStr(String s,  int n){
        int loop = s.length() / n;
        String tempStr = s.substring(0, n);
        while (loop > 0){
            String str = s.substring(0, n);
            if(!tempStr.equals(str)){
                return false;
            }
            s = s.substring(n);
            loop --;
        }

        return true;
    }

}
