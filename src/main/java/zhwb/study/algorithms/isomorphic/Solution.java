package zhwb.study.algorithms.isomorphic;

import java.util.*;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * <p/>
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * <p/>
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 * <p/>
 * For example,
 * Given "egg", "add", return true.
 * <p/>
 * Given "foo", "bar", return false.
 * <p/>
 * Given "paper", "title", return true.
 *
 * @author jack.zhang
 * @since 2015/7/19 0019
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Boolean> sMap = new LinkedHashMap<>(s.length());
        Map<Character, Boolean> tMap = new LinkedHashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (sMap.get(s.charAt(i)) == null) {
                sMap.put(s.charAt(i), false);
            } else {
                sMap.put(s.charAt(i), true);
            }

            if (tMap.get(t.charAt(i)) == null) {
                tMap.put(t.charAt(i), false);
            } else {
                tMap.put(t.charAt(i), true);
            }
        }

        List<Boolean> sb = new ArrayList<>(s.length());
        for (Boolean aBoolean : sMap.values()) {
            sb.add(aBoolean);
        }
        List<Boolean> tb = new ArrayList<>(t.length());
        for (Boolean aBoolean : tMap.values()) {
            tb.add(aBoolean);
        }

        return sb.equals(tb);
    }

    public boolean isIsomorphicV2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] mapping = new int[Character.MAX_SURROGATE];
        boolean[] isUsed = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            if (mapping[s.codePointAt(i)] == 0) {
                if (isUsed[t.codePointAt(i)]) {
                    return false;
                } else {
                    mapping[s.codePointAt(i)] = t.codePointAt(i);
                    isUsed[t.codePointAt(i)] = true;
                }
            } else {
                if (mapping[s.codePointAt(i)] != t.codePointAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isIsomorphicV2("add", "egg"));
        System.out.println(new Solution().isIsomorphic("aba", "baa"));
        System.out.println(new Solution().isIsomorphicV2("aba", "baa"));

    }
}
