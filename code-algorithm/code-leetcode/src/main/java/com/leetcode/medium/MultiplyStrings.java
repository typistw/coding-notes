package com.leetcode.medium;

/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 *
 * Example 1:
 *
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * Note:
 *
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class MultiplyStrings {

    public static void main(String[] args) {
        String num11 = "2", num12 = "3";
        String num21 = "123", num22 = "456";
        String num31 = "0", num32 = "0";
        System.out.println(multiply(num11, num12));
        System.out.println(multiply(num21, num22));
        System.out.println(multiply(num31, num32));
    }

    public static String multiply(String num1, String num2) {
        int[] baseDigit = new  int[200];
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        // 模拟 乘法过程
        for(int i = 0 ;i < chars1.length; i++){
            int a = chars1[i] - '0';
            for(int j = 0 ; j < chars2.length; j++){
                int countZero = j + i;
                int b = chars2[j] - '0';
                int product = a * b;
                handleBaseDigit(product, countZero, baseDigit);
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean hasStart = false;
        for(int i = 0; i < baseDigit.length; i++){
            if(baseDigit[i]  > 0 && !hasStart){
                hasStart = true;
            }

            if(hasStart){
                sb.append(baseDigit[i]);
            }
        }

        if(!hasStart)
            return "0";

        return sb.toString();
    }

    private static void handleBaseDigit(int numProduct, int countZero, int[] baseDigit){
        StringBuilder sb = new StringBuilder(String.valueOf(numProduct));
        while (countZero > 0){
            sb.append("0");
            countZero --;
        }

        int size = baseDigit.length - 1;
        int addOne = 0;
        String str = sb.reverse().toString();
        for(int i = 0 ; i < sb.length(); i++){
            int idx = size - i;
            int val = str.charAt(i) - '0';
            int num = baseDigit[idx] + addOne + val;

            addOne = num /10;
            num %= 10;
            baseDigit[idx] = num;
        }

        int indx = size - sb.length();
        while (addOne == 1 && indx > 0){
            int num = baseDigit[indx] + addOne;
            addOne = num / 10;
            num %= 10;
            baseDigit[indx] = num;
            indx --;
        }
    }

}
