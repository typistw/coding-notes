package com.leetcode.easy;

import com.leetcode.base.TreeNode;

/**
 *
 Invert a binary tree.

 Example:

 Input:

 4
 /   \
 2     7
 / \   / \
 1   3 6   9
 Output:

 4
 /   \
 7     2
 / \   / \
 9   6 3   1
 Trivia:
 This problem was inspired by this original tweet by Max Howell:

 Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off. *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class InvertBinaryTree {

    public static void main(String[] args) {
        Integer[] nums = {4,2,7,1,3,6,9};
        TreeNode root = TreeNode.initTreeNode(nums);
        TreeNode retNode = invertTree(root);

        TreeNode.printBreadth(retNode);
    }

    public static TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;

        if(root.left == null && root.right == null){
            return root;
        }

        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;

        if(root.left != null){
           invertTree(root.left);
        }

        if(root.right != null){
            invertTree(root.right);
        }

        return root;
    }
}
