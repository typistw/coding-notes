package com.leetcode.easy;

import com.leetcode.base.TreeNode;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class ConvertSortedArrayToBinarySearchTree {


    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode root = sortedArrayToBST(nums);
        printTreeNode(root);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return  createNode(nums, 0, nums.length - 1);
    }

    private static TreeNode createNode(int[] nums, int left, int right){
        if(left > right)
            return null;

        int mid = left + (right - left)/2 ;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = createNode(nums, left, mid - 1);
        node.right = createNode(nums, mid + 1, right);
        return node;
    }


    private  static void printTreeNode(TreeNode node){
        if(node == null)
            return;
        printTreeNode(node.left);
        System.out.println(node.val);
        printTreeNode(node.right);
    }
}
