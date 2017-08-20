package com.data.structure.chapter2;

/**
 * Desc 最大子序列和
 * 若全为负数，则最大和为零
 * @author weijinsheng
 * @date 2017/8/20 18:02
 */
public class MaxSubsequenceSum {

    /**
     * O（N^3）
     * @param arr
     * @return
     */
    public static int maxSubSum1(int[] arr){
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++){
            for(int j = i; j < arr.length; j++){
                int thisSum = 0;
                for(int k = i; k <= j; k++){
                    thisSum += arr[k];
                }
                if(thisSum > maxSum)
                    maxSum = thisSum;
            }
        }
        return  maxSum;
    }

    /**
     * O(N^2)
     * @param arr
     * @return
     */
    public static int maxSubSum2(int[] arr){
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++){
            int thisSum = 0;
            for(int j = i; j < arr.length; j++){
                thisSum += arr[j];
                if(thisSum > maxSum)
                    maxSum = thisSum;
            }
        }
        return  maxSum;
    }

    /**
     * 分治策略
     * O(NlogN)
     * @param arr
     * @return
     */
    public static int maxSubSum3(int[] arr){
        return maxSumRec(arr, 0, arr.length - 1);
    }

    /**
     * O(N)
     * @param arr
     * @return
     */
    public static int maxSubSum4(int[] arr){
        int maxSum = 0, thisSum = 0;
        for(int i = 0; i < arr.length; i++){
            thisSum += arr[i];
            if(thisSum > maxSum)
                maxSum = thisSum;
            if(thisSum < 0)
                thisSum = 0; // base case
        }
        return maxSum;
    }

    /**
     * 分治策略 divide-and-conquer
     * 思路：把问题分成两个大致相等的问题，然后递归对它们进行求解
     * 列： 4 -3 5 -2 | -1 2 6 -2
     * 1.前半部分最大子序列和为6(A1到A3)，后半部分最大子序列和为8(A6到A7)
     * 2.前半部分包含最后一个值最大和为4(A1到A4)，后半部分包含第一个值最大和为7(A5到A7)，横跨两部分且通过中间的最大和为4+7=11(A1到A7)
     * 3.max3(maxLeft, maxRight, maxLeftBorder + maxRightBorder)
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int maxSumRec(int[] arr, int left, int right){
        if(left == right){
            if(arr[left] > 0)
                return arr[left];
            else
                return 0; // base case
        }

        int center = (left + right) / 2;
        int maxLeftSum = maxSumRec(arr, left, center);
        int maxRightSum = maxSumRec(arr, center + 1, right);

        //求左右边界最大值
        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for(int i = center; i >= left; i--){
            leftBorderSum += arr[i];
            if(leftBorderSum > maxLeftBorderSum)
                maxLeftBorderSum = leftBorderSum;
        }

        int maxRightBorderSum = 0, rightBorderSum = 0;
        for(int i = center + 1; i <= right; i++){
            rightBorderSum += arr[i];
            if(rightBorderSum > maxRightBorderSum)
                maxRightBorderSum = rightBorderSum;
        }

        return max3(maxLeftSum, maxRightSum, maxLeftBorderSum + maxRightBorderSum);
    }

    private static int max3(int a, int b ,int c){
        int max = a > b ? a : b;
        return max > c ? max : c;
    }
}
