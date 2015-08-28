package zhwb.study.algorithms.number;

/**
 * https://leetcode.com/problems/divide-two-integers/
 * <p/>
 * Divide two integers without using multiplication, division and mod operator.
 * <p/>
 * If it is overflow, return MAX_INT.
 *
 * @author jack.zhang
 * @since 2015/8/28 0028
 */
public class DivideInteger {
    public int divide(int dividend, int divisor) {
        if (divisor == 1) return dividend;
        if (divisor == 0 || (dividend == Integer.MAX_VALUE && divisor == -1)) return Integer.MAX_VALUE;
        long dvd = Math.abs((long) dividend), delta = Math.abs((long) divisor), tims = 1, ans = 0;
        while (dvd >= delta) {
            tims <<= 1;
            delta <<= 1; //delta=tims*divisor
        }
        while (dvd > 0 && delta > 0) {
            while (dvd < delta) {
                tims >>= 1;
                delta >>= 1;
            }
            ans += tims;
            dvd -= delta;
        }
        if ((dividend > 0) ^ (divisor > 0)) {
            return -ans < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) -ans;
        } else {
            return ans > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) ans;
        }
    }

    public static void main(String[] args) {
//        System.out.println(new DivideInteger().divide(3, 2));
//        System.out.println(new DivideInteger().divide(4, 2));
        System.out.println(new DivideInteger().divide(5, 2));
//        System.out.println(new DivideInteger().divide(6, 2));
//        System.out.println(new DivideInteger().divide(1, 1));
        System.out.println(new DivideInteger().divide(-2147483648, -1));
    }
}
