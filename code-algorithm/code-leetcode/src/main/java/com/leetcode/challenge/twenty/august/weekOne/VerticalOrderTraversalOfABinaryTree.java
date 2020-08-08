package com.leetcode.challenge.twenty.august.weekOne;

import com.leetcode.challenge.twenty.august.TreeNode;

import java.util.*;

/*
 *Given a binary tree, return the vertical order traversal of its nodes values.

For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).

Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).

If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.

Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.

Example 1:

      3
     /  \
    9   20
        / \
       15  7

Input: [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Without loss of generality, we can assume the root node is at position (0, 0):
Then, the node with value 9 occurs at position (-1, -1);
The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
The node with value 20 occurs at position (1, -1);
The node with value 7 occurs at position (2, -2).

Example 2:
       1
     /  \
   2     3
  / \   / \
 4  5  6   7


Input: [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
The node with value 5 and the node with value 6 have the same position according to the given scheme.
However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.


Note:

The tree will have between 1 and 1000 nodes.
Each node's value will be between 0 and 1000.
 * @author：jinsheng
 * @date：2020/08/08 15:57
 */
public class VerticalOrderTraversalOfABinaryTree {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> verticalList = new LinkedList<>();
        Map<Integer, Map<Integer, SortedSet<Integer>>> xToYMap = new TreeMap<>();
        if (root == null) {
            return verticalList;
        }

        findChildren(root, xToYMap, 0, 0);
        for(Integer xVal : xToYMap.keySet()){
            // Y 轴根据坐标倒序
            Map<Integer, SortedSet<Integer>> yMap = xToYMap.get(xVal);
            List<Integer> yKeyList = new LinkedList<>();
            yKeyList.addAll(yMap.keySet());

            List<Integer> xToValList = new LinkedList<>();
            for(int i = yKeyList.size() - 1; i >= 0; i--){
                SortedSet<Integer> yToValSet = yMap.get(yKeyList.get(i));
                xToValList.addAll(yToValSet);
            }
            verticalList.add(xToValList);
        }

        return verticalList;
    }

    public void findChildren(TreeNode node, Map<Integer, Map<Integer, SortedSet<Integer>>> xToYMAp, int xVal, int yVal){
        if(node == null)
            return;

        if(xToYMAp.containsKey(xVal)){
            Map<Integer, SortedSet<Integer>> yMap = xToYMAp.get(xVal);
            // 判断 Y轴 坐标是否有值， 若存在， 升序排序(形同X轴和Y轴)
            SortedSet<Integer> ySet;
            if(yMap.containsKey(yVal)){
                ySet = yMap.get(yVal);
            }else{
                ySet = new TreeSet();
            }
            ySet.add(node.val);
            yMap.put(yVal, ySet);
        }else{
            Map<Integer, SortedSet<Integer>> yMap = new TreeMap<>();
            SortedSet<Integer> ySet = new TreeSet<>();
            ySet.add(node.val);
            yMap.put(yVal, ySet);
            xToYMAp.put(xVal, yMap);
        }

        if(node.left != null){
            findChildren(node.left, xToYMAp,xVal - 1, yVal - 1);
        }

        if(node.right != null){
            findChildren(node.right, xToYMAp, xVal + 1, yVal - 1);
        }
    }

}
