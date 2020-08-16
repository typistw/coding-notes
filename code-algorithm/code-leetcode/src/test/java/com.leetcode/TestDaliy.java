package com.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @Auther: jinsheng.wei
 * @Date: 2020/8/7 10:37
 * @Description:
 */
public class TestDaliy {

    @Test
    public void executeTest(){

    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> verticalList = new LinkedList<>();
        Map<Integer,Map<Integer, SortedSet<Integer>> > xToYMap = new TreeMap<>();
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

        if(node.left != null && node.right != null){
            findChildren(node.left, xToYMAp,xVal - 1, yVal - 1);
            findChildren(node.right, xToYMAp, xVal + 1, yVal -1);
        }

        if(node.left != null){
            findChildren(node.left, xToYMAp,xVal - 1, yVal - 1);
        }

        if(node.right != null){
            findChildren(node.right, xToYMAp, xVal + 1, yVal - 1);
        }
    }

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

}
