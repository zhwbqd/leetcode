package zhwb.study.algorithms.string;

import java.util.*;

/**
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 * <p/>
 * You are given a string, s, and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once
 * and without any intervening characters.
 * <p/>
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * <p/>
 * You should return the indices: [0,9].
 * (order does not matter).
 * <p/>
 * Date: 15/8/29
 * Time: ����2:13
 *
 * @author jack.zhang
 */
public class SubstringwithConcatenation {

    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> res = new LinkedList<>();
        if (L.length == 0 || S.length() < L.length * L[0].length()) return res;
        int sLength = S.length(), length = L.length, gap = L[0].length();
        Map<String, Integer> map = new HashMap<>(), curMap = new HashMap<>();
        for (String s : L) {
            if (map.containsKey(s)) map.put(s, map.get(s) + 1);
            else map.put(s, 1);
        }
        String str = null, tmp = null;
        for (int i = 0; i < gap; i++) {
            int count = 0;  // remark: reset count
            for (int l = i, r = i; r + gap <= sLength; r += gap) {
                str = S.substring(r, r + gap);
                if (map.containsKey(str)) {
                    if (curMap.containsKey(str)) curMap.put(str, curMap.get(str) + 1);
                    else curMap.put(str, 1);

                    if (curMap.get(str) <= map.get(str)) count++;
                    while (curMap.get(str) > map.get(str)) {
                        tmp = S.substring(l, l + gap);
                        curMap.put(tmp, curMap.get(tmp) - 1);
                        l += gap;
                        if (curMap.get(tmp) < map.get(tmp)) count--;
                    }
                    if (count == length) {
                        res.add(l);
                        tmp = S.substring(l, l + gap);
                        curMap.put(tmp, curMap.get(tmp) - 1);
                        l += gap;
                        count--;
                    }
                } else {
                    curMap.clear();
                    count = 0;
                    l = r + gap;
                }
            }
            curMap.clear();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SubstringwithConcatenation().findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(new SubstringwithConcatenation().findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
        System.out.println(new SubstringwithConcatenation().findSubstring("aaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaa", new String[]{"a",
                "a",
                "a",
                "a",
                "a",
                "a",
                "a",
                "a"}));
    }

}
