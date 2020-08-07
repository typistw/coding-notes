package com.leetcode.easy;

/**
 *  Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 *
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 *
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 4:
 *
 * Input: [1,3,5,6], 0
 * Output: 0
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = {1, 3,5,6};
        int val = 5, val2 = 2, val3 = 7, val4 = 0;

        System.out.println(searchInsert(nums, val));
        System.out.println(searchInsert(nums, val2));
        System.out.println(searchInsert(nums, val3));
        System.out.println(searchInsert(nums, val4));
    }

    public static int searchInsert(int[] nums, int target) {
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= target){
                index = i;
                break;
            }

            if(i == nums.length - 1){
                index = i + 1;
            }
        }
        return  index;
    }
}
