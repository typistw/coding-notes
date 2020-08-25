package com.leetcode.medium;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 *
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class SumIV {

    public static void main(String[] args) {
        int[] nums = {1, 0, -1,0,-2,2};
        System.out.println(JSON.toJSONString(fourSum(nums, 0)));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();
        if(nums == null || nums.length < 4){
            return new ArrayList<>(set);
        }

        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            int j = i + 1;
            while ( j < nums.length - 1){
                int left = j + 1, right = nums.length - 1;
                while (left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum > target){
                        right --;
                    }else if(sum < target){
                        left ++;
                    }else{
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        set.add(list);

                        right --;
                        left ++;
                    }
                }
                j ++;
            }

        }
        return new ArrayList<>(set);
    }

}
