package zhwb.study.algorithms.array.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p/>
 * Each number in C may only be used once in the combination.
 * <p/>
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 * A solution set is:
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 *
 * @author jack.zhang
 * @since 2015/9/5 0005
 */
public class CombinationSumIIRecursive {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);

        subComb(candidates, result, new ArrayList<Integer>(), 0, target);
        return result;
    }

    private void subComb(int[] candidates, List<List<Integer>> result, ArrayList<Integer> current, int start, int target) {
        if (target > 0) {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i-1]) continue;//avoid duplicate
                current.add(candidates[i]);
                subComb(candidates, result, current, i + 1, target - candidates[i]);
                current.remove(current.size() - 1);
            }
        } else if (target == 0) {
            result.add(new ArrayList<>(current));
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSumIIRecursive().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
