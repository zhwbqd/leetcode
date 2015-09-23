package zhwb.study.algorithms.array.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutation-sequence/
 * <p/>
 * The set [1,2,3,бн,n] contains a total of n! unique permutations.
 * <p/>
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * <p/>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * <p/>
 * Note: Given n will be between 1 and 9 inclusive.
 *
 * @author jack.zhang
 * @since 2015/9/23 0023
 */
public class PermutationSeq {
    public String getPermutation(int n, int k) {
        List<Integer> participate = new ArrayList<>(n);
        if (n <= 1) {
            return "1";
        }
        for (int i = 1; i <= n; i++) {
            participate.add(i);//build an initial list
        }
        return recur(n, k - 1, participate, new StringBuilder(n));//k-1 for get element from list
    }

    private String recur(int n, int k, List<Integer> participate, StringBuilder sb) {
        if (n == 2) {
            sb.append(participate.get(k));
            participate.remove(k);
            sb.append(participate.get(participate.size() - 1));
            return sb.toString();
        }
        int x = fac(n); // x: sequence length Example: n = 5, there are 5 sequences start with 1 to 5, each sequence has 24 items
        int i = k / x; // i: which sequence the search k it belong. Example: n=4 k=8, i=(8-1)/6=1. so the start number should be 2
        sb.append(participate.get(i));
        participate.remove(i);
        return recur(n - 1, k % x, participate, sb);
    }

    private int fac(int n) {
        int sum = 1;
        for (int i = 1; i < n; i++) {
            sum *= i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new PermutationSeq().getPermutation(5, 120));
    }
}
