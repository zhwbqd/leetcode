package zhwb.study.algorithms.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 * <p/>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p/>
 * For example, given n = 3, a solution set is:
 * <p/>
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 *
 * @author jack.zhang
 * @since 2015/8/18 0018
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        if (n < 0) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();
        recursive(n, n, "", result);
        return result;
    }

    private void recursive(int left, int right, String s, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }
        if (left > 0) {
            recursive(left - 1, right, s + "(", result);
        }
        if (right > left) {
            recursive(left, right - 1, s + ")", result);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }

}
