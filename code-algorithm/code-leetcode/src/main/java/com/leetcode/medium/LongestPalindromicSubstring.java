package com.leetcode.medium;

/**
 *Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "babad";
        String s2 = "cbbd";
        String s3 = "ac";
        String s4 = "";
        String s5 = "ccc";
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindrome(s2));
        System.out.println(longestPalindrome(s3));
        System.out.println(longestPalindrome(s4));
        System.out.println(longestPalindrome(s5));
    }

    public static String longestPalindrome(String s) {
        if(s.equals("")){
            return "";
        }

        String maxSubStr = String.valueOf(s.charAt(0));
        for(int i = 0 ;i <s.length(); i++){
            int nexCharIndex = s.indexOf(s.charAt(i), i + 1);
            while (nexCharIndex > -1){
                String subStr = s.substring(i, nexCharIndex + 1);
                if(subStr.length() > maxSubStr.length()){
                    boolean hasPalindromic = true;
                    for(int k = 0, m = subStr.length() -1; k < m; k ++, m--){
                        if(subStr.charAt(k) != subStr.charAt(m)){
                            hasPalindromic = false;
                            break;
                        }
                    }

                    if(hasPalindromic){
                        maxSubStr = subStr;
                    }
                }
                nexCharIndex = s.indexOf(s.charAt(i), nexCharIndex + 1);
            }
        }

        return maxSubStr;
    }

}
