package com.leetcode.easy;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a maximal substring consisting of non-space characters only.
 *
 * Example:
 *
 * Input: "Hello World"
 * Output: 5
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        String s = " ";
        String s2 = "     ";
        System.out.println(lengthOfLastWord(s));
        System.out.println(lengthOfLastWord(s2));
    }

    public static int lengthOfLastWord(String s) {
        if(!s.contains(" ")){
            return 0;
        }

        String[] array = s.split(" ");
        if(array.length == 0)
            return 0;
        return array[array.length - 1].length();
    }
}
