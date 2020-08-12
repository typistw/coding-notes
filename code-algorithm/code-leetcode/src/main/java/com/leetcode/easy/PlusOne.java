package com.leetcode.easy;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.List;

/**
 *  Given a non-empty array of digits representing a non-negative integer, increment one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] nums = {1, 2,3 };
        int[] nums2 = {4,3,2,1};
        int[] nums3 = {2,9,9,9};
        int[] nums4 = {1,2,9,9,9};
        int[] nums5 = {9};
        System.out.println(JSON.toJSONString(plusOne(nums)));
        System.out.println(JSON.toJSONString(plusOne(nums2)));
        System.out.println(JSON.toJSONString(plusOne(nums3)));
        System.out.println(JSON.toJSONString(plusOne(nums4)));
        System.out.println(JSON.toJSONString(plusOne(nums5)));
    }

    public static int[] plusOne(int[] digits) {
        List<Integer> list = new LinkedList<>();
        boolean hasAdvance = true;
        int plusOn = 1, index = 0;
        for(int i = digits.length - 1; i >= 0 ; i--){
            if(!hasAdvance){
                break;
            }
            int itemVal = digits[i] + plusOn;
            if(itemVal >= 10){
                itemVal %= 10;
            }else{
                hasAdvance = false;
            }
            list.add(itemVal);
            index = i;
        }

        if(hasAdvance){
            list.add(1);
        }

        int[] itemArr =  new int[index + list.size()];
        for(int i = 0; i < index; i++){
            itemArr[i] = digits[i];
        }

        for(int j = list.size() - 1; j >=0; j--){
            itemArr[index ++] = list.get(j);
        }

        return itemArr;
    }
}
