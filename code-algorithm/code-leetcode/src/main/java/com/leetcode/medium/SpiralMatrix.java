package com.leetcode.medium;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 * Example 1:
 *  1 2 3
 *  4 5 6
 *  7 8 9
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Example 2:
 *  1  2  3  4
 *  5  6  7  8
 *  9 10 12 12
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix  = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(JSON.toJSONString(spiralOrder(matrix)));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        int rowSize = matrix.length , colSize = matrix[0].length;
        int row = 0, col = 0;
        // 1: right; 2 : down; 3 : left; 4 : up
        int directionType = 1;
        for(int i = 1; i <= rowSize * colSize; i ++){
            int value = matrix[row][col];
            list.add(value);
            //  change direction
            switch (directionType){
                case 1:
                    if(col == colSize - 1 || list.indexOf(matrix[row][col + 1]) != -1){
                        row ++;
                        directionType = 2;
                    }else{
                        col ++;
                    }
                    break;
                case 2:
                    if(row == rowSize - 1 || list.indexOf(matrix[row + 1][col]) != -1){
                        col --;
                        directionType = 3;
                    }else {
                        row ++;
                    }
                    break;
                case 3:
                    if(col == 0 || list.indexOf(matrix[row][col - 1]) != -1){
                        row --;
                        directionType = 4;
                    }else{
                        col --;
                    }
                    break;
                case 4:
                    if(row == 0 || list.indexOf(matrix[row - 1][col]) != -1){
                        col ++;
                        directionType = 1;
                    }else{
                        row --;
                    }
                    break;
            }
        }
        return list;
    }

}
