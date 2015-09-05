package zhwb.study.algorithms.string;

/**
 * https://leetcode.com/problems/count-and-say/
 * <p/>
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * <p/>
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * <p/>
 * Note: The sequence of integers will be represented as a string.
 * <p/>
 * FUCK THE DESCRIPTION
 * <p/>
 * At the beginning, I got confusions about what is the nth sequence.
 * Well, my solution is accepted now, so I'm going to give some examples of nth sequence here. The following are sequence from n=1 to n=10:
 * <p/>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 6.     312211
 * 7.     13112221
 * 8.     1113213211
 * 9.     31131211131221
 * 10.   13211311123113112211
 * From the examples you can see, the (i+1)th sequence is the "count and say" of the ith sequence!
 * <p/>
 * Hope this helps!
 *
 * @author jack.zhang
 * @since 2015/9/5 0005
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = countIdx(s);
        }
        return s;
    }

    public String countIdx(String s) {
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            } else {
                sb.append(count);
                sb.append(c);
                c = s.charAt(i);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(c);
        return sb.toString();
    }

    public String countAndSayOriginDesc(int n) {
        String s = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        int c = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                c++;
            } else {
                sb.append(c).append(s.charAt(i - 1));
                c = 1;
            }
        }
        sb.append(c).append(s.charAt(s.length() - 1));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(1));
        System.out.println(new CountAndSay().countAndSay(5));
        System.out.println(new CountAndSay().countAndSayOriginDesc(5));
    }
}
