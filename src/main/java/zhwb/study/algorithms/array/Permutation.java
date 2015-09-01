package zhwb.study.algorithms.array;

import java.util.Arrays;

/**
 * 全排序：
 * 从n个不同元素中任取m（m≤n）个元素，按照一定的顺序排列起来，叫做从n个不同元素中取出m个元素的一个排列。当m=n时所有的排列情况叫全排列。例如n=3，全排序为：123、132、213、231、312、321共6种。
 * <p/>
 * 字典序法：
 * 对给定的字符集中的字符规定了一个先后关系，在此基础上规定两个全排列的先后是：从左到右逐个比较对应的字符大小。字符集{1,2,3}，较小的数字较先，这样按字典序生成的全排列即：123、132、213、231、312、321。
 * <p/>
 * 现在假设输入全排序中的一串数字，要求得到它在字典序全排列中对应的下一个排列数。比如：输入123输出132，输入12435输出12453。
 * <p/>
 * <p/>
 * https://leetcode.com/problems/next-permutation/
 * <p/>
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * <p/>
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * <p/>
 * The replacement must be in-place, do not allocate extra memory.
 * <p/>
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * @author jack.zhang
 * @since 2015/9/1
 */
public class Permutation {

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return;
        }
        int index = n - 1;
        //trace from end, find the last index matching asc order
        while (index > 0) {
            if (nums[index - 1] < nums[index]) {
                break;
            }
            index--;
        }

        //index == 0 , its a desc
        if (index == 0) {
            reverse(nums, 0, n - 1);
        } else {
            int val = nums[index - 1];
            int j = n - 1;
            while (j >= index) {
                if (nums[j] > val) {
                    break;
                }
                j--;
            }
            swap(nums, j, index - 1);
            reverse(nums, index, n - 1);
        }
    }

    public void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public void reverse(int[] num, int start, int end) {
        if (start > end)
            return;
        for (int i = start; i <= (end + start) / 2; i++)
            swap(num, i, start + end - i);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 5, 1, 2, 3, 2, 1};
        new Permutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{7, 8, 6, 9, 8, 7, 2};
        new Permutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
