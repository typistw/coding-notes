package com.leetcode.easy;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 *  Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note:
 *
 * Each element in the result must be unique.
 * The result can be in any order.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
       int[] nums1 = {1,2,2,1}, nums2 = {2,2};
        System.out.println(JSON.toJSONString(intersection(nums1, nums2)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i = 0; i < nums1.length; i++){
            set1.add(nums1[i]);
        }

        for(int i = 0; i < nums2.length; i++){
            set2.add(nums2[i]);
        }

        List<Integer> list = new ArrayList<>();
        for(int value : set1){
            if(set2.contains(value)){
                list.add(value);
            }
        }

        int[] retArray = new int[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            retArray[i] = list.get(i);
        }

        return retArray;
    }

}
