package com.leetcode.medium;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example:
 *
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class PermutationsII {

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(JSON.toJSONString(permute(nums)));
    }

    public static List<List<Integer>> permute(int[] nums) {
        Set<List<Integer>>  set = new HashSet<>();
        boolean[] used  = new boolean[nums.length];
        backTrack(nums, new ArrayList<>(), used, set);
        return new ArrayList<>(set);
    }

    private static void backTrack(int[] nums, List<Integer> tempList, boolean[] used, Set<List<Integer>> set){
        if(tempList.size() == nums.length){
            set.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i])
                continue;

            tempList.add(nums[i]);
            used[i] = true;
            backTrack( nums, tempList, used, set);

            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }

}
