package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 *Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 *
 * Example 1:
 *
 * Input: 3
 * Output: "III"
 * Example 2:
 *
 * Input: 4
 * Output: "IV"
 * Example 3:
 *
 * Input: 9
 * Output: "IX"
 * Example 4:
 *
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * Example 5:
 *
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class IntegerToRoman {

    public static void main(String[] args) {
        int num = 3;
        int num2 = 4;
        int num3 = 9;
        int num4 = 58;
        int num5 = 1994;

        System.out.println(intToRoman(num));
        System.out.println(intToRoman(num2));
        System.out.println(intToRoman(num3));
        System.out.println(intToRoman(num4));
        System.out.println(intToRoman(num5));
    }

    public static String intToRoman(int num) {
        Map<Integer,Character> map = new HashMap<>();
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');

        StringBuilder sb = new StringBuilder();
        int k = num/1000;
        while (k > 0){
            sb.append(map.get(1000));
            k --;
        }
        num = num%1000;

        int m = num/100;
        if(m > 0 && m < 4){
            while (m > 0){
                sb.append(map.get(100));
                m--;
            }
        }else if(m == 4){
            sb.append(map.get(100)).append(map.get(500));
        }else if(m == 5){
            sb.append(map.get(500));
        } else if(m > 5 && m < 9){
            sb.append(map.get(500));
            while (m > 5){
                sb.append(map.get(100));
                m --;
            }
        }else if(m == 9){
            sb.append(map.get(100)).append(map.get(1000));
        }
        num = num%100;

        int t = num/10;
        if(t > 0 && t < 4){
            while (t > 0){
                sb.append(map.get(10));
                t --;
            }
        }else  if(t == 4){
            sb.append(map.get(10)).append(map.get(50));
        }else if(t == 5){
            sb.append(map.get(50));
        }else  if(t >5 && t < 9){
            sb.append(map.get(50));
            while (t > 5){
                sb.append(map.get(10));
                t --;
            }
        }else if(t == 9){
            sb.append(map.get(10)).append(map.get(100));
        }

        int n = num%10;
        if(n < 4){
            while (n > 0){
                sb.append(map.get(1));
                n --;
            }
        }else  if(n == 4){
            sb.append(map.get(1)).append(map.get(5));
        }else  if(n == 5){
            sb.append(map.get(5));
        }else  if(n > 5 && n < 9){
            sb.append(map.get(5));
            while (n > 5){
                sb.append(map.get(1));
                n--;
            }
        }else  if(n == 9){
            sb.append(map.get(1)).append(map.get(10));
        }
        return sb.toString();
    }
}
