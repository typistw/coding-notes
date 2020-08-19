package com.leetcode.easy;

import com.leetcode.base.TreeNode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class PathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        root.right = new TreeNode(-3);

        System.out.println(hasPathSum(root, -5));
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        return  countPathSum(root, 0 , sum);
    }

    private static boolean countPathSum(TreeNode node, int countSum , int sum){
        if(node == null)
            return false;

        countSum += node.val;

        if(countSum == sum && node.left == null && node.right == null){
            return  true;
        }

        return  countPathSum(node.left,countSum,  sum) ||  countPathSum(node.right, countSum, sum);
    }

}
