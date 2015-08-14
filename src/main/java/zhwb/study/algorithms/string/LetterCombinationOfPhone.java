package zhwb.study.algorithms.string;

import java.util.*;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * <p/>
 * Given a digit string, return all possible letter combinations that the number could represent.
 * <p/>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * <p/>
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 * @author jack.zhang
 * @since 2015/8/14 0014
 */
public class LetterCombinationOfPhone {

    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<String>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (result.peek().length() == i) {
                String t = result.remove();//出列
                for (char s : mapping[x].toCharArray())
                    result.add(t + s);//入列
            }
        }
        return result;
    }
}
