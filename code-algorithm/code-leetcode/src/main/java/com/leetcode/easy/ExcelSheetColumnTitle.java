package com.leetcode.easy;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * Example 1:
 *
 * Input: 1
 * Output: "A"
 * Example 2:
 *
 * Input: 28
 * Output: "AB"
 * Example 3:
 *
 * Input: 701
 * Output: "ZY"
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class ExcelSheetColumnTitle {

    public static void main(String[] args) {
        System.out.println(convertToTitle(26));
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(52));
        System.out.println(convertToTitle(701));
    }

    public static String convertToTitle(int n) {
        char[] baseArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
        'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        StringBuilder sb = new StringBuilder();
        while (n> 0 ){
            int index = (n-1)%26;
            sb.append(baseArray[index]);
            n = (n-1)/26;
        }
        return sb.reverse().toString();
    }
}
