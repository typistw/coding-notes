package com.data.structure.chapter2;

/**
 * Desc  最大公因数
 *
 * @author weijinsheng
 * @date 2017/8/21 23:04
 */
public class MaxCommonFactor {

    /**
     * 欧几里得算法： 大数除以小数，连续计算余数直达余数为零为止，
     * 最后的非零余数就是最大公因数
     * @param a
     * @param b
     * @return
     */
    public static long gcd(long a, long b){
        long m, n;
        if(a > b){
            m = a;
            n = b;
        }else{
            m = b;
            n = a;
        }

        while ( n != 0){
            long rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }
}
