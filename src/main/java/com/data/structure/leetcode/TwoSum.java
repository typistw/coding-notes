package com.data.structure.leetcode;

import java.util.Arrays;

/*
 * @author：jinsheng
 * @date：2019/03/17 23:28
 */
public class TwoSum {

    /**
     * 问题描述：
     * 给定一个整数数组L，输入一个数M，返回数组中两数相加等于M的数的下标
     * 假设：
     * 对于输入数M只有一个解决方案，并且两次不会使用同一个元素
     * 例子：
     * Given nums = [2, 7, 11, 15], target = 9,
     * 、
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * r    eturn [0, 1].
     *
     * @param args
     */
    public static void main(String[] args) {
//        int[] nums = {3, 2, 4};
        int[] nums = {3, 3};
        int tagtet = 6;
        int[] retNums = twoSum(nums, tagtet);
        for (int i = 0; i < retNums.length; i++) {
            System.out.println(retNums[i]);
        }
    }

    private static int[] twoSum(int[] nums, int target) {
        int[] retNums = new int[2];
        int[] temps = Arrays.copyOf(nums, nums.length);
        // 排序
        Arrays.sort(nums);
        // 查找最大数和最小数
        int begin = 0, end = nums.length - 1;
        int minNum = 0, maxNum = 0;
        while (begin < end) {
            minNum = nums[begin];
            maxNum = nums[end];
            if (minNum + maxNum < target) {
                begin++;
            } else if (minNum + maxNum > target) {
                end--;
            } else {
                break;
            }
        }

        // 查找最大数和最小数在原数组中的下标
        boolean minFlag = false, maxFlag = false;
        for (int i = 0; i < temps.length; i++) {
            if (!minFlag && temps[i] == minNum) {
                minFlag = true;
                begin = i;
                continue;
            }

            if (!maxFlag && temps[i] == maxNum) {
                maxFlag = true;
                end = i;
            }

            if (minFlag && maxFlag)
                break;
        }
        retNums[0] = begin < end ? begin : end;
        retNums[1] = begin > end ? begin : end;
        return retNums;
    }
}
