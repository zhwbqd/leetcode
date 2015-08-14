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
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    if (sum - target < min) {
                        min = sum - target;
                        result = sum;
                    }
                    end--;
                } else {
                    if (target - sum < min) {
                        min = target - sum;
                        result = sum;
                    }
                    start++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{-1, 2, 1, -4}, 1));//2
        System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{0, 2, 1, -3}, 1));//0
        System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{0, 1,2}, 0));//3
    }
}
