package com.leetcode.medium;

/**
 * In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the ith domino.  (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
 * <p>
 * We may rotate the ith domino, so that A[i] and B[i] swap values.
 * <p>
 * Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.
 * <p>
 * If it cannot be done, return -1.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
 * Output: 2
 * Explanation:
 * The first figure represents the dominoes as given by A and B: before we do any rotations.
 * If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
 * Example 2:
 * <p>
 * Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
 * Output: -1
 * Explanation:
 * In this case, it is not possible to rotate the dominoes to make one row of values equal.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= A.length == B.length <= 2 * 104
 * 1 <= A[i], B[i] <= 6
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class MinimumDominoRotationsForEqualRow {

    public static void main(String[] args) {
        int[] A = {2, 1, 2, 4, 2, 2}, B = {5, 2, 6, 2, 3, 2};
        int[] A1 = {3, 5, 1, 2, 3}, B1 = {3, 6, 3, 3, 4};
        int[] A2 = {1, 2, 3, 4, 6}, B2 = {6, 6, 6, 6, 5};

        System.out.println(minDominoRotations(A, B));
        System.out.println(minDominoRotations(A1, B1));
        System.out.println(minDominoRotations(A2, B2));
    }

    public static int minDominoRotations(int[] A, int[] B) {
        int swapA = getSwapCount(A, B);
        int swapB = getSwapCount(B, A);

        if (swapA > 0 && swapB > 0)
            return Math.min(swapA, swapB);

        return Math.max(swapA, swapB);
    }

    private static int getSwapCount(int[] targetArr, int[] swapArr) {
        int ret = -1, swapCount = 0;
        boolean isBreak = false;

        int target = getMaxCountNum(targetArr);
        for (int i = 0; i < targetArr.length; i++) {
            if (targetArr[i] != target) {
                if (swapArr[i] == target) {
                    swapCount++;
                } else {
                    isBreak = true;
                    break;
                }
            }
        }

        if (!isBreak)
            ret = swapCount;

        return ret;
    }

    private static int getMaxCountNum(int[] arr) {
        int[] baseArr = new int[7];
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            baseArr[val] += 1;
        }

        int targetNum = 0;
        for (int i = 1; i < baseArr.length; i++) {
            if (baseArr[i] > baseArr[targetNum]) {
                targetNum = i;
            }
        }

        return targetNum;
    }
}
