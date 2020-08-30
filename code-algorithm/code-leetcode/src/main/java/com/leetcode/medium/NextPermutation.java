package com.leetcode.medium;

import com.alibaba.fastjson.JSON;

/*
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 *
 * @author：jinsheng
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int[] nums2 = {3,2,1};
        int[] nums3 = {1,1,5};

        nextPermutation(nums);
        nextPermutation(nums2);
        nextPermutation(nums3);

        System.out.println(JSON.toJSONString(nums));
        System.out.println(JSON.toJSONString(nums2));
        System.out.println(JSON.toJSONString(nums3));
    }

    public static  void nextPermutation(int[] nums) {
        int n = nums.length - 1, p = -1, pv = 0;

        for(int i = n - 1; i >= 0; i--){
            if(nums[i] < nums[i + 1]) {
                p = i;
                pv = nums[i];
                break;
            }
        }

        if(p == -1) {
            reverse(nums, 0, n);
            return;
        }

        for(int i = n; i >= 0; i--){
            if(nums[i] > pv){
                swap(nums, p, i);
                break;
            }
        }

        reverse(nums, p + 1, n);
    }

    private static void reverse(int[] nums, int start, int end){
        for(int i = start, j = end; i < j; i++, j--){
            int tempVal = nums[i];
            nums[i] = nums[j];
            nums[j] = tempVal;
        }
    }

    private  static void swap(int[] nums, int s, int e){
        int t = nums[s];
        nums[s] = nums[e];
        nums[e] = t;
    }
}
