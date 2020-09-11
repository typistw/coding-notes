package com.leetcode.base;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    public static TreeNode initTreeNode(Integer[] array) {
        Integer[] tempArray = new Integer[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            tempArray[i + 1] = array[i];
        }

        TreeNode root = new TreeNode(tempArray[1]);
        for (int i = 1; i < tempArray.length; i++) {
            if (tempArray[i] != null) {
                if (2 * i < tempArray.length) {
                    structureChildNoe(root, tempArray[i], tempArray[2 * i], true);
                }

                if (2 * i + 1 < tempArray.length) {
                    structureChildNoe(root, tempArray[i], tempArray[2 * i + 1], false);
                }
            }
        }

        return root;
    }

    public static void printBreadth(TreeNode node){
        if(node == null)
            return;

        Queue<TreeNode> queue = new LinkedBlockingDeque<>();
        queue.add(node);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                TreeNode tempNode = queue.poll();
                sb.append(tempNode.val).append(",");

                if(tempNode.left != null)
                    queue.add(tempNode.left);

                if(tempNode.right != null){
                    queue.add(tempNode.right);
                }

                size--;
            }
        }
        System.out.println(sb.toString());
    }

    private static void structureChildNoe(TreeNode node, int rootVal, int val, boolean hasLeft) {
        if (node == null)
            return;

        if (node.val == rootVal) {
            if (hasLeft) {
                node.left = new TreeNode(val);
            } else {
                node.right = new TreeNode(val);
            }
        }else{
            structureChildNoe(node.left, rootVal, val, hasLeft);
            structureChildNoe(node.right, rootVal, val, hasLeft);
        }
    }
}