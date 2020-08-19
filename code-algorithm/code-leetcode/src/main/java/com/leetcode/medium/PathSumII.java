package com.leetcode.medium;

import com.alibaba.fastjson.JSON;
import com.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class PathSumII {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        System.out.println(JSON.toJSONString(pathSum(root, 22)));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> wrapList = new ArrayList<>();
        if(root == null){
            return wrapList;
        }

        countSum(root, 0, wrapList, new ArrayList<>(), sum);
        return wrapList;
    }

    private static  void countSum(TreeNode node, int countSum, List<List<Integer>> wrapList, List<Integer> list, int sum){
        if(node == null){
            return;
        }

        countSum += node.val;
        list.add(node.val);

        if(node.left == null && node.right == null){
            if(countSum == sum){
                List<Integer> itemList = new ArrayList<>();
                itemList.addAll(list);
                wrapList.add(itemList);
            }
        }

        countSum(node.left, countSum, wrapList, list, sum);
        countSum(node.right, countSum, wrapList, list, sum);

        int lastIndex = list.size() - 1;
        list.remove(lastIndex);
    }


}
