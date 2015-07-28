package zhwb.study.algorithms.string;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 * <p/>
 * Implement atoi to convert a string to an integer.
 * <p/>
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * <p/>
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 * <p/>
 * Update (2015-02-10):
 * The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
 * <p/>
 * spoilers alert... click to show requirements for atoi.
 * <p/>
 * Requirements for atoi:
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 * <p/>
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 * <p/>
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * <p/>
 * If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 *
 * @author jack.zhang
 * @since 2015/7/28 0028
 */
public class Atoi {

    public int myAtoi(String str) {
        if (str == null || str.length() == 0 || str.trim().length() == 0) {
            return 0;
        }

        int index = 0;
        while (str.charAt(index) == ' ') {
            index++;
        }
        int sign = 1;
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1 : str.charAt(index) == '-' ? -1 : 1;
            index++;
        }
        int total = 0;
        while (index < str.length()) {
            int digit = str.charAt(index) - '0';
            if (digit < 0 || digit > 9) break;

            if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            index++;
        }
        return total * sign;
    }

    public static void main(String[] args) {
//        System.out.println(new Atoi().myAtoi("-321"));
//        System.out.println(new Atoi().myAtoi("2147483648"));
        System.out.println(new Atoi().myAtoi("-2147483647"));
    }
}
