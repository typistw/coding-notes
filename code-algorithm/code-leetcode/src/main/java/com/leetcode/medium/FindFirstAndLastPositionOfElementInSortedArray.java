package com.leetcode.medium;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 *  Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * nums is a non decreasing array.
 * -10^9 <= target <= 10^9
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        int[] num = {5,7,7,8,8,10};
        System.out.println(JSON.toJSONString(searchRange(num, 8)));
        System.out.println(JSON.toJSONString(searchRange(num, 6)));

        int[] num2 = {1};
        System.out.println(JSON.toJSONString(searchRange(num2, 1)));

        int[] num3 = {3, 3, 3};
        System.out.println(JSON.toJSONString(searchRange(num3, 3)));

    }

    public static int[] searchRange(int[] nums, int target) {
        int begin = searchRange(nums, target, true);
        int end;
        if(begin == -1){
            end = -1;
        }else{
            end = searchRange(nums, target, false);
        }
        return  new int[]{begin, end};
    }

    /**
     *  边界查找：
     * @param nums
     * @param target
     * @param findLeft
     * @return
     */
    private static int searchRange(int[] nums, int target, boolean findLeft) {
        int left = 0, right = nums.length - 1;
        Set<Integer> idxSet = new TreeSet<>();

        while (left <= right){
            int mid = left + (right - left) / 2;
            int midVal = nums[mid];

            if(midVal == target){
                idxSet.add(mid);
                if(findLeft){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }

            }else if(midVal < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        if(idxSet.isEmpty()){
            return  -1;
        }

        if(findLeft){
            return  ((TreeSet<Integer>) idxSet).first();
        }else{
            return ((TreeSet<Integer>) idxSet).last();
        }
    }
}
