package com.github.h0ngyue.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by shuailongcheng on 03/03/2017.
 */

public class _36_ValidSodoku {

    public static boolean isValidSudoku(char[][] board) {
        Set<Integer> rowSets = new HashSet<>();
        Set<Integer> columnSets = new HashSet<>();
        Set<Integer> squareSets = new HashSet<>();

        int dimen = board.length;
        int sqrt = (int) Math.sqrt(dimen);
        for (int i = 0; i < dimen; i++) {
            rowSets.clear();
            columnSets.clear();
            for (int j = 0; j < dimen; j++) {
                if (board[i][j] != '.' && rowSets.contains((int) board[i][j])) {
                    return false;
                } else {
                    rowSets.add((int) board[i][j]);
                }
                if (board[j][i] != '.' && columnSets.contains((int) board[j][i])) {
                    return false;
                } else {
                    columnSets.add((int) board[j][i]);
                }

                if (i <= dimen - sqrt && j <= dimen - sqrt && i % sqrt == 0
                        && j % sqrt == 0) {
                    squareSets.clear();
                    for (int k = 0; k < sqrt; k++) {
                        for (int l = 0; l < sqrt; l++) {
                            if (board[i + k][j + l] != '.' && squareSets
                                    .contains((int) board[i + k][j + l])) {
                                return false;
                            } else {
                                squareSets.add((int) board[i + k][j + l]);
                            }
                        }
                    }
                }
            }
        }

        return true;
    }


    public static void test() {
        char[][] board = {
                "......5..".toCharArray(),
                ".........".toCharArray(),
                ".........".toCharArray(),
                "93..2.4..".toCharArray(),
                "..7...3..".toCharArray(),
                ".........".toCharArray(),
                "...34....".toCharArray(),
                ".....3...".toCharArray(),
                ".....52..".toCharArray(),};
        System.out.println(isValidSudoku(board));
    }
}
