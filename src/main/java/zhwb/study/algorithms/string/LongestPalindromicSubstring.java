package zhwb.study.algorithms.string;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * <p/>
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 *
 * @author jack.zhang
 * @since 2015/7/25 0025
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        int longestLen = 0;
        int longestIndex = 0;

        // find the longest length
        for (int currentIndex = 0; currentIndex < n; currentIndex++) {
            if (isPalindrome(s, currentIndex - longestLen, currentIndex)) {
                longestLen += 1;
                longestIndex = currentIndex;
            } else if (currentIndex - longestLen - 1 >= 0 &&
                    isPalindrome(s, currentIndex - longestLen - 1, currentIndex)) {
                longestLen += 2;
                longestIndex = currentIndex;
            }
        }
        longestIndex++;
        return s.substring(longestIndex - longestLen, longestIndex);
    }

    public boolean isPalindrome(String s, int startIndex, int endIndex) {
        for (int i = startIndex, j = endIndex; i <= j; i++, j--)
            if (s.charAt(i) != s.charAt(j)) return false;
        return true;
    }

    public String longestPalindromeV2(String s) {
        if (s.isEmpty()) return "";
        if (s.length() == 1) return s;
        int min_start = 0, max_len = 1;
        for (int i = 0; i < s.length(); ) {
            if (s.length() - i <= max_len / 2) break;
            int j = i, k = i;
            while (k < s.length() - 1 && s.charAt(k + 1) == s.charAt(k)) ++k; // Skip duplicate characters.
            i = k + 1;
            while (k < s.length() - 1 && j > 0 && s.charAt(k + 1) == s.charAt(j - 1)) {
                ++k;
                --j;
            } // Expand.
            int new_len = k - j + 1;
            if (new_len > max_len) {
                min_start = j;
                max_len = new_len;
            }
        }
        return s.substring(min_start, min_start + max_len);
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindromeV2("abcba"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("a"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("ccc"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("abb"));
        System.out.println(new LongestPalindromicSubstring().longestPalindromeV2("bananas"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("eabcb"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("aaabaaaa"));
    }
}
