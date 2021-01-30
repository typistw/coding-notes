package com.leetcode.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 *  Given two strings s and t, check if s is a subsequence of t.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the
characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false


Constraints:

0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.


Follow up: If there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see
if t has its subsequence. In this scenario, how would you change your code?
 *
 * @author：jinsheng
 */
public class IsSubsequence {

    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        String s2 = "axc", t2 = "ahbgdc";
        System.out.println(isSubsequence(s, t));
        System.out.println(isSubsequence(s2, t2));
    }

    public static boolean isSubsequence(String s, String t) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char var = t.charAt(i);
            if(map.containsKey(var)){
                map.get(var).add(i);
            }else{
                List<Integer> list = new LinkedList<>();
                list.add(i);
                map.put(var, list);
            }
        }

        int lastIdx = -1;
        for(int i = 0; i < s.length(); i ++){
            char var = s.charAt(i);
            if(!map.containsKey(var)){
                return false;
            }

            List<Integer> itemList = map.get(var);
            boolean hasFind  = false;
            while (!itemList.isEmpty()){
                int idxVal = itemList.get(0);
                itemList.remove(0);
                if(idxVal > lastIdx){
                    lastIdx = idxVal;
                    hasFind = true;
                    break;
                }
            }

            if(!hasFind){
                return false;
            }

            if(itemList.isEmpty()){
                map.remove(var);
            }
        }

        return true;
    }
}
