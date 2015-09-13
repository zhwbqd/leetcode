package zhwb.study.algorithms.string;

import java.util.*;

/**
 * https://leetcode.com/problems/anagrams/
 * <p/>
 * Given an array of strings, group anagrams together.
 * <p/>
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 * <p/>
 * [
 * ["ate", "eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note:
 * For the return value, each inner list's elements must follow the lexicographic order.
 * All inputs will be in lower-case.
 * Update (2015-08-09):
 * The signature of the function had been updated to return list<list<string>> instead of list<string>, as suggested here.
 * If you still see your function signature return a list<string>, please click the reload button  to reset your code definition.
 *
 * @author jack.zhang
 * @since 2015/9/13 0013
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Queue<String>> result = new HashMap<>();

        for (String str : strs) {
            String cal = cal(str);
            Queue<String> list = result.get(cal);
            if (list == null) {
                list = new PriorityQueue<>();
                result.put(cal, list);
            }
            list.add(str);
        }

        List<List<String>> r = new ArrayList<>();
        for (Queue<String> value : result.values()) {
            List<String> a = new ArrayList<>();
            while (value.size() > 0) {
                a.add(value.poll());
            }
            r.add(a);
        }
        return r;
    }

    private String cal(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
