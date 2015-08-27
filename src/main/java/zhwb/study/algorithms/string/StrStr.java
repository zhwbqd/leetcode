package zhwb.study.algorithms.string;

/**
 * https://leetcode.com/problems/implement-strstr/
 * <p/>
 * Implement strStr().
 * <p/>
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p/>
 * Update (2014-11-02):
 * The signature of the function had been updated to return the index instead of the pointer.
 * If you still see your function signature returns a char * or String,
 * please click the reload button  to reset your code definition.
 *
 * @author jack.zhang
 * @since 2015/8/27
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length() && i + needle.length() <= haystack.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new StrStr().strStr("aaa", "aa"));
        System.out.println(new StrStr().strStr("a", "a"));
        System.out.println(new StrStr().strStr("a", ""));
        System.out.println(new StrStr().strStr("aaa", "aaaa"));
        System.out.println(new StrStr().strStr("mississippi", "issip"));
        System.out.println(new StrStr().strStr("mississippi", "issipi"));
    }
}
