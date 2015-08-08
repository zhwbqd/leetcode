package zhwb.study.algorithms.array;

/**
 * https://leetcode.com/problems/container-with-most-water/
 * <p/>
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p/>
 * Note: You may not slant the container.
 *
 * @author jack.zhang
 * @since 2015/8/5 0005
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        int head = 0;
        int tail = height.length - 1;

        while (head < tail) {
            max = Math.max(max, ((tail - head) * Math.min(height[head], height[tail]))); //计算面积
            if (height[head] < height[tail]) {//头小移头, 尾小移尾
                head++;
            } else{
                tail--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{2, 3, 1, 4, 3}));//9
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1, 2, 1}));//6
    }
}
