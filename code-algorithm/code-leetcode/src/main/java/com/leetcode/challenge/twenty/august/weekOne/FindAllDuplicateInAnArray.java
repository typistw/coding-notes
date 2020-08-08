package com.leetcode.challenge.twenty.august.weekOne;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 *Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]

 * @author：jinsheng
 * @date：2020/08/08 15:59
 */
public class FindAllDuplicateInAnArray {

    /**
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])) {
                list.add(nums[i]);
            }else{
                set.add(nums[i]);
            }
        }
        return  list;
    }
}
