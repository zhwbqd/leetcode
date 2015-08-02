package zhwb.study.algorithms.string;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 * <p/>
 * Implement regular expression matching with support for '.' and '*'.
 * <p/>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * <p/>
 * The matching should cover the entire input string (not partial).
 * <p/>
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * <p/>
 * Some examples:
 * isMatch("aa","a") ¡ú false
 * isMatch("aa","aa") ¡ú true
 * isMatch("aaa","aa") ¡ú false
 * isMatch("aa", "a*") ¡ú true
 * isMatch("aa", ".*") ¡ú true
 * isMatch("ab", ".*") ¡ú true
 * isMatch("aab", "c*a*b") ¡ú true
 *
 * @author jack.zhang
 * @since 2015/8/2 0002
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        if (p.length() == 1 || p.charAt(1) != '*') {
            if (s.isEmpty() || (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0))) {
                return false;
            } else {
                return isMatch(s.substring(1), p.substring(1));
            }
        }

        //P.length() >=2
        while (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
            if (isMatch(s, p.substring(2))) {
                return true;
            }
            s = s.substring(1);
        }

        return isMatch(s, p.substring(2));
    }

    public static void main(String[] args) {
//        System.out.println(new RegularExpressionMatching().isMatch("aab", "c*a*b"));
//        System.out.println(new RegularExpressionMatching().isMatch("aab", "aab"));
        System.out.println(new RegularExpressionMatching().isMatch("aab", "aab*a*"));
    }
}
