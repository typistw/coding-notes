package com.leetcode.easy;

import com.leetcode.base.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 *
 *
 * Example 1:
 *
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 *
 * Example 2:
 *
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * Return false.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class BalanceBinaryTree {

    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return  true;
        int leftDepth = getSubMaxDepth(root.left);
        int rightDepth = getSubMaxDepth(root.right);

        return  Math.abs(leftDepth - rightDepth) <= 1 && isBalanced(root.left) && isBalanced(root.right);

    }

    private static  int getSubMaxDepth(TreeNode node){
        if(node == null)
            return  0;

        int leftDepth = getSubMaxDepth(node.left);
        int rightDepth = getSubMaxDepth(node.right);

        return  leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }

}
