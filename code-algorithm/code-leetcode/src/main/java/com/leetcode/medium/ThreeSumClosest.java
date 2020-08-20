package com.leetcode.medium;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int[] nums2 = {0, 1, 2};
        int[] nums3 = {1,2,5,10,11};

        System.out.println(threeSumClosest(nums, 1));
        System.out.println(threeSumClosest(nums2, 0));
        System.out.println(threeSumClosest(nums3, 12));
    }

    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3)
            return 0;

        Arrays.sort(nums);
        int closet = Integer.MAX_VALUE;
        boolean hasFind = false, hasInitCloset = false ;
        for (int i = 0; i < nums.length - 2; i++) {
            int leftIndex = i + 1;
            int rightIndex = nums.length - 1;

            while (leftIndex < rightIndex) {
                int sum = nums[leftIndex] + nums[rightIndex] + nums[i];
                if (sum == target) {
                    closet = target;
                    hasFind = true;
                    break;
                } else if (sum > target) {
                    rightIndex--;
                } else {
                    leftIndex++;
                }

                if(!hasInitCloset){
                    closet = sum;
                    hasInitCloset = true;
                }else{
                    int sumDistance = sum - target;
                    int oldClosetDistance = closet - target;
                    closet = Math.abs(sumDistance) < Math.abs(oldClosetDistance) ? sum :closet;
                }
            }

            if (hasFind)
                break;
        }

        return closet;
    }

}
