package com.data.structure.chapter2;

/**
 * Desc 幂运算
 *
 * @author weijinsheng
 * @date 2017/8/21 23:14
 */
public class Pow {

    /**
     * 1.计算X^N明显使用N-1次乘法自乘
     * 2.递归： N<=1 为基本情形，若N为偶数,有 X^N = X^N/2 * X^N/2, 若N为奇数, X^N = X^(N-1)/2 * X^(N-1)/2 *x
     * 列： X^62
     * X^3=(X^2)*X, X^7=(X^3)^2*X, X^15=(X^7)^2*X，X^31=(X^15)^2*X, X^62=(X^31)^2
     * @param x
     * @param n
     * @return
     */
    public static long pow(long x, int n){
        if(n == 0)
            return 1;
        if(n == 1)
            return x;
        if(n%2 == 0)
            return pow(x * x, n/2);
        else
            return pow(x * x, n/2) * x;
    }

}

