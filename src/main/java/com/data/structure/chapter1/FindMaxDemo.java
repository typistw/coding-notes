package com.data.structure.chapter1;

import java.util.Comparator;

/**
 * Desc
 *
 * @author weijinsheng
 * @date 2017/8/20 17:43
 */
public class FindMaxDemo {

    /**
     * 最大值
     * @param arr
     * @param cmp
     * @param <AnyType>
     * @return
     */
    public static <AnyType> AnyType findMax(AnyType[] arr, Comparator<? super AnyType> cmp){
        int maxIndex = 0;
        for(int i = 0; i < arr.length; i++){
            if(cmp.compare(arr[i], arr[maxIndex])> 0){
                maxIndex = i;
            }
        }
        return  arr[maxIndex];
    }

}
