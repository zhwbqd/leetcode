package zhwb.study.algorithms.array.sub;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * <p/>
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * <p/>
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 *
 * @author jack.zhang
 * @since 2015/7/21 0021
 */
public class MinSizeSubArray {

    public int minSubArrayLen(int s, int[] nums) {
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1]; //构建从0开始的累加和序列
        }
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < sums.length; i++) {
            int end = binarySearch(i + 1, sums.length - 1, sums[i] + s, sums);
            if (end == sums.length) break;
            if (end - i < minLen) minLen = end - i;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }


    /**
     * As to NLogN solution, logN immediately reminds you of binary search.
     * In this case, you cannot sort as the current order actually matters.
     * How does one get an ordered array then? Since all elements are positive,
     * the cumulative sum must be strictly increasing. Then,
     * a subarray sum can expressed as the difference between two cumulative sum.
     * Hence, given a start index for the cumulative sum array, the other end index can be searched using binary search.
     *
     * @param lo
     * @param hi
     * @param key
     * @param sums
     * @return
     */
    private int binarySearch(int lo, int hi, int key, int[] sums) {
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (sums[mid] >= key) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        System.out.println(new MinSizeSubArray().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
