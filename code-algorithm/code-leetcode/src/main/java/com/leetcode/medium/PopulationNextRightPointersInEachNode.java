package com.leetcode.medium;

import com.leetcode.base.Node;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *  You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 *
 *
 * Follow up:
 *
 * You may only use constant extra space.
 * Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
 *
 *
 * Example 1:
 *        1                      1 -> null
 *      /  \                  /    \
 *     2    3                2  ->  3 -> null
 *    / \  / \             /  \    / \
 *   4  5 6   7          4  -> 5->6 ->7  -> null
 *
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 *
 *
 * Constraints:
 *
 * The number of nodes in the given tree is less than 4096.
 * -1000 <= node.val <= 1000
 *
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class PopulationNextRightPointersInEachNode {

    public static void main(String[] args) {
        Integer[] nums = {1,2,3,4,5,6,7};
        Node root = Node.initNode(nums);
        connect(root);
        System.out.println(Node.getPrintNode(root));
    }

    public static  Node connect(Node root) {
        if(root == null || root.left == null)
            return  root;

        recursiveConnect(root.left, root.right);
        return root;
    }

    private static void recursiveConnect(Node node, Node node2){
        if(node.next == null){
            node.next = node2;
        }

        if(node.left != null){
            recursiveConnect(node.left, node.right);
            recursiveConnect(node.right, node2.left);
            recursiveConnect(node2.left, node2.right);
        }
    }
}
