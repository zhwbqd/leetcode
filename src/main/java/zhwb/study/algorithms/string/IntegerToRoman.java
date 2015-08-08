package zhwb.study.algorithms.string;

/**
 * https://leetcode.com/problems/integer-to-roman/
 * <p/>
 * Given an integer, convert it to a roman numeral.
 * <p/>
 * Input is guaranteed to be within the range from 1 to 3999.
 * <p/>
 * 罗马数字共有7个，即I（1）、V（5）、X（10）、L（50）、C（100）、D（500）和M（1000）。
 * 按照下述的规则可以表示任意正整数。需要注意的是罗马数字中没有“0”，与进位制无关。一般认为罗马数字只用来记数，而不作演算。
 * <p/>
 * 重复数次：一个罗马数字重复几次，就表示这个数的几倍。
 * 右加左减：
 * 在较大的罗马数字的右边记上较小的罗马数字，表示大数字加小数字。
 * 在较大的罗马数字的左边记上较小的罗马数字，表示大数字减小数字。
 * 左减的数字有限制，仅限于I、X、C。比如45不可以写成VL，只能是XLV
 * 但是，左减时不可跨越一个位数。比如，99不可以用IC（100 - 1）表示，而是用XCIX（[100 - 10] + [10 - 1]）表示。（等同于阿拉伯数字每位数字分别表示。）
 * 左减数字必须为一位，比如8写成VIII，而非IIX。
 * 右加数字不可连续超过三位，比如14写成XIV，而非XIIII。（见下方“数码限制”一项。）
 * 加线乘千：
 * 在罗马数字的上方加上一条横线或者加上下标的?，表示将这个数乘以1000，即是原数的1000倍。
 * 同理，如果上方有两条横线，即是原数的1000000（1000^{2}）倍。
 * 数码限制：
 * 同一数码最多只能出现三次，如40不可表示为XXXX，而要表示为XL。
 * 例外：由于IV是古罗马神话主神朱庇特（即IVPITER，古罗马字母里没有J和U）的首字，因此有时用IIII代替IV。
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
