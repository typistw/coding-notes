package com.leetcode.easy;

/**
 * Given an array of integers arr, return true if and only if it is a valid mountain array.
 *
 * Recall that arr is a mountain array if and only if:
 *
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < A[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 *
 *
 * Example 1:
 *
 * Input: arr = [2,1]
 * Output: false
 * Example 2:
 *
 * Input: arr = [3,5,5]
 * Output: false
 * Example 3:
 *
 * Input: arr = [0,3,2,1]
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 104
 * 0 <= arr[i] <= 104
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class ValidMountainArray {

    public static void main(String[] args) {
        int[] arr = {2, 1};
        int[] arr2 = {3, 5, 5};
        int[] arr3 = {0, 3, 2 ,1};
        int[] arr4 = {2, 0 ,2};
        System.out.println(validMountainArray(arr));
        System.out.println(validMountainArray(arr2));
        System.out.println(validMountainArray(arr3));
        System.out.println(validMountainArray(arr4));
    }

    public  static boolean validMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right){
            boolean hasBreak = true;
            if(arr[left] < arr[left + 1]){
                left ++;
                hasBreak = false;
            }else  if(arr[left] == arr[left + 1]){
                break;
            }

            if(arr[right] < arr[right - 1]){
                right --;
                hasBreak  =false;
            }else if(arr[right] == arr[right - 1]){
                break;
            }

            if(hasBreak)
                break;
        }

        if(left == 0 || right == arr.length - 1)
            return false;

        return left == right;
    }
}
