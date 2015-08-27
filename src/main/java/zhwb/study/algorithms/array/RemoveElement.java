package zhwb.study.algorithms.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-element/
 * <p/>
 * Given an array and nums value, remove all instances of that value in place and return the new length.
 * <p/>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * @author jack.zhang
 * @since 2015/8/27
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                nums[i] = nums[--len];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(new RemoveElement().removeElement(nums, 3));
        System.out.println(Arrays.toString(nums));
        nums = new int[]{3, 3};
        System.out.println(new RemoveElement().removeElement(nums, 3));
        System.out.println(Arrays.toString(nums));
    }
}
