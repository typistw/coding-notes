package com.leetcode.easy;

/*
 *Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *
 * @author：jinsheng
 * @date：2020/08/08 22:57
 */
public class MaxinumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums2 = {-2, 1};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray(nums2));
        System.out.println(maxSubArray2(nums));
        System.out.println(maxSubArray2(nums2));
    }

    public static int maxSubArray(int[] nums) {
        if(nums.length == 1)
            return nums[0];

        int max = nums[0], arraySum = nums[0];
        for(int i= 0, j = i+1; i < nums.length-1;){
            if(arraySum + nums[j] <= arraySum){
                max = max > arraySum ? max : arraySum;
            }

            arraySum += nums[j];
            if(j == nums.length - 1){
                max = max > arraySum ? max : arraySum;
                i++;
                arraySum = nums[i];
                j=i;
            }

            if(i == nums.length - 1){
                max = max > nums[i] ? max : nums[i];
            }

            j++;
        }
        return  max;
    }

    public static int maxSubArray2(int[] nums) {
        int maxNum = nums[0];
        int currentMax = 0;
        for(int i = 0; i < nums.length; i++){
            currentMax += nums[i];
            if(currentMax == 0 || nums[i] > currentMax){
                currentMax = nums[i];
            }
            maxNum = maxNum > currentMax ? maxNum : currentMax;
        }

        return maxNum;
    }

}
