package zhwb.study.algorithms.number;

/**
 * https://leetcode.com/discuss/49197/80ms-simple-code
 *
 * @author jack.zhang
 * @since 2015/7/31 0031
 */
public class PalindromeNum {

    public boolean isPalindrome(int x) {
        int revert = 0;
        int origin = x;
        while (origin > 0) {
            revert = revert * 10 + origin % 10;
            origin /= 10;
        }
        return revert == x;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeNum().isPalindrome(121));
    }
}
