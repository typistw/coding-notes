package com.leetcode.easy;

import com.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range [low, high].
 *
 *
 *
 * Example 1:
 *         10
 *       /   \
 *     5     15
 *   /  \      \
 *  3    7      18
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
 * Output: 32
 * Example 2:
 *
 *         10
 *       /   \
 *     5     15
 *   /  \    / \
 *  3    7  13 18
 *  /   /
 * 1    6
 * Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * Output: 23
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 2 * 104].
 * 1 <= Node.val <= 105
 * 1 <= low <= high <= 105
 * All Node.val are unique.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class RangeSumOfBST {

    public static void main(String[] args) {
        Integer[] sum = {10, 5, 15, 3, 7, null, 18};
        int low = 7, high = 15;
        TreeNode root = TreeNode.initTreeNode(sum);
        System.out.println(rangeSumBST(root, low, high));
    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        List<Integer> list = new ArrayList<>();
        getRangeValue(root, low, high, list);
        int sum = 0;
        for (Integer item : list) {
            sum += item;
        }

        return sum;
    }

    private static void getRangeValue(TreeNode node, int low, int high, List<Integer> list) {
        if (node == null)
            return;

        if (node.val >= low && node.val <= high) {
            list.add(node.val);
        }

        if(node.val < low){
            getRangeValue(node.right, low, high, list);
        }else if(node.val > high){
            getRangeValue(node.left, low, high, list);
        }else{
            getRangeValue(node.left, low, high, list);
            getRangeValue(node.right, low, high, list);
        }

    }

}
