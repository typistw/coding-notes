package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 *Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 *              1
 *             / \
 *            1   1
 *           /  /  \
 *         1    2    1
 *        /   /    /  \
 *       1   3    3   1
 *
 * Example:
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class PascalTriangle {

    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> wrapList = new ArrayList<>();
        List<Integer> itemList = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            switch (i) {
                case 0:
                    itemList.add(1);
                    wrapList.add(new ArrayList(itemList));
                    break;
                case 1:
                    itemList.add(1);
                    wrapList.add(new ArrayList(itemList));
                    break;
                default:
                    List<Integer> list = new ArrayList<>();
                    for(int j = 0; j < itemList.size() - 1; j++){
                        int val = itemList.get(j) + itemList.get(j + 1);
                        list.add(val);
                    }

                    list.add(1);
                    list.add(0 ,1);
                    wrapList.add(list);

                    itemList.clear();
                    itemList.addAll(list);
            }
        }

        return wrapList;
    }
}
