package com.leetcode.medium;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 *  Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 *
 * Constraints:
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * Each element of candidate is unique.
 * 1 <= target <= 500
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7}, candidates2 = {2,3,5};
        int target = 7, target2 = 8;
        System.out.println(JSON.toJSONString(combinationSum(candidates, target)));
        System.out.println(JSON.toJSONString(combinationSum(candidates2, target2)));
    }

    private static List<List<Integer>> retList = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        retList.clear();
        if(candidates.length == 0)
            return retList;
        backTrack(0, candidates, new ArrayList<>(), target);
        return retList;
    }

    private static void backTrack(int start, int[] candidates, List<Integer> list, int target){
        if(target < 0)
            return;

        if(target == 0){
            retList.add(new ArrayList<>(list));
        }

        for(int i = start; i < candidates.length; i++){
            list.add(candidates[i]);
            backTrack(i, candidates, list, target - candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}
