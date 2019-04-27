package com.leetcode;

/*
 * @author：jinsheng
 * @date：2019/04/15 23:21
 */
public class RomanToInteger {

    /**
     * 问题描述：
     *      罗马数字被以下不同的符号代替：I,V,X,L,C,D,M.
     *
     *      字符      值
     *      I         1
     *      V         5
     *      X         10
     *      L         50
     *      C         100
     *      D         500
     *      M         1000
     *
     *      例如，2 的罗马数写做 II，两个 1 加起来。12 写做 XII, 简单的 X + II; 27 写做 XXVII, XX + V + II。
     *      罗马数字通常写法为从左到右由大到小，然而 4 的写法不是 IIII， 想法写做 IV，应为1在5前面减去1就等于4，同样的规则也适于9，写做 IX。
     *
     *      减法使用的六个例子：
     *      I 可以适用在 V(5) 和 X(10) 的前面 表示4和9
     *      X 可以适用在 L(50) 和 C(100) 的前面 表示40和90
     *      C 可以适用在 D(500) 和 M(1000) 的前面 表示400和900
     *
     *      给定一个罗马数字，转换为一个整数，确保输入的罗马数字大小在1到3999之间
     *
     * 例子 1：
     *      input: III
     *      output: 3
     * 例子 2：
     *      input: IV
     *      output: 4
     * 例子 3：
     *      input: IX
     *      output: 9
     * 例子 4：
     *      input： LVIII
     *      output: 58
     *      explanation: L = 50, V = 5, III = 3
     * 例子 5：
     *      input: MCMXCIV
     *      output: 1994
     *      explanation: M = 1000, CM = 900, XC = 90, IV = 4
     *
     *      * @param args
     */
    public static void main(String[] args) {
        String ex = "II", ex2 = "IV", ex3 = "IX", ex4 = "LVIII", ex5 = "MCMXCIV";
        System.out.println(romanToInt(ex) + " " + romanToInt(ex2) + " " + romanToInt(ex3) + " " + romanToInt(ex4) + " " + romanToInt(ex5));
    }

    private static int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int sum = getNumber(Character.toString(chars[chars.length-1]));
        for(int i = 0 ; i < chars.length - 1; i ++){
            String str = Character.toString(chars[i]);
            String str2 = Character.toString(chars[i + 1]);
            // 左边大于等于右边加，否则减
            if(getNumber(str) >= getNumber(str2))
                sum += getNumber(str);
            else
                sum -= getNumber(str);

        }
        return  sum;
    }

    private static int getNumber(String ch){
        switch (ch){
            case "I": return 1;
            case "V": return 5;
            case "X": return 10;
            case "L": return 50;
            case "C": return 100;
            case "D": return 500;
            case "M": return 1000;
        }
        return  0;
    }

}
