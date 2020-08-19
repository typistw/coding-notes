package com.leetcode.easy;

import com.leetcode.base.TreeNode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its minimum depth = 2.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class MinimumDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(minDepth(root));


        root.val = 3;
        root.left.val = 9;

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(minDepth(root));
    }

    /**
     *  BFS(breadth first search)
     * @param root
     * @return
     */
    public static  int minDepth(TreeNode root) {
        if(root == null)
            return 0;

         Queue<TreeNode> queue = new LinkedBlockingQueue<>();
         queue.offer(root);
         int minDepth = 0;
         while (!queue.isEmpty()){
            int size= queue.size();
            minDepth ++ ;
            for(int i = 0 ;i < size; i++){
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null){
                    queue.clear();
                    break;
                }

                if(node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }

        return minDepth;
    }

}
