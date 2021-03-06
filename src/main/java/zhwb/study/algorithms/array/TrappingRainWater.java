package zhwb.study.algorithms.array;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 * <p/>
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * <p/>
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 *
 * @author jack.zhang
 * @since 2015/9/8
 */
public class TrappingRainWater {

    public int trapBetter(int[] A) {
        if (A.length < 3) return 0;

        int ans = 0;
        int l = 0, r = A.length - 1;

        // find the left and right edge which can hold water
        while (l < r && A[l] <= A[l + 1]) l++;
        while (l < r && A[r] <= A[r - 1]) r--;

        while (l < r) {
            int left = A[l];
            int right = A[r];
            if (left <= right) {
                // add volum until an edge larger than the left edge
                while (l < r && left >= A[++l]) {
                    ans += left - A[l];
                }
            } else {
                // add volum until an edge larger than the right volum
                while (l < r && A[--r] <= right) {
                    ans += right - A[r];
                }
            }
        }
        return ans;
    }


    public int trap(int[] height) {
        int result = 0;
        int highestIndex = 0;
        int maxValue = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] >= maxValue) {
                maxValue = height[i];
                highestIndex = i;
            }
        }
        for (int i = 0; i < highestIndex; i++) {
            if (height[i] > 0) {
                for (int j = i + 1; j < height.length; j++) {
                    if (height[j] >= height[i]) {
                        result += calc(i, j, height);
                        i = j - 1;
                        break;
                    }
                }
            }
        }
        for (int i = height.length - 1; i > highestIndex; i--) {
            if (height[i] > 0) {
                for (int j = i - 1; j < height.length; j--) {
                    if (height[j] >= height[i]) {
                        result += calc(j, i, height);
                        i = j + 1;
                        break;
                    }
                }
            }
        }

        return result;
    }

    private int calc(int lo, int hi, int[] height) {
        //先计算出total最大面积, 再减
        int total = (hi - lo - 1) * Math.min(height[lo], height[hi]);
        int k = lo + 1;
        while (k < hi) {
            total -= height[k];
            k++;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(new TrappingRainWater().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(new TrappingRainWater().trap(new int[]{4, 2, 3}));
    }
}
