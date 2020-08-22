package com.leetcode.easy;

import java.util.LinkedList;
import java.util.List;

/*
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
 *
 * @author：jinsheng
 * @date：2020/08/22 23:35
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        System.out.println(singleNumber(nums));
        System.out.println(singleNumberByXOR(nums));
    }

    public static int singleNumber(int[] nums) {
        List<String> list = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            String val = String.valueOf(nums[i]);
            if(list.contains(val)){
                list.remove(val);
            }else {
                list.add(val);
            }
        }

        return Integer.valueOf(list.get(0));
    }

    /**
     *  异或
     *   0^N = N
     *   N^N = 0;
     * @param nums
     * @return
     */
    public static int singleNumberByXOR(int[] nums){
        int ans = 0;
        for(int i = 0 ; i < nums.length; i++){
            ans ^= nums[i];
        }

        return ans;
    }

}
