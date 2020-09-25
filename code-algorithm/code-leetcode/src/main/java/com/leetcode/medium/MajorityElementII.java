package com.leetcode.medium;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 *
 * Note: The algorithm should run in linear time and in O(1) space.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: [3]
 * Example 2:
 *
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class MajorityElementII {

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        int[] nums2 = {1,1,1,3,3,2,2,2};
        System.out.println(JSON.toJSONString(majorityElement(nums)));
        System.out.println(JSON.toJSONString(majorityElement(nums2)));
    }

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums.length == 0)
            return list;

        int countNum = nums.length / 3;
        Arrays.sort(nums);
        int tempVal = nums[0], count = 1;
        for(int i = 1; i < nums.length; i++){
            if(tempVal == nums[i]){
                count ++;
            }else{
                if(count > countNum){
                    list.add(tempVal);
                }
                count = 1;
                tempVal = nums[i];
            }
        }

        if(count > countNum){
            list.add(tempVal);
        }

        return list;
    }
}
