package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: jinsheng.wei
 * @Description:
 */
public class StringToInteger {

    public static void main(String[] args) {
        String s = "42";
        String s2 = "   -42";
        String s3 = "4193 with words";
        String s4 = "words and 798";
        String s5 = "-91283472332";
        String s6 = "3.1487";
        String s7 = "  0000000000012345678";
        String s8 = "+-2";
        String s9 = "9223372036854775808";
        String s10 = "-5-";
        String s11 = "1";
        String s12 = "  -0012a42";
        String s13 = "   +0 123";
        String s14 = "     +004500";
        String s15 = "10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000522545459";
        String s16 = "-000000000000001";

        System.out.println(myAtoi(s));
        System.out.println(myAtoi(s2));
        System.out.println(myAtoi(s3));
        System.out.println(myAtoi(s4));
        System.out.println(myAtoi(s5));
        System.out.println(myAtoi(s6));
        System.out.println(myAtoi(s7));
        System.out.println(myAtoi(s8));
        System.out.println(myAtoi(s9));
        System.out.println(myAtoi(s10));
        System.out.println(myAtoi(s11));
        System.out.println(myAtoi(s12));
        System.out.println(myAtoi(s13));
        System.out.println(myAtoi(s14));
        System.out.println(myAtoi(s15));
        System.out.println(myAtoi(s16));
    }

    public static int myAtoi(String str) {
        if (str == null || str.trim().equals("")) {
            return 0;
        }

        List<Character> numericalList = new ArrayList<Character>() {{
            add('1');
            add('2');
            add('3');
            add('4');
            add('5');
            add('6');
            add('7');
            add('8');
            add('9');
            add('0');
        }};

        List<Character> operateList = new ArrayList<Character>() {{
            add('+');
            add('-');
        }};

        str = str.replaceAll(" ", ",");
        StringBuilder sb = new StringBuilder();
        boolean haveStop = false;
        for (int i = 0; i < str.length(); i++) {
            char val = str.charAt(i);
            if(val == ',' ){
                if(sb.length() == 0){
                    continue;
                }
                break;
            }

            // 首字母处理
            if(sb.length() < 1){
                if(!numericalList.contains(val) && !operateList.contains(val)){
                    haveStop = true;
                }else{
                    sb.append(val);
                }
            }else{
                if(!numericalList.contains(val)){
                    haveStop = true;
                }else{
                    sb.append(val);
                }
            }

            if(haveStop)
                break;
        }

        if(sb.length() == 0)
            return 0;

        // 过滤掉无效 的0 字符
        int deleteIndx = 0;
        if(operateList.contains(sb.toString().charAt(0))){
            deleteIndx = 1;
        }
       while (sb.length() > deleteIndx){
           if(sb.indexOf("0") == deleteIndx || sb.indexOf(",") == deleteIndx){
               sb.deleteCharAt(deleteIndx);
           }else{
               break;
           }
       }

        if(sb.length() == 0)
            return 0;

        String numStr = sb.toString();
        long number = 0L, multiple = 1, intMaxAbs = 2147483648L;
        for (int i = numStr.length() - 1; i >= 0; i--) {
            char val = numStr.charAt(i);
            if (i != 0 && !numericalList.contains(val)) {
                number = 0L;
                multiple = 1;
                continue;
            }

            if (numericalList.contains(val)) {
                int itemVal = val - '0';
                number += multiple * itemVal;
                multiple *= 10;
            }

            if (number >= intMaxAbs || multiple/10 >= intMaxAbs) {
                number = intMaxAbs;
                break;
            }
        }

        if (numStr.charAt(0) == '-') {
            number = 0 - number;
        }

        if (number > Integer.MAX_VALUE) {
            number = Integer.MAX_VALUE;
        }

        if (number < Integer.MIN_VALUE) {
            number = Integer.MIN_VALUE;
        }

        return (int) number;
    }
}
