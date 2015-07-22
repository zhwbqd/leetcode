package zhwb.study.algorithms.string;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 * <p>
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * @author jack.zhang
 * @since 2015/7/22
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = findCommonPrefix(prefix, strs[i]);
        }
        return prefix;
    }

    private String findCommonPrefix(String prefix, String str) {
        int length = Math.min(prefix.length(), str.length());
        String result = "";
        for (int i = 0; i < length; i++) {
            if (prefix.charAt(i) == str.charAt(i)) {
                result += prefix.charAt(i);
            } else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestCommonPrefix prefix = new LongestCommonPrefix();
        System.out.println(prefix.longestCommonPrefix(new String[]{"abcd", "abc", "abcde"}));
        System.out.println(prefix.longestCommonPrefix(new String[]{"a", "b"}));
    }
}
