package com.leetcode.easy;

import java.util.Arrays;

/*
 * Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example 1:

Input: [1,2,3,1]
Output: true
Example 2:

Input: [1,2,3,4]
Output: false
Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
 *
 * @author：jinsheng
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] num = {1 ,2 ,3,1};
        int[] num2 = {1 ,2 ,3,4};
        int[] num3 = {1 , 1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(num));
        System.out.println(containsDuplicate(num2));
        System.out.println(containsDuplicate(num3));
    }

    /**
     *  0^N = N
     *  N^N = 0
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            int ret = nums[i] ^ nums[i + 1];
            if( ret == 0){
                return true;
            }

        }
        return false;
    }

}
