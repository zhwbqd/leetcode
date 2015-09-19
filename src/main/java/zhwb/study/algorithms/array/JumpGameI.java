package zhwb.study.algorithms.array;

/**
 * https://leetcode.com/problems/jump-game/
 * <p/>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p/>
 * Each element in the array represents your maximum jump length at that position.
 * <p/>
 * Determine if you are able to reach the last index.
 * <p/>
 * For example:
 * A = [2,3,1,1,4], return true.
 * <p/>
 * A = [3,2,1,0,4], return false.
 *
 * @author jack.zhang
 * @since 2015/9/19 0019
 */
public class JumpGameI {

    public boolean canJump(int[] nums) {
        int max = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            max = Math.max(nums[i] + i, max);//找到最远的步子
            if (max >= length - 1) {
                return true;
            }
            if (max == i) {
                return false;
            }
        }
        return false;
    }

    public boolean canJumpV2(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length && i <= maxReach; i++)
            maxReach=Math.max(maxReach, nums[i]+i);
        return maxReach >= nums.length - 1;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGameI().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new JumpGameI().canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(new JumpGameI().canJump(new int[]{0}));
        System.out.println(new JumpGameI().canJump(new int[]{2, 0}));
    }

}
