package zhwb.study.algorithms.array.backtracking;

import java.util.*;

/**
 * https://leetcode.com/problems/combination-sum/
 * <p/>
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p/>
 * The same repeated number may be chosen from C unlimited number of times.
 * <p/>
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 * [7]
 * [2, 2, 3]
 *
 * @author jack.zhang
 * @since 2015/9/5 0005
 */
public class CombinationSumLoop {

    public List<List<Integer>> combinationSum(final int[] candidates, int target) {
        Set<List<Integer>> result = new LinkedHashSet<>();
        Arrays.sort(candidates);

        Stack<Integer> comb = new Stack<>();
        Stack<Integer> indexs = new Stack<>();
        //核心思路: 每个元素自身叠加后相比较, 如果比target大, 则逐渐出栈与后续元素叠加. 使用两个栈, 一个用来保存值, 一个用来记录index
        int sum = 0, i = 0;
        while (i < candidates.length) {
            if (sum + candidates[i] >= target) {
                if (sum + candidates[i] == target) {
                    comb.push(candidates[i]);
                    result.add(new ArrayList<>(comb));
                    comb.pop();
                }
                if (!indexs.empty()) {
                    sum -= comb.pop();
                    i = indexs.pop();
                    while (i == candidates.length - 1 && !indexs.empty()) {
                        i = indexs.pop();
                        sum -= comb.pop();
                    }
                }
                i++;
            } else {
                comb.push(candidates[i]);
                sum += candidates[i];
                indexs.push(i);
            }
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSumLoop().combinationSum(new int[]{1, 2, 2, 3, 7, 8}, 7));
        System.out.println(new CombinationSumLoop().combinationSum(new int[]{2, 3, 6, 7, 8}, 7));
    }
}
