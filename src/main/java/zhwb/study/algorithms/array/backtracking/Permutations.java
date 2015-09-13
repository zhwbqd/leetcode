package zhwb.study.algorithms.array.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 * <p/>
 * Given a collection of numbers, return all possible permutations.
 * <p/>
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 *
 * @author jack.zhang
 * @since 2015/9/13 0013
 */
public class Permutations {

    public List<List<Integer>> permute(final int[] nums) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        res.add(new ArrayList<Integer>());
        for (int n : nums) {
            int size = res.size();
            for (; size > 0; size--) {
                List<Integer> r = res.pollFirst();
                for (int i = 0; i <= r.size(); i++) {
                    List<Integer> t = new ArrayList<>(r);
                    t.add(i, n);
                    res.add(t);
                }
            }
        }
        return res;
    }

    public List<List<Integer>> permuteBackTracking(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(result, 0, nums);
        return result;
    }

    private void permute(List<List<Integer>> result, int start, int[] array) {
        if (start == array.length) {
            List<Integer> current = new ArrayList<>();
            for (int a : array) {
                current.add(a);
            }
            result.add(current);
        } else {
            //每次列头交换位置, 递归, 再恢复位置, 回溯查找
            for (int i = start; i < array.length; i++) {
                swap(array, start, i);
                permute(result, start + 1, array);
                swap(array, start, i);
            }
        }
    }

    public List<List<Integer>> permuteBackTrackingV2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permute(result, current, nums, visited);
        return result;
    }

    private void permute(List<List<Integer>> result, List<Integer> current, int[] num, boolean[] visited) {
        if (current.size() == num.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                current.add(num[i]);
                permute(result, current, num, visited);
                current.remove(current.size() - 1);
                visited[i] = false;
            }
        }
    }


    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new Permutations().permuteBackTracking(new int[]{1, 2, 3}));
        System.out.println(new Permutations().permute(new int[]{1, 2, 3}));
        System.out.println(new Permutations().permuteBackTrackingV2(new int[]{1, 2, 3}));
    }

}
