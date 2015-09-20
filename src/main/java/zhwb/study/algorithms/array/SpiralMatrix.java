package zhwb.study.algorithms.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 * <p/>
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p/>
 * For example,
 * Given the following matrix:
 * <p/>
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 *
 * @author jack.zhang
 * @since 2015/9/16 0016
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();

        if (matrix.length == 0) {
            return res;
        }

        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            //ио
            for (int j = colBegin; j <= colEnd; j++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            //ср
            for (int j = rowBegin; j <= rowEnd; j++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;

            //об
            if (rowBegin <= rowEnd) {
                for (int j = colEnd; j >= colBegin; j--) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            //вС
            if (colBegin <= colEnd) {
                for (int j = rowEnd; j >= rowBegin; j--) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin++;
        }

        return res;
    }
}
