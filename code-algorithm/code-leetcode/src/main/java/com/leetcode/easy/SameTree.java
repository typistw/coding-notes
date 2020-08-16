package com.leetcode.easy;

import com.leetcode.base.TreeNode;

/*
 *Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false
 *
 * @author：jinsheng
 * @date：2020/08/16 23:10
 */
public class SameTree {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);

        TreeNode node2 = new TreeNode(1);
        node.right = new TreeNode(2);

        System.out.println(isSameTree(node, node2));

    }

    public static  boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;

        if(( p == null  || q == null)) {
            return  false;
        }

        if(p.val != q.val){
            return false;
        }

        if(!isSameTree(p.left, q.left)){
            return false;
        }

        if(!isSameTree(p.right, q.right)){
            return false;
        }

        return  true;
    }
}
