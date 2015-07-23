package zhwb.study.algorithms.array;

/**
 * @author jack.zhang
 * @since 2015/7/23 0023
 */
public class JumpGame {
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
        for(int i=0; i<A.length-1; i++) {
            max = Math.max(max, i+A[i]);
            if( i == e ) {
                //没有到最后一个元素
                sc++;
                e = max;
            }
        }
        return sc;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame().jump(new int[]{5, 3, 1, 1, 2, 6, 1, 2, 3, 5, 4, 1, 1, 5}));
        System.out.println(new JumpGame().jump(new int[]{0}));
    }
}
