package com.leetcode.easy;

import java.util.Arrays;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {-1,1,1,1,2,1};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int moreThanSize = nums.length / 2;
        int currentVal = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            int itemVal = nums[i];
            if(itemVal == currentVal){
                count++;
                if(count > moreThanSize){
                    break;
                }
            }else{
                currentVal = nums[i];
                count = 1;
            }
        }
        return currentVal;
    }

    public static int majorityElementTwo(int[] nums) {
        Arrays.sort(nums);
        int moreThanSize = nums.length / 2;
        return nums[moreThanSize];
    }
}
