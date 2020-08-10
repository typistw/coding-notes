package com.leetcode.challenge.twenty.august.weektwo;

import java.util.*;

/**
 *In a given grid, each cell can have one of three values:
 *
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
 *
 * Example 1:
 *  minute 0 : [[2,1,1],[1,1,0],[0,1,1]]
 *  minute 1 : [[2,2,1],[2,1,0],[0,1,1]]
 *  minute 2 : [[2,2,2],[2,2,0],[0,1,1]]
 *  minute 3 : [[2,2,2],[2,2,0],[0,2,1]]
 *  minute 4 : [[2,2,2],[2,2,0],[0,2,4]]
 *
 * Input: [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 *
 * Example 2:
 *
 * Input: [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 *
 * Example 3:
 *
 * Input: [[0,2]]
 * Output: 0
 * Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class RottingOranges {

    public static void main(String[] args) {
        int[][] array = {{2,1,1},{1,1,0},{0,1,1}};
        int[][] array2 =  {{2,1,1},{0,1,1},{1,0,1}};
        int[][] array3 = {{0,2}};
        System.out.println(orangesRotting(array));
        System.out.println(orangesRotting(array2));
        System.out.println(orangesRotting(array3));
    }

    public static int orangesRotting(int[][] grid) {
        int row = grid.length;
        int line = grid[0].length;
        Map<Integer, List<Integer>> emptyMap = new HashMap<>();
        Map<Integer, List<Integer>> freshMap = new HashMap<>();
        Map<Integer, List<Integer>> rottenMap = new HashMap<>();

        for(int i = 0; i < row; i++){
            for(int j = 0; j < line; j++){
                int val = grid[i][j];
                switch (val){
                    case 0:
                        if(emptyMap.containsKey(i)){
                            emptyMap.get(i).add(j);
                        }else{
                            List<Integer> itemList  = new ArrayList<>();
                            itemList.add(j);
                            emptyMap.put(i, itemList);
                        }
                        break;
                    case 1:
                        if(freshMap.containsKey(i)){
                            freshMap.get(i).add(j);
                        }else{
                            List<Integer> itemList  = new ArrayList<>();
                            itemList.add(j);
                            freshMap.put(i, itemList);
                        }
                        break;
                    case 2:
                        if(rottenMap.containsKey(i)){
                            rottenMap.get(i).add(j);
                        }else{
                            List<Integer> itemList  = new ArrayList<>();
                            itemList.add(j);
                            rottenMap.put(i, itemList);
                        }
                        break;
                }
            }
        }

        if(freshMap.isEmpty())
            return 0;

        if(rottenMap.isEmpty())
            return  -1;

        int minuteCount = 0;

        while (true){
            Iterator<Integer> mapIterator = freshMap.keySet().iterator();
            Map<Integer, List<Integer>> addRottenMap = new HashMap<>();

            while (mapIterator.hasNext()){
                int rowIndex = mapIterator.next();
                List<Integer> lineList = freshMap.get(rowIndex);
                Iterator<Integer> listIterator = lineList.iterator();

                while (listIterator.hasNext()){
                    // 根据行号取出当前行和相邻行所有 坏橘子
                    List<Integer> nowRowList = rottenMap.get(rowIndex);
                    List<Integer> beforeRowList = rottenMap.get(rowIndex - 1);
                    List<Integer> afterRowList = rottenMap.get(rowIndex + 1);

                    boolean hasRotten = false;
                    int nowLineIndex = listIterator.next();
                    // 当前行， 列 +1 或-1
                    if(null != nowRowList){
                        if(nowRowList.contains(nowLineIndex - 1) || nowRowList.contains(nowLineIndex + 1)){
                            hasRotten = true;
                        }
                    }

                    if(null != beforeRowList &&  beforeRowList.contains(nowLineIndex)){
                        hasRotten = true;
                    }

                    if( null != afterRowList && afterRowList.contains(nowLineIndex)){
                        hasRotten = true;
                    }

                    if(hasRotten){
                        listIterator.remove();
                        if(addRottenMap.containsKey(rowIndex)){
                            addRottenMap.get(rowIndex).add(nowLineIndex);
                        }else {
                            List<Integer> item = new ArrayList<>();
                            item.add(nowLineIndex);
                            addRottenMap.put(rowIndex, item);
                        }
                    }
                }

                // 当前行对应的列是否 坏化完
                if(lineList.isEmpty()){
                    mapIterator.remove();
                }
            }

            // 一轮坏化完成
            if(!addRottenMap.isEmpty()) {
                minuteCount ++;
                for(Integer key : addRottenMap.keySet()){
                    if(rottenMap.containsKey(key)){
                        rottenMap.get(key).addAll(addRottenMap.get(key));
                    }else{
                        rottenMap.put(key, addRottenMap.get(key));
                    }
                }
            }else{
                // 结束
                if(!freshMap.isEmpty()){
                    minuteCount = -1;
                }
                break;
            }

        }
        return minuteCount;
    }
}
