package com.leetcode.easy;

import com.leetcode.base.TreeNode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if( root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedBlockingQueue();
        queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    if(node.left.left == null && node.left.right == null){
                        sum += node.left.val;
                    }else{
                        queue.add(node.left);
                    }
                }

                if(node.right != null){
                    if(node.right.right != null || node.right.left != null){
                        queue.add(node.right);
                    }
                }
            }
        }

        return sum;
    }
}
