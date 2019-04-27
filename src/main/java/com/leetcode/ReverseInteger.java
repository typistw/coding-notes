package com.leetcode;

/*
 * @author：jinsheng
 * @date：2019/04/14 23:04
 */
public class ReverseInteger {

    /**
     * 问题描述：
     *      给定一个32位有符号数字，反转成另外一个数字
     * 例子 1：
     *      input: 123
     *      output: 321
     * 例子 2：
     *      input: -123
     *      output: 321
     * 例子 3：
     *      input: 120
     *      output: 21
     * 提示：
     *      假定运算的机器能存储的数字仅仅在32位有符号数据范围内: [-2^31, 2^31-1]，超过此范围返回 0 即可
     * @param args
     */
    public static void main(String[] args) {
//        int example = 123, example2 = -123, example3 = 1200;
//        System.out.println(reverse(example) + " " + reverse(example2) + " " + reverse(example3));
        int example = 1534236469, example2 = -2147483648, example3 = -2143847412;
        System.out.println(reverse(example) + " " + reverse(example2) + " " + reverse(example3));
    }

    private static int reverse(int x) {
        Long tempX = Long.valueOf(x);
        if (tempX == 0)
            return x;

        Integer sign = 1;
        if (tempX < 0) {
            sign = -1;
            tempX = tempX * sign;
        }

        String strX = String.valueOf(tempX);
        StringBuilder sb = new StringBuilder();
        char[] chs = strX.toCharArray();
        // 去掉输入数据末尾的零
        for (int i = chs.length - 1; i >= 0; i--) {
            if (sb.toString().equals("") && chs[i] == 0)
                continue;
            sb.append(chs[i]);
        }

        char[] chArray = sb.toString().toCharArray();
        Long multipe = sign.longValue();
        Long reverseX = 0L ;
        // 倒叙相加
        for (int i = chArray.length - 1; i >= 0; i--) {
            int temp = Integer.valueOf(Character.toString(chArray[i]));
            reverseX += multipe * temp;
            multipe *= 10;
            if (reverseX > Integer.MAX_VALUE  || reverseX < Integer.MIN_VALUE) {
                reverseX = 0L;
                break;
            }

        }
        return reverseX.intValue();
    }
}
