package zhwb.study.algorithms.string;

import java.util.Stack;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 * <p/>
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * <p/>
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * <p/>
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 *
 * @author jack.zhang
 * @since 2015/9/2
 */
public class LongestValidParenthesis {
    public int longestValidParentheses(String s) {
        int max = Integer.MIN_VALUE;
        s += "x";
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && !stack.empty() && s.charAt(stack.peek()) == '(')
                stack.pop();
            else {
                if (stack.empty()) {
                    max = Math.max(max, i);
                } else {
                    max = Math.max(max, i - stack.peek() - 1);
                }
                stack.push(i);
            }
        }
        return stack.empty() ? s.length() : max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestValidParenthesis().longestValidParentheses(")()())"));
        System.out.println(new LongestValidParenthesis().longestValidParentheses("()()"));
        System.out.println(new LongestValidParenthesis().longestValidParentheses("(()))"));
        System.out.println(new LongestValidParenthesis().longestValidParentheses("()(()"));
        System.out.println(new LongestValidParenthesis().longestValidParentheses(")("));
        System.out.println(new LongestValidParenthesis().longestValidParentheses("(()"));
    }
}
