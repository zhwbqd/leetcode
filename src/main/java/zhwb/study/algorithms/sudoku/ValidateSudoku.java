package zhwb.study.algorithms.sudoku;

import java.util.HashSet;
import java.util.Set;

/**
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
    }
}
