package com.leetcode.medium;

import com.alibaba.fastjson.JSON;

/**
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example 1:
 *   1  2  3
 *   8  9  4
 *   7  6  5
 *
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 * Example 2:
 *
 * Input: n = 1
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 20
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class SpiralMatrixII {

    public static void main(String[] args) {
        int n = 1, n2 = 2, n3 = 3, n4 = 4;
        System.out.println(JSON.toJSONString(generateMatrix(n)));
        System.out.println(JSON.toJSONString(generateMatrix(n2)));
        System.out.println(JSON.toJSONString(generateMatrix(n3)));
        System.out.println(JSON.toJSONString(generateMatrix(n4)));
    }

    public static int[][] generateMatrix(int n) {
        int[][] array = new int[n][n];

        int row = 0, col = 0;
        // 1: right; 2 : down; 3 : left; 4 : up
        int directionType = 1;
        for(int i = 1 ; i <= n * n; i ++){
            array[row][col] = i;
            // change direction
            switch (directionType){
                case 1:
                    if(col == n - 1 || array[row][col + 1] != 0){
                        // move down
                        row ++;
                        directionType = 2;
                    }else{
                        col ++;
                    }
                    break;
                case 2:
                    if(row == n - 1 || array[row + 1][col] != 0){
                        // move left
                        col -- ;
                        directionType = 3;
                    }else{
                        row ++;
                    }
                    break;
                case 3:
                    if(col == 0 || array[row][col - 1] != 0){
                        // move up
                        row --;
                        directionType = 4;
                    }else{
                        col --;
                    }
                    break;
                case 4:
                    if(row == 0 || array[row - 1 ][col] != 0){
                        // move right
                        col ++;
                        directionType = 1;
                    }else{
                        row --;
                    }
                    break;
            }
        }

        return array;
    }
}
