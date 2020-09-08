package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * A partially filled sudoku which is valid.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * Example 1:
 *
 * Input:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 * Example 2:
 *
 * Input:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being
 *     modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * The given board contain only digits 1-9 and the character '.'.
 * The given board size is always 9x9.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = {{'.','4','.','.','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'},
                {'.','.','.','1','.','.','7','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','3','.','.','.','6','.'},
                {'.','.','.','.','.','6','.','9','.'},
                {'.','.','.','.','1','.','.','.','.'},
                {'.','.','.','.','.','.','2','.','.'},
                {'.','.','.','8','.','.','.','.','.'}}
        ;

        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        int mutipleI = 0, mutipleJ = 0;
        Set<Character> set = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        Set<Character> set3 = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            int idxI = mutipleI * 3 + i;
            mutipleJ = 0;
            for (int j = 0; j < 3; j++) {
                int idxJ = mutipleJ * 3 + j;
                char val = board[idxI][idxJ];

                switch (idxJ) {
                    case 0:
                    case 1:
                    case 2:
                        if (val != '.' && !set.add(val)) {
                            return false;
                        }
                        break;
                    case 3:
                    case 4:
                    case 5:
                        if (val != '.' && !set2.add(val)) {
                            return false;
                        }
                        break;
                    case 6:
                    case 7:
                    case 8:
                        if (val != '.' && !set3.add(val)) {
                            return false;
                        }
                        break;

                }

                if(j == 2 && mutipleJ < 2){
                    mutipleJ ++;
                    j = -1;
                }
            }

            if (i == 2 && mutipleI < 2) {
                mutipleI++;
                set.clear();
                set2.clear();
                set3.clear();
                i = -1;
            }
        }

        List<Set<Character>> rowList = new ArrayList<>();
        List<Set<Character>> columnList = new ArrayList<>();
        initList(rowList);
        initList(columnList);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char val = board[i][j];
                if (val == '.')
                    continue;

                Set<Character> tempSet = rowList.get(i);
                if (!tempSet.add(val)) {
                    return false;
                }

                tempSet = columnList.get(j);
                if (!tempSet.add(val)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void initList(List<Set<Character>> list) {
        for (int i = 0; i < 9; i++) {
            list.add(new HashSet());
        }
    }
}
