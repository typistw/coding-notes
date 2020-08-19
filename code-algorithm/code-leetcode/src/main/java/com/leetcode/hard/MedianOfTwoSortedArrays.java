package com.leetcode.hard;

/**
 * @Auther: jinsheng.wei
 * @Description:
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0)
            return Double.valueOf(0);

        int sumSize = nums1.length + nums2.length;
        int medianIndex = sumSize / 2, nums1MdianIndex = nums1.length / 2, nums2MedianIndex = nums2.length / 2;
        double medianVal = 0d;
        if(sumSize % 2 == 0){

        }else{
            if(nums1[nums1MdianIndex] < nums2[nums2MedianIndex]){

            }
        }

        return  medianVal;
    }


}
