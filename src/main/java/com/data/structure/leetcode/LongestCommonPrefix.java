package com.data.structure.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @author：jinsheng
 * @date：2019/04/17 23:24
 */
public class LongestCommonPrefix {
    /**
     * 描述：
     *      编写一个方法找出字符串数组中字符串的最长公共前缀，若不存在，返回一个空字符串("")
     *  例子 1：
     *      input: ["flower","flow","flight"]
     *      output: "fl"
     *  例子 2：
     *      input: ["flower","flow","flight"]
     *      output: ""
     *  提示：
     *      所有输入的字符在小a-z之间ß
     * @param args
     */
    public static void main(String[] args) {
        String[] ex = {"flower","flow","flight"}, ex2 = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(ex) + " " + longestCommonPrefix(ex2));
    }

    private static String longestCommonPrefix(String[] strs){
        if(null == strs || strs.length == 0)
            return "";

        // 已第一个字符串作为基础前缀字数据，拆解成单个字符
        List<Character> charList = stringConvertCharacterList(strs[0]);
        boolean hasCommonPrefix = true;

        for(int i = 1; i < strs.length; i ++){
            List<Character> tempList = stringConvertCharacterList(strs[i]);
            // 较短链表作为下标上限
            int size = charList.size() < tempList.size() ? charList.size() : tempList.size();
            charList = charList.subList(0, size);

            for(int j = 0; j < size; j ++){
                // 若不相等， 则减小charList长度为 0 ～ j-1
                if(!charList.get(j).equals(tempList.get(j))){
                    // 第一个不相等， 说明无共同前缀
                    if(j == 0){
                        hasCommonPrefix = false;
                        charList.clear();
                    }else{
                        charList = charList.subList(0, j);
                    }
                    break;
                }
            }

            if(!hasCommonPrefix)
                break;
        }

        if(charList.isEmpty()) {
            return "";
        } else{
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < charList.size(); i ++)
                sb.append(charList.get(i));
            return sb.toString();
        }
    }

    private static List<Character> stringConvertCharacterList(String str){
        char[] chars = str.toCharArray();
        List<Character> list = new ArrayList<>();
        for(int i = 0; i < chars.length; i ++){
            list.add(chars[i]);
        }
        return list;
    }
}
