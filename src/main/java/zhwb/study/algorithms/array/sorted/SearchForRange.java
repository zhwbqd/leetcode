package zhwb.study.algorithms.array.sorted;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/search-for-a-range/
 * <p/>
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * <p/>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p/>
 * If the target is not found in the array, return [-1, -1].
 * <p/>
 * For example,
 * Given [5, 7, 7, 8, 8,8, 10] and target value 8,
 * return [3, 5].
 *
 * @author jack.zhang
 * @since 2015/9/3 0003
 */
public class SearchForRange {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int hi = nums.length - 1;
        int lo = 0;
        while (lo <= hi) {
            int mid = (hi + lo) / 2;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                //move forward to find the first
                int temp = mid;

                for (; temp >= 0 && nums[temp] == target; temp--) {
                    result[0] = temp;
                }
                //move backward to find the last
                temp = mid;
                for (; temp < nums.length && nums[temp] == target; temp++) {
                    result[1] = temp;
                }

                if (result[1] == -1) {
                    result[1] = result[0];
                }
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new SearchForRange().searchRange(new int[]{5, 7, 7, 8, 8, 8, 10}, 8)));
//        System.out.println(Arrays.toString(new SearchForRange().searchRange(new int[]{2, 2}, 3)));
//        System.out.println(Arrays.toString(new SearchForRange().searchRange(new int[]{1}, 1)));
//        System.out.println(Arrays.toString(new SearchForRange().searchRange(new int[]{1, 2}, 2)));
//        System.out.println(Arrays.toString(new SearchForRange().searchRange(new int[]{3, 3}, 3)));
//        System.out.println(Arrays.toString(new SearchForRange().searchRange(new int[]{1, 2, 3}, 3)));
//        System.out.println(Arrays.toString(new SearchForRange().searchRange(new int[]{1, 1, 2}, 1)));
        System.out.println(Arrays.toString(new SearchForRange().searchRange(new int[]{2, 2}, 2)));
    }
}
