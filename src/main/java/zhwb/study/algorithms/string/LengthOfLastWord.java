package zhwb.study.algorithms.string;

/**
 * https://leetcode.com/problems/length-of-last-word/
 * <p/>
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * <p/>
 * If the last word does not exist, return 0.
 * <p/>
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * <p/>
 * For example,
 * Given s = "Hello World",
 * return 5.
 *
 * @author jack.zhang
 * @since 2015/9/20 0020
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int l = 0;
        boolean ch = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (ch) {
                    return l;
                } else {
                    continue;
                }
            }
            ch = true;
            l++;
        }
        return l;
    }

    public int lengthOfLastWordV2(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord("Hello World"));
        System.out.println(new LengthOfLastWord().lengthOfLastWord("a "));
    }
}
