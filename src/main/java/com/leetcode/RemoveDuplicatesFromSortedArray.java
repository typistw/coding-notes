package com.leetcode;

/*
 * 描述：
 *      给定一个排序整形数组，在数组中移动重复的值，返回新数组的长度使其每个元素仅出现一次
 *
 *      不要为另外的一个数组申请新的空间，仅可以在输入数组的空间大小中做更改
 * example 1:
 *      input: [1, 1, 2]
 *      output: 函数因该返回长度为 2，且输入数组的前面两个数必须是期待的 1 和 2
 * example 2:
 *      input：[0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
 *      output: 函数因该返回长度为 5，且输入数组的前面五个数必须是期待的 0, 1, 2, 3, 4
 * 提示：
 *      新数组中对于超过返回长度部分的索引的值不用关心
 * 说明：
 *      对于返回一个整形值但答案是一个数组的疑惑： 输入的数组是通过引用传递的，意味着调用方也知道对数组的修改
 * @author：jinsheng
 * @date：2019/04/22 23:11
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] ex = {1, 1, 2};
        int[] ex2 = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(ex));
        System.out.println(removeDuplicates(ex2));
    }

    private static int removeDuplicates(int[] nums){
        if(nums == null)
            return 0;

        // 新数组索引
        int index  = 0;
        for(int i = 0; i < nums.length; i++) {
            // 新索引值的等于0  或者数组下标下的值 大于 新数组索引的最后一个值，则为新索引位置赋值且向后移一位
           if(index == 0 || nums[i] > nums[index - 1] )
               nums[index ++] = nums[i];
        }
        return  index;
    }
}
