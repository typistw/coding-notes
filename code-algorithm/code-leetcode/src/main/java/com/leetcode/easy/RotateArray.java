package com.leetcode.easy;

import com.alibaba.fastjson.JSON;

/*
 * Given an array, rotate the array to the right by k steps, where k is non-negative.

Follow up:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?


Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]


Constraints:

1 <= nums.length <= 2 * 10^4
It's guaranteed that nums[i] fits in a 32 bit-signed integer.
k >= 0
 *
 * @author：jinsheng
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
        System.out.println(JSON.toJSONString(nums));
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k == 0)
            return;

        int[] tempArr = new int[nums.length];
        int idx = 0;
        for( int i = nums.length - k; i < nums.length; i++){
            tempArr[idx ++] = nums[i];
        }

        for(int i = 0; i < nums.length - k; i++){
            tempArr[idx++] = nums[i];
        }

        for(int i = 0; i < tempArr.length; i++){
            nums[i] = tempArr[i];
        }
    }

}
