package zhwb.study.algorithms.number;

/**
 * https://leetcode.com/problems/powx-n/
 *
 * Implement pow(x, n).
 *
 * Date: 15/7/13
 * Time: 下午10:08
 *
 * @author jack.zhang
 */
public class Pow {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) :  x * myPow(x * x, n / 2);
    }

    public double myPowV2(double x, int n) {
        if (n == 0) {
            return 1;
        }        double result = 1;
        if (n < 0) {
            x = 1 / x;
        }

        while (n > 0) {
            result = result * x;
            n--;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Pow().myPow(8.88023, 3) == 490394.15536);
        System.out.println(new Pow().myPowV2(1, 1));
        System.out.println(new Pow().myPow(1, -1));
    }

}
