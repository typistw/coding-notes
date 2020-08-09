package com.leetcode.challenge.twenty.august.weektwo;

import com.leetcode.challenge.twenty.august.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
 *You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11

 * @author：jinsheng
 * @date：2020/08/08 16:25
 */
public class PathSumThree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(1);
        root.left = left; root.right = right;

//        left.left = new TreeNode(1);
//        left.right = new TreeNode(3);
//
//        right.left = new TreeNode(-2);
//
//        left.left.left = new TreeNode(-1);
//
//
//        System.out.println(pathSum(root, 1));

        root = new TreeNode(1);
        right = new TreeNode(2);
        root.right = right ;
        right.right = new TreeNode(3);
        right.right.right = new TreeNode(4);
        right.right.right.right = new TreeNode(5);
        System.out.println(pathSum(root, 3));
    }

    public static int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;

        List<Integer> countList = new ArrayList<>();

        findRootPath(root, sum, 0, countList , true);
        return countList.size();
    }

    private static void findRootPath(TreeNode node, int sum, int countSum, List<Integer> list, boolean hasRootNode){
        if(node == null)
            return ;

        countSum += node.val;
        if(sum == countSum){
            list.add(1);
        }

        if(node.left != null){
            findRootPath(node.left,sum, countSum,list, false);
            if(hasRootNode){
                findRootPath(node.left,sum, 0,list,true);
            }
        }

        if(node.right != null){
            findRootPath(node.right, sum, countSum, list , false);
            if(hasRootNode){
                findRootPath(node.right, sum, 0 , list, true);
            }
        }

    }

}
