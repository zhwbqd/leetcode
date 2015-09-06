package zhwb.study.algorithms.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/first-missing-positive/
 * <p/>
 * Given an unsorted integer array, find the first missing positive integer.
 * <p/>
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * <p/>
 * Your algorithm should run in O(n) time and uses constant space.
 *
 * @author jack.zhang
 * @since 2015/9/6
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        Arrays.sort(nums);
        int n = 0;//below zero
        int i = 0;
        for (; i < nums.length - 1; i++) {
            if (nums[i] <= 0) {
                n++;
                continue;
            }
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            if (nums[i] + 1 != nums[i + 1]) {
                break;
            }
        }
        if (nums[n] != 1) {
            return 1;
        }
        if (i < nums.length - 1) {
            return nums[i] + 1;
        } else {
            return nums[nums.length - 1] + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{1, 2, 0}));//3
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{3, 4, -1, 1}));//2
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{1000, -1}));//1
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{2}));//1
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{1}));//2
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{2, 2}));//1
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{0, 2, 2, 1, 1}));//3
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{2, 2, 4}));//1
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{-1, 0, 2}));//1
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{1000, 1}));//2
    }

}
