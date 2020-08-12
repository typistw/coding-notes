package com.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class ZigZigConversion {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        String s2 = "AB";
        System.out.println(convert(s, 3));
        System.out.println(convert(s, 4));
        System.out.println(convert(s2, 1));
        System.out.println(convert(s2, 3));
    }

    public static String convert(String s, int numRows) {
        if(s == null || s.equals("") || s.length() <= 1){
            return s;
        }

        Map<Integer, List<Character>> map = new HashMap<>();
        int rowIndex = 1;
        char operate = '+';
        for(int  i = 0; i < s.length(); i++){
            if(map.containsKey(rowIndex)){
                map.get(rowIndex).add(s.charAt(i));
            }else{
                List<Character> list = new LinkedList<>();
                list.add(s.charAt(i));
                map.put(rowIndex, list);
            }

            if(numRows == 1){
                operate = '/';
            }else if(rowIndex == 1){
                operate = '+';
            }else if(rowIndex == numRows){
                operate = '-';
            }

            switch (operate){
                case '+':
                    rowIndex ++;
                    break;
                case '-':
                    rowIndex --;
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= numRows; i++){
            List<Character> rowList = map.get(i);
            if(rowList != null && !rowList.isEmpty()){
                for(Character item : rowList){
                    sb.append(item);
                }
            }
        }
        return sb.toString();
    }
}
