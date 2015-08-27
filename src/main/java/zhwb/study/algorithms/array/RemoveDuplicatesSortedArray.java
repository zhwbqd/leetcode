package zhwb.study.algorithms.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * <p/>
 * Given nums sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * <p/>
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * <p/>
 * For example,
 * Given input array nums = [1,1,2],
 * <p/>
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 *
 * @author jack.zhang
 * @since 2015/8/27
 */
public class RemoveDuplicatesSortedArray {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;
        int length = 1;
        for (int i = 1; i < n; ++i)
            if (nums[i] != nums[i - 1]) {
                nums[length++] = nums[i];
            }
        return length;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(new RemoveDuplicatesSortedArray().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
