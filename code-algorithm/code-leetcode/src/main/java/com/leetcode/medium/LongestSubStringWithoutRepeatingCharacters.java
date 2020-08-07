package com.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class LongestSubStringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 = " ";
        String s5 = "au";
        String s6 = "aab";
        String s7 = "dvdf";
        String s8 = "qrsvbspk";


        System.out.println(lengthOfLongestSubstring(s) + " : " + lengthOfLongestSubstringBySlidingWindow(s));
        System.out.println(lengthOfLongestSubstring(s2)+ " : " + lengthOfLongestSubstringBySlidingWindow(s2));
        System.out.println(lengthOfLongestSubstring(s3)+ " : " + lengthOfLongestSubstringBySlidingWindow(s3));
        System.out.println(lengthOfLongestSubstring(s4)+ " : " + lengthOfLongestSubstringBySlidingWindow(s4));
        System.out.println(lengthOfLongestSubstring(s5)+ " : " + lengthOfLongestSubstringBySlidingWindow(s5));
        System.out.println(lengthOfLongestSubstring(s6)+ " : " + lengthOfLongestSubstringBySlidingWindow(s6));
        System.out.println(lengthOfLongestSubstring(s7)+ " : " + lengthOfLongestSubstringBySlidingWindow(s7));
        System.out.println(lengthOfLongestSubstring(s8)+ " : " + lengthOfLongestSubstringBySlidingWindow(s8));

    }

    /**
     *  扫描所有子字符串
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int nextBeginIndex = 0, maxSubLength = 0;
        List<Character> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            if(list.contains(s.charAt(i))){
                nextBeginIndex ++;
                if(list.size() > maxSubLength){
                    maxSubLength = list.size();
                }
                list.clear();
                i = nextBeginIndex - 1;
            }else{
                list.add(s.charAt(i));
            }

            if(i == s.length() - 1 && maxSubLength < list.size()){
                maxSubLength = list.size();
            }
        }
        return maxSubLength;
    }

    /**
     *  滑动窗口
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringBySlidingWindow(String s) {
        int subMaxLength = 0;
        List<Character> subList = new LinkedList<>();
        for(int i = 0 ; i < s.length(); i++){
            if(subList.contains(s.charAt(i))){
                subMaxLength = subList.size() > subMaxLength ? subList.size() : subMaxLength;
                boolean hasRemove = true;
                // 子字符串包含当前字符， 字符串中从头移除字符直到当前字符(包含)
                while (hasRemove){
                    if(s.charAt(i) == subList.get(0)){
                        hasRemove = false;
                    }
                    subList.remove(0);
                }
                subList.add(s.charAt(i));
            }else{
                subList.add(s.charAt(i));
            }
        }
        subMaxLength = subList.size() > subMaxLength ? subList.size() : subMaxLength;
        return subMaxLength;
    }


}
