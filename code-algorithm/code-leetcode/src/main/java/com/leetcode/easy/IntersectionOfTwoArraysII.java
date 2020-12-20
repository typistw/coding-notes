package com.leetcode.easy;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 *  Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Note:
 *
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 *
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class IntersectionOfTwoArraysII {

    public static void main(String[] args) {
        int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
        System.out.println(JSON.toJSONString(intersect(nums1, nums2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> largeList ;

        boolean hasOneMaxTwo = nums1.length > nums2.length ? true : false;

        if(hasOneMaxTwo){
            largeList = arrayToList(nums1);
        }else {
            largeList = arrayToList(nums2);
        }

        List<Integer> retList;

        if(hasOneMaxTwo){
            retList = findIntersectValue(largeList, nums2);
        }else {
            retList = findIntersectValue(largeList, nums1);
        }

        int[] retArray = new int[retList.size()];
        for(int i = 0 ; i < retList.size(); i++){
            retArray[i] = retList.get(i);
        }
        return retArray;
    }

    private static List<Integer> arrayToList(int[] nums){
        List<Integer> tempList = new ArrayList<>();
        for(int i = 0 ;i < nums.length; i++){
            tempList.add(nums[i]);
        }
        return tempList;
    }

    private static List<Integer>  findIntersectValue(List<Integer> largeList,int[] nums){
        List<Integer> retList = new ArrayList<>();
        for(int i = 0 ; i < nums.length; i++){
            int value = nums[i];
            int index = largeList.indexOf(value);
            if(index != -1){
                largeList.remove(index);
                retList.add(value);
            }
        }
        return retList;
    }

}
