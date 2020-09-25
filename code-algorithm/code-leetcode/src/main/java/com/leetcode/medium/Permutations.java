package com.leetcode.medium;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class Permutations {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(JSON.toJSONString(permute(nums)));
    }

    private static List<List<Integer>> list;
    public static List<List<Integer>> permute(int[] nums) {
        list = new ArrayList<>();
        backTrack(nums, new ArrayList<>());
        return list;
    }

    private static void backTrack(int[] nums, List<Integer> tempList){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(tempList.contains(nums[i]))
                continue;
            tempList.add(nums[i]);
            backTrack( nums, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }

}
