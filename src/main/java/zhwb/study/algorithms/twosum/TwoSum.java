package zhwb.study.algorithms.twosum;

import java.util.*;

/**
 * https://leetcode.com/problems/two-sum/
 * <p/>
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * Please note that your returned answers (both index1 and index2) are not zero-based.You may assume that each input would have exactly one solution.
 * <p/>
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 *
 * @author jack.zhang
 * @since 2015/7/15
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer val = map.get(target - nums[i]);
            if (val != null && val > i + 1)
                return new int[]{i + 1, val};
        }
        return new int[2];
    }

    public int[] twoSumV2(int[] nums, int target) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(nums.length);
        for (int num : nums) {
            if (num < target) {
                queue.add(num);
            }
        }

        List<Integer> array = new ArrayList<>(queue);
        for (int i = 0; i < array.size() - 1; i++) {
            for (int j = i + 1; j < array.size(); j++) {
                if (array.get(i) + array.get(j) == target) {
                    return new int[]{array.get(i), array.get(j)};
                }
            }
        }
        return new int[2];//this is wrong because it get the value, not the index
    }

    public static void main(String[] args) {
        int[] ints = new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

        ints = new TwoSum().twoSum(new int[]{3, 2, 4}, 6);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }
}
