package zhwb.study.algorithms.array.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
public class CombinationSumRecursive {

    public List<List<Integer>> combinationSum(final int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        //核心思路: 每个元素叠加后将target-candidate[i]作为新的target, 继续查找, 直至target<=0 当前递归退出.
        subComb(candidates, result, new ArrayList<Integer>(), 0, target);

        return result;
    }

    private void subComb(int[] candidates, List<List<Integer>> result, List<Integer> current, int i, int target) {
        if (target > 0) {
            for (int j = i; j < candidates.length && target >= candidates[j]; j++) {
                current.add(candidates[j]);
                subComb(candidates, result, current, j, target - candidates[j]);
                current.remove(current.size() - 1);
            }
        }else if (target == 0) {
            result.add(new ArrayList<>(current));
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSumLoop().combinationSum(new int[]{1, 2, 2, 3, 7, 8}, 7));
        System.out.println(new CombinationSumRecursive().combinationSum(new int[]{2, 3, 6, 7, 8}, 7));
    }
}
