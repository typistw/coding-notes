package com.leetcode.easy;

import java.util.Arrays;

/**
 * @Auther: jinsheng.wei
 * @Description:
 */
public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int[] nums2 = {2,7,9,3,1};
        System.out.println(rob(nums));
        System.out.println(rob(nums2));
    }

    public static int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo,-1);
        return rob(nums, memo, nums.length - 1);
    }

    private static int rob(int[] nums, int[] memo, int i){
        if(i < 0)
            return 0;

        if(memo[i] >= 0)
            return memo[i];

        int ret = Math.max(rob(nums, memo, i - 2) + nums[i], rob(nums, memo, i -1) );
        memo[i] = ret;
        return  ret;
    }

}
