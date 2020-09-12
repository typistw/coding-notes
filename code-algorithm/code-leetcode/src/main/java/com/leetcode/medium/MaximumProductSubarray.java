package com.leetcode.medium;

/*
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 * @author：jinsheng
 */
public class MaximumProductSubarray {

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        int[] nums2 = {-2,0,-1};
        int[] nums3 = {-4, -3};
        int[] nums4 = {-2, 3, -4};
        int[] nums5 = {2,-5,-2,-4,3};
        System.out.println(maxProduct(nums));
        System.out.println(maxProduct(nums2));
        System.out.println(maxProduct(nums3));
        System.out.println(maxProduct(nums4));
        System.out.println(maxProduct(nums5));
    }

    private static int retMax;
    public static int maxProduct(int[] nums) {
        retMax = Integer.MIN_VALUE;
         traverse(1, nums, nums[0]);
         return retMax;
    }

    private static  void traverse(int start, int[] nums, int product){
        retMax = Math.max(product, retMax);
        for(int i = start; i < nums.length; i++){
            product = product * nums[i];
            retMax = Math.max(retMax, product);
            if(i == nums.length -1){
                traverse(start + 1, nums, nums[start]);
            }
        }
    }
}
