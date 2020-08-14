package com.leetcode.easy;

import com.alibaba.fastjson.JSON;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
 * Example:
 * <p>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * nums1.length == m + n
 * nums2.length == n
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 0, 0, 0}, num2 = {2,5,6};
        int m = 3, n = 3;
        merge(nums, m, num2, n);
        System.out.println(JSON.toJSONString(nums));
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int mIndex = m - 1, nIndex = n - 1;
        int k  = nums1.length - 1;
        while (mIndex >= 0 && nIndex >= 0){
            if(nums1[mIndex] > nums2[nIndex]){
                nums1[k--] = nums1[mIndex--];
            }else {
                nums1[k--] = nums2[nIndex--];
            }
        }

        while (nIndex >= 0){
            nums1[k--] = nums2[nIndex--];
        }

    }
}
