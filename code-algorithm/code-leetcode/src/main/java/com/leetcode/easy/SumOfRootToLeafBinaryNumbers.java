package com.leetcode.easy;

import com.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
 *
 * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
 *
 * Return the sum of these numbers.
 *
 *
 *
 * Example 1:
 *              1
 *            /  \
 *           0    1
 *         / \   / \
 *        0   1 0   1
 *
 * Input: [1,0,1,0,1,0,1]
 * Output: 22
 * Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 *
 *
 * Note:
 *
 * The number of nodes in the tree is between 1 and 1000.
 * node.val is 0 or 1.
 * The answer will not exceed 2^31 - 1.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class SumOfRootToLeafBinaryNumbers {

    public static void main(String[] args) {
        Integer[] nums = {1,0,1};
        TreeNode root = TreeNode.initTreeNode(nums);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        TreeNode root2 = new TreeNode(0);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(0);

        System.out.println(sumRootToLeaf(root2));
    }

    public static int sumRootToLeaf(TreeNode root) {
        if(root == null)
            return 0;

        List<String> pathList  = new ArrayList<>();
        backTrack(root, new StringBuilder(), pathList);
        int sum = 0;

        for(String str : pathList){
            int firstIndex = str.indexOf('1');
            if(firstIndex  == -1)
                continue;

            str = str.substring(firstIndex);
            for(int i = str.length() - 1; i >= 0 ; i--){
                int val = str.charAt(i) - '0';
                sum += val * Math.pow(2, str.length() - 1 - i);
            }
        }

        return sum;
    }

    private static void backTrack(TreeNode node, StringBuilder sb, List<String> pathList){
        if(node == null)
            return;

        sb.append(node.val);

        if(node.left == null && node.right == null){
            pathList.add(sb.toString());
        }

        if(node.left != null){
            backTrack(node.left, sb, pathList);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(node.right != null){
            backTrack(node.right,sb, pathList);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
