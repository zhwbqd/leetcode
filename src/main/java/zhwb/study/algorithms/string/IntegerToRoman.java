package zhwb.study.algorithms.string;

/**
 * https://leetcode.com/problems/integer-to-roman/
 * <p/>
 * Given an integer, convert it to a roman numeral.
 * <p/>
 * Input is guaranteed to be within the range from 1 to 3999.
 * <p/>
 *
 * @author jack.zhang
 * @since 2015/8/5 0005
 */
public class IntegerToRoman {

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        int remain = num;
        remain = handle(sb, remain, 1000, "M", 100, "C");
        remain = handle(sb, remain, 500, "D", 100, "C");
        remain = handle(sb, remain, 100, "C", 10, "X");
        remain = handle(sb, remain, 50, "L", 10, "X");
        remain = handle(sb, remain, 10, "X", 1, "I");
        remain = handle(sb, remain, 5, "V", 1, "I");
        handle(sb, remain, 1, "I", 0, "");
        return sb.toString();
    }

    private int handle(StringBuilder sb, int num, int div, String sign, int subDiv, String subSign) {
        int factor;
        int remainder;
        int temp = div - subDiv;
        if (num >= temp) {
            factor = num / div;
            remainder = num % div;
            for (int i = 0; i < factor; i++) {
                sb.append(sign);
            }
            if (remainder >= temp) {
                sb.append(subSign).append(sign);
                remainder -= temp;
            }
            return remainder;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new IntegerToRoman().intToRoman(29));
        System.out.println(new IntegerToRoman().intToRoman(24));
        System.out.println(new IntegerToRoman().intToRoman(26));
        System.out.println(new IntegerToRoman().intToRoman(20));
        System.out.println(new IntegerToRoman().intToRoman(1));
        System.out.println(new IntegerToRoman().intToRoman(9));
        System.out.println(new IntegerToRoman().intToRoman(40));
        System.out.println(new IntegerToRoman().intToRoman(41));//XLI
    }
}
