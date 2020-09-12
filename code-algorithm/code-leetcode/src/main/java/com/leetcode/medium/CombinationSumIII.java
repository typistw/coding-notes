package com.leetcode.medium;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/*
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * @author：jinsheng
 */
public class CombinationSumIII {

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(combinationSum3(3, 7)));
        System.out.println(JSON.toJSONString(combinationSum3(3, 9)));
    }

    private static List<List<Integer>> retList;
    public static  List<List<Integer>> combinationSum3(int k, int n) {
        retList = new ArrayList<>();
        int[] nums = {1,2,3,4,5,6,7,8,9};
        backTrack(k, n, 0, nums, new ArrayList<>(), 0);
        return retList;
    }

    private static void backTrack(int k, int n, int start,int[] nums, List<Integer> tempList, int sum){
        if(sum > n || tempList.size() > k)
            return;

        if(tempList.size() == k && sum == n){
            retList.add(new ArrayList(tempList));
            return;
        }

        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backTrack(k, n, i + 1, nums, tempList, sum + nums[i]);
            tempList.remove(tempList.size() - 1);
        }
    }
}
