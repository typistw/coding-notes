package com.leetcode.easy;

import com.alibaba.fastjson.JSON;
import com.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class BinaryTreePaths {

    public static void main(String[] args) {
        Integer[] nums = {1,2,3,5};
        TreeNode root = TreeNode.initTreeNode(nums);
        System.out.println(JSON.toJSONString(binaryTreePaths(root)));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> pathList = new ArrayList<>();
        getAllPath(root, pathList, new ArrayList<>());
        return pathList;
    }

    private static void getAllPath(TreeNode root, List<String> pathList, List<Integer> currentPathList){
        if(root == null)
            return;

        currentPathList.add(root.val);

        if(root.left == null && root.right == null){
            StringBuilder tempSb = new StringBuilder();
            for(int i = 0; i < currentPathList.size(); i++){
                if(i != currentPathList.size() - 1){
                    tempSb.append(currentPathList.get(i)).append("->");
                }else{
                    tempSb.append(currentPathList.get(i));
                }
            }
            pathList.add(tempSb.toString());
        }

        if(root.left != null){
            getAllPath(root.left, pathList, currentPathList);
            currentPathList.remove(currentPathList.size() - 1);
        }

        if(root.right != null){
            getAllPath(root.right, pathList, currentPathList);
            currentPathList.remove(currentPathList.size() - 1);
        }
    }

}
