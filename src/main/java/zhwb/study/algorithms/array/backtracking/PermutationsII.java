package zhwb.study.algorithms.array.backtracking;

import java.util.*;

/**
 * https://leetcode.com/problems/permutations-ii/
 * <p/>
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p/>
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 *
 * @author jack.zhang
 * @since 2015/9/13 0013
 */
public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] visited = new boolean[num.length];
        permute(result, current, num, visited);
        return result;
    }

    private void permute(List<List<Integer>> result, List<Integer> current, int[] num, boolean[] visited) {
        if (current.size() == num.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i=0; i<visited.length; i++) {
            if (!visited[i]) {
                if (i > 0 && num[i] == num[i-1] && visited[i-1]) {
                    return;
                }
                //递归前设置, 递归后归零, 典型的回溯思路
                visited[i] = true;
                current.add(num[i]);
                permute(result, current, num, visited);
                current.remove(current.size()-1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new PermutationsII().permuteUnique(new int[]{3,3,0,0,2,3,2}).size());
    }
}
