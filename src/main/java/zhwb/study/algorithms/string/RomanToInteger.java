package zhwb.study.algorithms.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/
 * <p/>
 * Given a roman numeral, convert it to an integer.
 * <p/>
 * Input is guaranteed to be within the range from 1 to 3999.
 * <p/>
 * I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1,000
 *
 * @author jack.zhang
 * @since 2015/8/9 0009
 */
public class RomanToInteger {

    private Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        if (s == null || s.isEmpty()) return 0;
        if (s.length() == 1) {
            return map.get(s.charAt(0));
        }

        int i = 0;
        int result = 0;
        while (i < s.length()) {
            Integer current = map.get(s.charAt(i));
            Integer forward = 0;
            int j = i + 1;
            if (j < s.length()) {
                forward = map.get(s.charAt(j));
            }
            if (current >= forward) {
                result += current;
                i++;
            } else {
                result += forward - current;
                i += 2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt("I"));
        System.out.println(new RomanToInteger().romanToInt("IV"));
        System.out.println(new RomanToInteger().romanToInt("XXVI"));
        System.out.println(new RomanToInteger().romanToInt("XVI"));
        System.out.println(new RomanToInteger().romanToInt("DCXXI"));
        System.out.println(new RomanToInteger().romanToInt("MCMXCVI"));
    }
}
