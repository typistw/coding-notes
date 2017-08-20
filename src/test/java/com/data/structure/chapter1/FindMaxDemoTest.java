package com.data.structure.chapter1;

import org.junit.Test;

/**
 * Desc
 *
 * @author weijinsheng
 * @date 2017/8/20 17:55
 */
public class FindMaxDemoTest {

    @Test
    public void testFindMax(){
        String[] arr = {"ZEBRA", "alligator", "crocodile"};
        System.out.println(FindMaxDemo.findMax(arr, new CaseInsensitiveCompare()));
    }
}
