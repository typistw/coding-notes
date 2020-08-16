package com.leetcode.easy;

import com.leetcode.base.TreeNode;

/*
 * @author：jinsheng
 * @date：2020/08/16 23:47
 */
public class SymmetricTree {

    public static boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return  isSameNodeVal(root.left, root.right);
    }

    private static  boolean isSameNodeVal(TreeNode left, TreeNode right){
        if(left == null && right == null)
            return true;

        if(left == null || right == null)
            return false;

        if(left.val != right.val){
            return false;
        }

        return (isSameNodeVal(left.left, right.right) && isSameNodeVal(left.right, right.left) );
    }

}
