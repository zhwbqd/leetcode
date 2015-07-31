package zhwb.study.algorithms.number;

/**
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 * <p/>
 * Given an integer n, return the number of trailing zeroes in n!.
 * <p/>
 * Note: Your solution should be in logarithmic time complexity.
 *
 * @author jack.zhang
 * @since 2015/7/22 0022
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        if (n == 0) {
            return 0;
        }

        int result = 0;
        while (n  > 0) {
            n = n / 5;
            result+=n;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(20));
    }
}
