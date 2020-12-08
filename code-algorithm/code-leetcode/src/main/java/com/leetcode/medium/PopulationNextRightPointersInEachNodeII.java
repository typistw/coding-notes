package com.leetcode.medium;

import com.leetcode.base.Node;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Given a binary tree
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
 *
 *          1                      1 -> null
 *        /  \                  /    \
 *       2    3                2  ->  3 -> null
 *      / \    |             /  \      \
 *     4  5    7           4  -> 5  ->  7  -> null
 *
 * Input: root = [1,2,3,4,5,null,7]
 * Output: [1,#,2,3,#,4,5,7,#]
 * Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 *
 *
 * Constraints:
 *
 * The number of nodes in the given tree is less than 6000.
 * -100 <= node.val <= 100
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class PopulationNextRightPointersInEachNodeII {

    public static void main(String[] args) {
        Integer[] nums = {1,2,3,4,5,null,7};
        Node root = Node.initNode(nums);
        connect(root);
        System.out.println(Node.getPrintNode(root));
    }

    public static  Node connect(Node root) {
        if(root == null)
            return  null;

        Queue<Node> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ;i < size; i++){
                Node tempNode = queue.poll();
                if(tempNode.left != null){
                    queue.add(tempNode.left);
                }

                if(tempNode.right != null){
                    queue.add(tempNode.right);
                }

                if(i != size - 1){
                    tempNode.next = queue.peek();
                }
            }
        }

        return root;
    }
}
