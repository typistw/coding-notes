package com.leetcode.easy;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * Example 1:
 *
 * Input: [3,0,1]
 * Output: 2
 * Example 2:
 *
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int[] array = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            array[nums[i]] = 1;
        }

        for(int i = 0; i < array.length; i++){
            if (array[i] == 0){
                return i;
            }
        }

        return 0;
    }
}
