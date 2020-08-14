package com.leetcode.easy;

import java.util.LinkedList;
import java.util.List;

/**
 *Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 *
 * Constraints:
 *
 * Each string consists only of '0' or '1' characters.
 * 1 <= a.length, b.length <= 10^4
 * Each string is either "0" or doesn't contain any leading zero.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class AddBinary {

    public static void main(String[] args) {
        String a = "11", b = "1";
        String a2 = "1010", b2 = "1011";
        String a3 = "1111", b3 = "1111";
        String a4 = "100", b4 = "110010";
        System.out.println(addBinary(a, b) + " : " + addBinaryTwo(a, b));
        System.out.println(addBinary(a2, b2) + " : " + addBinaryTwo(a2, b2));
        System.out.println(addBinary(a3, b3) + " : " + addBinaryTwo(a3, b3));
        System.out.println(addBinary(a4, b4) + " : " + addBinaryTwo(a4, b4)) ;
    }

    public static String addBinary(String a, String b) {
        int minSize = Math.min(a.length(), b.length());
        String itemA, itemB,subStr = null ;
        if(a.length() == b.length()){
            itemA = a;
            itemB = b;
        }else if(a.length() > b.length()){
            itemB = b;
            itemA = a.substring(a.length() - minSize);
            subStr = a.substring(0, a.length() - minSize);
        }else{
            itemA = a;
            itemB = b.substring(b.length() - minSize);
            subStr = b.substring(0, b.length() - minSize);
        }

        List<Character> list = new LinkedList<>();

        boolean hasAdvance = false;
        char zeroChar = '0', ontChar = '1';
        for(int i = minSize - 1; i >= 0; i--){
            int val = itemA.charAt(i) ;
            int val2 = itemB.charAt(i);

            if(val == zeroChar && val2 == zeroChar){
                if(hasAdvance){
                    list.add(ontChar);
                }else{
                    list.add(zeroChar);
                }
                hasAdvance = false;
            }else if(val ==  ontChar && val2 == ontChar){
                if(hasAdvance){
                    list.add(ontChar);
                }else{
                    list.add(zeroChar);
                }
                hasAdvance = true;
            }else{
                if(hasAdvance){
                    list.add(zeroChar);
                }else{
                    list.add(ontChar);
                    hasAdvance = false;
                }
            }
        }


        if(subStr != null){
            for(int i = subStr.length() - 1; i>= 0; i--){
                char val = subStr.charAt(i);
                if(val == zeroChar){
                    if(hasAdvance){
                        list.add(ontChar);
                    }else{
                        list.add(zeroChar);
                    }
                    hasAdvance = false;
                }else{
                    if(hasAdvance){
                        list.add(zeroChar);
                    }else{
                        list.add(ontChar);
                        hasAdvance= false;
                    }
                }
            }
        }

        if(hasAdvance){
            list.add(ontChar);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = list.size() - 1; i>=0; i--){
            sb.append(list.get(i));
        }
        return sb.toString();
    }


    public static String addBinaryTwo(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() -1;
        int currentVal = 0;
        while (i>= 0 || j>=0){
            int valA = i>=0 ? a.charAt(i) - '0' : 0;
            int valB = j>=0 ? b.charAt(j)- '0' : 0;

            int sum = valA + valB + currentVal;
            sb.append(sum%2);
            currentVal = sum/2;
            i--;
            j--;
        }

        if(currentVal == 1){
            sb.append(1);
        }
        return sb.reverse().toString();
    }

}
