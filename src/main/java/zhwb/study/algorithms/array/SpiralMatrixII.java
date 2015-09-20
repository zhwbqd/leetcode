package zhwb.study.algorithms.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/spiral-matrix-ii/
 * <p/>
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * <p/>
 * For example,
 * Given n = 3,
 * <p/>
 * You should return the following matrix:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 *
 * @author jack.zhang
 * @since 2015/9/20 0020
 */
public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int i = 1;

        int rowBegin = 0;
        int rowEnd = n - 1;
        int colBegin = 0;
        int colEnd = n - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int j = colBegin; j <= colEnd; j++) {
                res[rowBegin][j] = i++;
            }
            rowBegin++;
            for (int j = rowBegin; j <= rowEnd; j++) {
                res[j][colEnd] = i++;
            }
            colEnd--;
            for (int j = colEnd; j >= colBegin; j--) {
                res[rowEnd][j] = i++;
            }
            rowEnd--;
            for (int j = rowEnd; j >= rowBegin; j--) {
                res[j][colBegin] = i++;
            }
            colBegin++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SpiralMatrixII().generateMatrix(4)));
    }

}
