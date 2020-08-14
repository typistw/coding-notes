package com.leetcode.easy;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.List;

/**
 *Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 *
 * Note that the row index starts from 0.
 *
 *
 * In Pascal's triangle(杨辉三角), each number is the sum of the two numbers directly above it.
 *            1
 *           / \
 *          1   1
 *         /  /  \
 *       1    2    1
 *      /   /    /  \
 *     1   3    3   1
 *
 * Example:
 *
 * Input: 3
 * Output: [1,3,3,1]
 * Follow up:
 *
 * Could you optimize your algorithm to use only O(k) extra space?
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class PascalTriangleII {

    public static void main(String[] args) {
        int num = 0;
        int num2 = 1;
        int num3 = 2;
        int num4 = 3;
        int num5 = 4;
        int num6 = 5;
        int num7 = 6;
        System.out.println(JSON.toJSONString(getRow(num)));
        System.out.println(JSON.toJSONString(getRow(num2)));
        System.out.println(JSON.toJSONString(getRow(num3)));
        System.out.println(JSON.toJSONString(getRow(num4)));
        System.out.println(JSON.toJSONString(getRow(num5)));
        System.out.println(JSON.toJSONString(getRow(num6)));
        System.out.println(JSON.toJSONString(getRow(num7)));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new LinkedList<>();
        for(int i = 0 ; i <= rowIndex; i++){
            if(i == 0){
                list.add(1);
            }else{
                if(i == 1){
                    list.add(1);
                    continue;
                }

                List<Integer> itemList = new LinkedList<>();
                itemList.add(1);
                for(int j = 0; j < i - 1 ;j ++){
                    int sum = list.get(j) + list.get(j + 1);
                    itemList.add(sum);
                }
                itemList.add(1);
                list.clear();
                list.addAll(itemList);
            }
        }
        return  list;
    }

}
