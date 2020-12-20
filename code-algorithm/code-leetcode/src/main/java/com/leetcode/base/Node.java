package com.leetcode.base;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Auther: jinsheng.wei
 * @Description:
 */
public class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public static Node initNode(Integer[] nums){
        Integer[] tempArray = new Integer[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            tempArray[i + 1] = nums[i];
        }

        Node root = new Node(nums[0]);
        for (int i = 1; i < tempArray.length; i++) {
            if (tempArray[i] != null) {
                if (2 * i < tempArray.length && tempArray[2 * i] != null) {
                    structureChildNoe(root, tempArray[i], tempArray[2 * i], true);
                }

                if (2 * i + 1 < tempArray.length && tempArray[2 * i + 1] != null) {
                    structureChildNoe(root, tempArray[i], tempArray[2 * i + 1], false);
                }
            }
        }

        return  root;
    }

    public static String getPrintNode(Node node){
        StringBuilder sb = new StringBuilder();
        if(node == null)
            return sb.toString();

        Queue<Node> queue = new LinkedBlockingQueue<>();
        queue.add(node);
        while (!queue.isEmpty()){
            Node tempNode = queue.poll();
            if(tempNode.left != null){
                queue.add(tempNode.left);
            }

            while (tempNode != null){
                sb.append(tempNode.val).append(",");
                tempNode = tempNode.next;
            }
            sb.append("#").append(",");
        }
        sb.deleteCharAt(sb.length() - 1) ;
        return sb.toString();
    }

    private static void structureChildNoe(Node node, int rootVal, int val, boolean hasLeft) {
        if (node == null)
            return;

        if (node.val == rootVal) {
            if (hasLeft) {
                node.left = new Node(val);
            } else {
                node.right = new Node(val);
            }
        }else{
            structureChildNoe(node.left, rootVal, val, hasLeft);
            structureChildNoe(node.right, rootVal, val, hasLeft);
        }
    }
}
