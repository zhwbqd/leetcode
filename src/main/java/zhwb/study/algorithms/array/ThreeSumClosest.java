package zhwb.study.algorithms.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/
 * <p/>
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p/>
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * <p/>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * @author jack.zhang
 * @since 2015/8/13 0013
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int result = target;
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int temp_sum = nums[i] + nums[start] + nums[end];

                if (target < temp_sum) {
                    if (temp_sum - target < min) {
                        min = temp_sum - target;
                        result = temp_sum;
                    }
                    while (start < end && nums[end] == nums[end - 1]) {
                        end--;
                    }
                    end--;
                } else if (target > temp_sum) {
                    if (target - temp_sum < min) {
                        min = target - temp_sum;
                        result = temp_sum;
                    }
                    while (start < end && nums[start] == nums[start + 1]) {
                        start++;
                    }
                    start++;
                } else return target;
            }
        }
        return result;
    }
}
