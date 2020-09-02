package com.leetcode.medium;

/**
 * Given an integer array nums sorted in ascending order, and an integer target.
 *
 * Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You should search for target in nums and if you found return its index, otherwise return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 *
 * Input: nums = [1], target = 0
 * Output: -1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * All values of nums are unique.
 * nums is guranteed to be rotated at some pivot.
 * -10^4 <= target <= 10^4
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int[] nums2 = {1};
        int[] nums3 = {3, 1};
        System.out.println(search(nums, 0));
        System.out.println(search(nums, 3));
        System.out.println(search(nums2, 0));
        System.out.println(search(nums3, 1));
    }

    public static int search(int[] nums, int target) {
       int left = 0, right = nums.length - 1;
       while (left <= right){
           int mid = left + (right - left) / 2;
           if(nums[mid] == target){
                return mid;
           }

           // if left half is sorted
           if(nums[left] <= nums[mid]){
               // if key present is left half
               if(nums[left] <= target && target < nums[mid]){
                   right = mid - 1;
               } else{
                   // is key is not left half, search the right half
                   left = mid + 1;
               }
           }else{
                // if right half is sorted
               if(nums[mid] < target && target <= nums[right]){
                   // if key present right half
                   left = mid + 1;
               }else{
                   // if key is not present right half, search the left half
                   right = mid - 1;
               }
           }
       }

       return  -1;
    }

}
