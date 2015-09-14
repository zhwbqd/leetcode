package zhwb.study.algorithms.array.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/n-queens/
 * <p/>
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * <p/>
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * <p/>
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen
 * and an empty space respectively.
 * <p/>
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * <p/>
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p/>
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 *
 * @author jack.zhang
 * @since 2015/9/14
 */
public class NQueues {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        //init
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        //swap
        solve(0, board, result);
        return result;
    }

    private void solve(int col, char[][] board, List<List<String>> result) {
        if (col == board.length) {
            List<String> res = new ArrayList<>();
            for (char[] aBoard : board) {
                String s = new String(aBoard);
                res.add(s);
            }
            result.add(res);
            return;
        }

        for (int i = 0; i < board.length; i++) {
            //对于每一行, 从第一列开始, 进行检查. 与回溯查找
            if (validate(col, i, board)) {
                board[i][col] = 'Q';
                solve(col + 1, board, result);
                board[i][col] = '.';
            }
        }
    }

    private boolean validate(int col, int row, char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'Q' && (col + row == i + j || col + i == row + j || row == i)) {//当前单元格有Q, 且位于同一行列或者斜线
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new NQueues().solveNQueens(8).size());

    }
}
