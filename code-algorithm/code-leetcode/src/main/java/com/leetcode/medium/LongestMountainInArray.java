package com.leetcode.medium;

/**
 * Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:
 *
 * B.length >= 3
 * There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * (Note that B could be any subarray of A, including the entire array A.)
 *
 * Given an array A of integers, return the length of the longest mountain.
 *
 * Return 0 if there is no mountain.
 *
 * Example 1:
 *
 * Input: [2,1,4,7,3,2,5]
 * Output: 5
 * Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
 * Example 2:
 *
 * Input: [2,2,2]
 * Output: 0
 * Explanation: There is no mountain.
 * Note:
 *
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * Follow up:
 *
 * Can you solve it using only one pass?
 * Can you solve it in O(1) space?
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class LongestMountainInArray {

    public static void main(String[] args) {
        int[] nums  = {2,1,4,7,3,2,5}, nums2 = {0,1,0}, nums3 = {0,1,2,3,4,5,4,3,2,1,0};
        System.out.println(longestMountain(nums));
        System.out.println(longestMountain(nums2));
        System.out.println(longestMountain(nums3));
    }

    public static int longestMountain(int[] A) {
        if(A.length < 3)
            return 0;

        int manLength = 0;
        for(int i = 1 ; i < A.length - 1; i ++){
            if(A[i] > A[i -1] && A[i] > A[i + 1]){
                int low = i -1 , hight = i + 1;
                while (low - 1 >= 0){
                    if(A[low] > A[low - 1]){
                        low --;
                    }else {
                        break;
                    }
                }

                while (hight + 1 < A.length){
                    if(A[hight] > A[hight + 1]){
                        hight ++ ;
                    }else {
                        break;
                    }
                }

                manLength = Math.max(manLength, hight - low + 1);
            }

        }

       return manLength;
    }

}
