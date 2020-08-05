package com.leetcode.easy;

/**
 * 描述：
 *      返回给定子字符串在目标串中第一次出现的位置， 若不存在返回 -1
 *
 *
 * Example 1:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 * 声明：
 *      当查找的字符窜为空时， 返回 0
 *
 * 规定参数：
 *      目标字符串和子字符串仅包含英文小写字母
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class ImplementStrstr {

    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
        String haystack2 = "aaaaa", needle2 = "bba";
        String haystack3 = "a", needle3 = "a";
        String haystack4 = "mississippi", needle4 = "issip";
        System.out.println(strStr(haystack, needle));
        System.out.println(strStr(haystack2, needle2));
        System.out.println(strStr(haystack3, needle3));
        System.out.println(strStr(haystack4, needle4));
    }

    private static int strStr(String haystack, String needle) {
        if (needle == null || needle.equals(""))
            return 0;

        int indexCount = 0, nextBeginSize=0;
        boolean hasResetBeginIndex = true;
        for(int i = 0; i < haystack.length(); i++){

            // 查找目标串中等于子串中第一个字符的下标， 作为下一次子串重头匹配时从目标串中开始的位置
            if(!hasResetBeginIndex && haystack.charAt(i) == needle.charAt(0)){
                nextBeginSize = i;
                hasResetBeginIndex = true;
            }

            if(haystack.charAt(i) == needle.charAt(indexCount)){
                indexCount ++;
            }else{
                indexCount = 0;
                if(hasResetBeginIndex){
                    i = nextBeginSize;
                    hasResetBeginIndex = false;
                }
            }

            if(indexCount == needle.length()){
                return nextBeginSize;
            }
        }

        return  -1;
    }
}
