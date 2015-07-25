package zhwb.study.algorithms.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * <p/>
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 *
 * @author jack.zhang
 * @since 2015/7/25 0025
 */
public class LongestSubStringWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        int start = 0;
        int currentLength = 0;
        Map<Character, Integer> charIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer previousIndex = charIndex.put(s.charAt(i), i); //找到之前相同元素的index
            if (previousIndex != null && previousIndex >= start) { //之前相同元素index如果大于起始值说明后续又有重复字段, 否则说明重复字段被忽略
                max = Math.max(currentLength, max);
                start = previousIndex + 1;  //重复后将当前起始点设置到下一个字符处
                currentLength = i - previousIndex;
            } else {
                currentLength++;
            }
        }
        return Math.max(currentLength, max);
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubStringWithoutRepeat().lengthOfLongestSubstring("abcabcbb"));//3
        System.out.println(new LongestSubStringWithoutRepeat().lengthOfLongestSubstring("abc"));//3
        System.out.println(new LongestSubStringWithoutRepeat().lengthOfLongestSubstring("aab"));//2
        System.out.println(new LongestSubStringWithoutRepeat().lengthOfLongestSubstring("pwwkew"));//3
        System.out.println(new LongestSubStringWithoutRepeat().lengthOfLongestSubstring("dvdf"));//3
        System.out.println(new LongestSubStringWithoutRepeat().lengthOfLongestSubstring("abba"));//2
        System.out.println(new LongestSubStringWithoutRepeat().lengthOfLongestSubstring("cdd"));//2
    }
}
