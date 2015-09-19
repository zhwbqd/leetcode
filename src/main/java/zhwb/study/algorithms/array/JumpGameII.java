package zhwb.study.algorithms.array;

/**
 * https://leetcode.com/problems/jump-game-ii/
 * <p/>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p/>
 * Each element in the array represents your maximum jump length at that position.
 * <p/>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p/>
 * For example:
 * Given array A = [2,3,1,1,4]
 * <p/>
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 *
 * @author jack.zhang
 * @since 2015/7/23 0023
 */
public class JumpGameII {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int jump = 1;
        int index = 0;
        int jumpLen = nums[index];
        while (jumpLen < nums.length - 1) {
            jump++;
            int length = jumpLen;
            for (int i = index + 1; i <= length; i++) {
                if (nums[i] + i > jumpLen) {
                    jumpLen = nums[i] + i;
                    index = i;
                }
            }
        }
        return jump;
    }

    public int jumpV2(int[] A) {
        int sc = 0;
        int e = 0;
        int max = 0;
        for (int i = 0; i < A.length - 1; i++) {
            max = Math.max(max, i + A[i]);
            if (i == e) {
                sc++;
                e = max;
            }
        }
        return sc;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGameII().jumpV2(new int[]{5, 3, 1, 1, 2, 6, 1, 2, 3, 5, 4, 1, 1, 5}));
        System.out.println(new JumpGameII().jump(new int[]{0}));
    }
}
