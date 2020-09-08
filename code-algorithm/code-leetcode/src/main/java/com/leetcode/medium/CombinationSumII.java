package com.leetcode.medium;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 *  Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class CombinationSumII {

    public static void main(String[] args) {
       int[] candidates = {10,1,2,7,6,1,5}, candidates2 = {2,5,2,1,2};
       int target = 8, target2 = 5;
        System.out.println(JSON.toJSONString(combinationSum2(candidates, target)));
        System.out.println(JSON.toJSONString(combinationSum2(candidates2, target2)));
    }

    private  static List<List<Integer>> retList = new ArrayList<>();
    public static  List<List<Integer>> combinationSum2(int[] candidates, int target) {
        retList.clear();
        if(candidates.length == 0)
            return retList;

        Arrays.sort(candidates);
        backTrack(0, candidates, new ArrayList<>(), target);
        return retList;
    }

    private static void backTrack(int start, int[] candidates, List<Integer> tempList, int target){
        if(target == 0){
            retList.add(new ArrayList<>(tempList));
        }

        for(int i = start; i < candidates.length; i++){
            if(target < 0)
                break;
            //剪枝：保证同一层中只有1个相同的元素，不同层可以有重复元素
            if(i > start && candidates[i] == candidates[i-1])
                continue;

            tempList.add(candidates[i]);
            backTrack(i + 1, candidates, tempList, target - candidates[i]);
            tempList.remove(tempList.size() - 1);
        }
    }

}
