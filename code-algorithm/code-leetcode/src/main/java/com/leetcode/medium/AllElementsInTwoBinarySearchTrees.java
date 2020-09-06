package com.leetcode.medium;

import com.alibaba.fastjson.JSON;
import com.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
 * Given two binary search trees root1 and root2.

Return a list containing all the integers from both trees sorted in ascending order.

Example 1:
  2         1
 / \       / \
1   4     0   3
Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]
Example 2:

Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
Output: [-10,0,0,1,2,5,7,10]
Example 3:

Input: root1 = [], root2 = [5,1,7,0,2]
Output: [0,1,2,5,7]
Example 4:

Input: root1 = [0,-10,10], root2 = []
Output: [-10,0,10]
Example 5:
  1       8
   \     /
    8   1

Input: root1 = [1,null,8], root2 = [8,1]
Output: [1,1,8,8]


Constraints:

Each tree has at most 5000 nodes.
Each node's value is between [-10^5, 10^5].
 *
 * @author：jinsheng
 */
public class AllElementsInTwoBinarySearchTrees {

    public static void main(String[] args) {
        Integer[] num = {2, 1,4};
        Integer[] num2 = {1, 0,3};
        TreeNode root1 = TreeNode.initTreeNode(num);
        TreeNode root2 = TreeNode.initTreeNode(num2);

        System.out.println(JSON.toJSONString(getAllElements(root1, root2)));
    }

    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        traverseTreeNode(root1, list1);
        traverseTreeNode(root2, list2);

        return mergeSortList(list1, list2);
    }

    private static void traverseTreeNode(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }

        traverseTreeNode(node.left, list);
        list.add(node.val);
        traverseTreeNode(node.right, list);
    }

    private static List<Integer> mergeSortList(List<Integer> listN, List<Integer> listM){
        List<Integer> retList = new ArrayList<>();

        int nSize = listN.size(), mSize = listM.size();
        int nIdx = 0, mIdx = 0;

        while (nIdx < nSize && mIdx < mSize){
            if(listN.get(nIdx) < listM.get(mIdx)){
                retList.add(listN.get(nIdx ++));
            }else{
                retList.add(listM.get(mIdx ++ ));
            }
        }

        while (nIdx < nSize){
            retList.add(listN.get(nIdx ++));
        }

        while (mIdx < mSize){
            retList.add(listM.get(mIdx ++));
        }
        return retList;
    }
}
