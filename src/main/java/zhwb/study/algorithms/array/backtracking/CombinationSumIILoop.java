package zhwb.study.algorithms.array.backtracking;

import java.util.*;

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
public class CombinationSumIILoop {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> result = new LinkedHashSet<>();
        Arrays.sort(candidates);

        Stack<Integer> com = new Stack<>();
        Stack<Integer> indexs = new Stack<>();
        int sum = 0, index = 0;
        while (index < candidates.length) {
            if (sum + candidates[index] >= target) {
                if (sum + candidates[index] == target) {
                    com.push(candidates[index]);
                    result.add(new ArrayList<>(com));
                    com.pop();
                }
                if (!indexs.isEmpty()) {
                    sum -= com.pop();
                    index = indexs.pop();
                }
            } else {
                sum += candidates[index];
                com.push(candidates[index]);
                indexs.push(index);
            }
            while (index == candidates.length - 1 && !indexs.empty()) {
                index = indexs.pop();
                sum -= com.pop();
            }
            index++;
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
//        System.out.println(new CombinationSumIILoop().combinationSum2(new int[]{1, 1, 2, 5, 6, 7, 10}, 8));
        System.out.println(new CombinationSumIILoop().combinationSum2(new int[]{1, 1, 1, 3, 3, 5}, 8));
    }
}
