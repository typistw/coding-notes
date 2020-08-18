package com.leetcode.medium;

import com.alibaba.fastjson.JSON;
import com.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class BinaryTreeLevelOrderTraversal {

    private static List<List<Integer>> retList = new LinkedList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(JSON.toJSONString(levelOrderBottom(root)));
        System.out.println(JSON.toJSONString(levelOrderBottomIterative(root)));
    }

    /**
     *  递归
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        retList.clear();
        if (root == null)
            return retList;

        readNodeVal(root, 0);
        return retList;
    }

    /**
     *  迭代
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderBottomIterative(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<>();
        if (root == null) {
            return wrapList;
        }

        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size= queue.size();
            List<Integer> list = new LinkedList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }

                if(node.right != null){
                    queue.offer(node.right);
                }
            }

            wrapList.add(list);
        }

        return wrapList;
    }

    private static void readNodeVal(TreeNode node, int level){
        if(node == null){
            return;
        }

        if(retList.size() >= level + 1){
            retList.get(level).add(node.val);
        }else{
            List<Integer> list = new LinkedList<>();
            list.add(node.val);
            retList.add(list);
        }

        readNodeVal(node.left, level + 1);
        readNodeVal(node.right, level + 1);
    }

}
