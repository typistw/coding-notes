package com.leetcode.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * Example 1:
 *
 * Input: "A"
 * Output: 1
 * Example 2:
 *
 * Input: "AB"
 * Output: 28
 * Example 3:
 *
 * Input: "ZY"
 * Output: 701
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 7
 * s consists only of uppercase English letters.
 * s is between "A" and "FXSHRXW".
 * @Auther: jinsheng.wei
 * @Description:
 */
public class ExcelSheetColumnNumber {

    public static void main(String[] args) {
        String s = "A";
        String s2 = "AB";
        String s3 = "ZZ";
        String s4 = "AAA";
        String s5= "ABA";

        System.out.println(titleToNumber(s));
        System.out.println(titleToNumber(s2));
        System.out.println(titleToNumber(s3));
        System.out.println(titleToNumber(s4));
        System.out.println(titleToNumber(s5));
    }

    public static int titleToNumber(String s) {
        Character[] baseChat = {'0', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
        'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        List<Character> list =new LinkedList<>();
        list.addAll(Arrays.asList(baseChat));

        int number = 0;
        for(int i = 0 ; i < s.length() ; i++){
            number += list.indexOf(s.charAt(i)) * getBaseSquare((s.length() - 1 - i)) ;
        }
        return  number;
    }

    private static int getBaseSquare(int n){
        int ret = 1;
        for(int i = 0; i < n; i++){
            ret *= 26;
        }
        return ret;
    }
}
