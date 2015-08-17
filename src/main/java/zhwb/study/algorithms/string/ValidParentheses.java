package zhwb.study.algorithms.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * <p/>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p/>
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 * @author jack.zhang
 * @since 2015/8/17 0017
 */
public class ValidParentheses {

    Map<Character, Character> characterMap = new HashMap<Character, Character>(){{
        put(')', '(');
        put(']', '[');
        put('}', '{');
    }};

    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            if (item == ')' || item == ']' || item == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (pop != characterMap.get(item)) {
                    return false;
                }
            } else {
                stack.push(item);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("{({[]})}"));
        System.out.println(new ValidParentheses().isValid("(("));
    }
}
