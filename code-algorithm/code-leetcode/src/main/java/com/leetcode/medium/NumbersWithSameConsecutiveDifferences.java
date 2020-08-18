package com.leetcode.medium;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 *Return all non-negative integers of length N such that the absolute difference between every two consecutive digits is K.
 *
 * Note that every number in the answer must not have leading zeros except for the number 0 itself. For example, 01 has one leading zero and is invalid, but 0 is valid.
 *
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: N = 3, K = 7
 * Output: [181,292,707,818,929]
 * Explanation: Note that 070 is not a valid number, because it has leading zeroes.
 * Example 2:
 *
 * Input: N = 2, K = 1
 * Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 *
 *
 * Note:
 *
 * 1 <= N <= 9
 * 0 <= K <= 9
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class NumbersWithSameConsecutiveDifferences {

    public static void main(String[] args) {
        int n = 3, k = 7;
        int n2 = 2, k2 = 1;
        int n3 = 2, k3 = 0;
        System.out.println(JSON.toJSONString(numsSameConsecDiff(n, k)));
        System.out.println(JSON.toJSONString(numsSameConsecDiff(n2, k2)));
        System.out.println(JSON.toJSONString(numsSameConsecDiff(n3, k3)));
    }

    public static int[] numsSameConsecDiff(int N, int K) {
        int[] nums = new int[N];

        Set<String> list = new HashSet<>();
        // 记录多选择的节点位置(加、减), 回溯
        Stack<Integer> addStack = new Stack<>();
        for(int i = 1; i <=9; i++){
            reset(nums);
            for(int j = 0; j < N; j++){
                if(j == 0 && !addStack.isEmpty()){
                    j = addStack.pop();
                    nums[j] = nums[j - 1] + K;
                }else if(j == 0){
                    nums[j] = i;
                }else{
                    int preVal = nums[j - 1];
                    if( preVal >= K && preVal + K <= 9){
                        addStack.add(j);
                        nums[j] = preVal - K;
                    }else if( preVal + K <= 9 ){
                        nums[j] = preVal + K;
                    }else if(preVal - K >= 0){
                        nums[j] = preVal - K;
                    }else {
                        addStack.clear();
                        break;
                    }
                }

                if(j == N - 1){
                    list.add(getArray(nums));

                    if(!addStack.isEmpty()){
                        j = -1;
                    }
                }

            }
        }

        if(N == 1){
            list.add("0");
        }

       int[] retArry = new int[list.size()];

        int index = 0;
        for(String str : list){
            int val = Integer.valueOf(str);
            retArry[index ++] = val;
        }

        return  retArry;
    }

    private static void reset(int[] nums){
        for(int i = 0; i < nums.length; i++){
            nums[i] = 0;
        }
    }

    private static String getArray(int[] nums){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nums.length; i++){
            sb.append(nums[i]);
        }
        return sb.toString();
    }

}
