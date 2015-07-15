package zhwb.study.algorithms.sudoku;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/valid-sudoku/
 *
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * @author jack.zhang
 * @since 2015/7/11 0011
 */
public class ValidateSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> rowSet = new HashSet<>();
        Set<Character> colSet = new HashSet<>();
        Set<Character> subSet = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            rowSet.clear();
            colSet.clear();
            subSet.clear();
            for (int j = 0; j < 9; j++) {
                char row = board[i][j];
                char col = board[j][i];
                if (col != '.') {
                    if (!colSet.add(col)) {
                        return false;
                    }
                }
                if (row != '.') {
                    if (!rowSet.add(row)) {
                        return false;
                    }
                }

                int i1 = 3 * (i / 3);
                int i2 = 3 * (i % 3);
                char c = board[i1 + j / 3][i2 + j % 3];
                if (c != '.') {
                    if (!subSet.add(c)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudokuV2(char[][] board) {
        int used1[][] = new int[9][9];
        int used2[][] = new int[9][9];
        int used3[][] = new int[9][9];

        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board[i].length; ++j)
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0' - 1, k = i / 3 * 3 + j / 3;
                    if (used1[i][num] == 1|| used2[j][num] ==1|| used3[k][num]==1)
                        return false;
                    used1[i][num] = used2[j][num] = used3[k][num] = 1;
                }

        return true;
    }

    public static void main(String[] args) {
        case1();
    }

    private static void case1() {
        char[][] chars = new char[9][9];
        chars[0] = new char[]{'.', '8', '7', '6', '5', '4', '3', '2', '1'};
        chars[1] = new char[]{'2', '.', '.', '.', '.', '.', '.', '.', '.'};
        chars[2] = new char[]{'3', '.', '.', '.', '.', '.', '.', '.', '.'};
        chars[3] = new char[]{'4', '.', '.', '.', '.', '.', '.', '.', '.'};
        chars[4] = new char[]{'5', '.', '.', '.', '.', '.', '.', '.', '.'};
        chars[5] = new char[]{'6', '.', '.', '.', '.', '.', '.', '.', '.'};
        chars[6] = new char[]{'7', '.', '.', '.', '.', '.', '.', '.', '.'};
        chars[7] = new char[]{'8', '.', '.', '.', '.', '.', '.', '.', '.'};
        chars[8] = new char[]{'9', '.', '.', '.', '.', '.', '.', '.', '.'};

        System.out.println(new ValidateSudoku().isValidSudoku(chars));
        System.out.println(new ValidateSudoku().isValidSudokuV2(chars));
    }
}
