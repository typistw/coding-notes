package com.leetcode.easy;

import com.alibaba.fastjson.JSON;

/**
 *Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 *
 *
 *
 * Example 1:
 *
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class SortArrayByParity {

    public static void main(String[] args) {
        int[] nums = {8,3, 1, 2,4};
        System.out.println(JSON.toJSONString(sortArrayByParity(nums)));
    }

    public  static int[] sortArrayByParity(int[] A) {
        if(A.length <= 1)
            return A;

        int left = 0, right = A.length - 1;

        while (left < right){
            int leftVal = A[left];
            int rightVal = A[right];
            if(leftVal % 2 == 0){
                left ++;
            }

            if(rightVal % 2 == 1){
                right --;
            }

            if(leftVal % 2 == 1 && rightVal % 2 == 0){
                A[left] = rightVal;
                A[right] = leftVal;
                left ++;
                right --;
            }
        }

        return A;
    }

}
