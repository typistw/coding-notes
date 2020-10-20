package com.leetcode.easy;

import com.alibaba.fastjson.JSON;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(JSON.toJSONString(nums));
    }

    public static void moveZeroes(int[] nums) {
        if(nums.length == 0)
            return;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                int n = i - 1;
                while (n >= 0 && nums[n] == 0){
                    nums[n] = nums[n + 1];
                    nums[n + 1] = 0;
                    n --;
                }
            }
        }
    }

}
