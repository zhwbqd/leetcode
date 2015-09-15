package zhwb.study.algorithms.array;

/**
 * https://leetcode.com/problems/maximum-subarray/
 * <p/>
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * <p/>
 * For example, given the array [?2,1,?3,4,?1,2,1,?5,4],
 * the contiguous subarray [4,?1,2,1] has the largest sum = 6.
 * <p/>
 * click to show more practice.
 * <p/>
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *
 * @author jack.zhang
 * @since 2015/9/15 0015
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int current = 0;
        int min = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num <= 0) {
                min = Math.max(min, num);
            }
            current = Math.max(current + num, 0);
            max = Math.max(max, current);
        }
        if (max == 0) {
            return min;
        }
        return max;
    }

    public int maxSubArrayV2(int[] A) {
        int max = A[0], curMax = A[0];
        for (int i = 1; i < A.length; i++) {
            curMax = Math.max(curMax, 0) + A[i];
            max = Math.max(max, curMax);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSubarray().maxSubArrayV2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(new MaximumSubarray().maxSubArrayV2(new int[]{-2, -1}));
        System.out.println(new MaximumSubarray().maxSubArrayV2(new int[]{-1, 0}));
    }
}
