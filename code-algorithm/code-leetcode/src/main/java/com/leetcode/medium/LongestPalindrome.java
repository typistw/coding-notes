package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String str = "abccccdd";
        System.out.println(longestPalindrome(str));
    }

    public static int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap();
        for(int i = 0; i < s.length(); i++){
            char val = s.charAt(i);
            int count = 1;
            if(map.containsKey(val)){
                count += map.get(val);
            }
            map.put(val, count);
        }

        int oneCharMaxCount = 0;
        int combinationCharCount = 0;
        boolean hasAddOne = false;
        for(Character key : map.keySet()){
            int count = map.get(key);
            oneCharMaxCount = oneCharMaxCount > count ? oneCharMaxCount : count;
            if(count%2 == 0){
                combinationCharCount += count;
            }else{
                if(count == 1){
                    if(!hasAddOne){
                        combinationCharCount += count;
                        hasAddOne = true;
                    }
                }else{
                    combinationCharCount += count - 1;
                }
            }
        }

        return  oneCharMaxCount > combinationCharCount ? oneCharMaxCount : combinationCharCount;
    }

}
