package com.leetcode.medium;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 *
 * A palindrome string is a string that reads the same backward as forward.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * Example 2:
 *
 * Input: s = "a"
 * Output: [["a"]]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 *
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(JSONObject.toJSON(partition(s)));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> retList = new ArrayList<>();
       int n = s.length();
       if(n == 0)
           return retList;

       backtrack(retList, new ArrayList<>(),s , 0, n );
       return retList;
    }

    private static void backtrack(List<List<String>> retList, List<String> list, String str ,int left, int right){
        if(left == right){
            retList.add(new ArrayList<>(list));
            return;
        }

        for(int i = left + 1 ;i <= right; i++){
            if(isPalindrome(str, left, i)){
                list.add(str.substring(left, i));
                backtrack(retList, list, str,i, right);
                list.remove(list.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int left, int right){
        if(left == right){
            return true;
        }
        while (left < right - 1 ){
            if(s.charAt(left) != s.charAt(right - 1)){
                return  false;
            }
            left++;
            right--;
        }
        return true;
    }

}
