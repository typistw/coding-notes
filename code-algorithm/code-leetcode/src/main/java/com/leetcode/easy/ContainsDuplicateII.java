package com.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/*
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 *
 * @author：jinsheng
 */
public class ContainsDuplicateII {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1} ,  nums2 = {1,0,1,1} , nums3 = {1,2,3,1,2,3};
        int k = 3, k2 = 1, k3 = 2 ;
        System.out.println(containsNearbyDuplicate(nums, k) + " : " + containsNearbyDuplicateTwo(nums, k));
        System.out.println(containsNearbyDuplicate(nums2, k2) + " : " + containsNearbyDuplicateTwo(nums2, k2));
        System.out.println(containsNearbyDuplicate(nums3, k3) + " : " + containsNearbyDuplicateTwo(nums3, k3));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    int distance = j - i;
                    if(distance <= k){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean containsNearbyDuplicateTwo(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            // remove element if its distance to nums[i] is not lesser than k.
            if(i > k){
                set.remove(nums[i - k -1]);
            }

            // //because all still existed elements is closer than k distance to the num[i], therefore if the add() return false,
            // it means there's a same value element already existed within the distance k, therefore return true.
            if(!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }

}
