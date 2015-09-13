package zhwb.study.algorithms.array.backtracking;

import java.util.Arrays;

/**
 * ȫ����
 * ��n����ͬԪ������ȡm��m��n����Ԫ�أ�����һ����˳������������������n����ͬԪ����ȡ��m��Ԫ�ص�һ�����С���m=nʱ���е����������ȫ���С�����n=3��ȫ����Ϊ��123��132��213��231��312��321��6�֡�
 * <p/>
 * �ֵ��򷨣�
 * �Ը������ַ����е��ַ��涨��һ���Ⱥ��ϵ���ڴ˻����Ϲ涨����ȫ���е��Ⱥ��ǣ�����������Ƚ϶�Ӧ���ַ���С���ַ���{1,2,3}����С�����ֽ��ȣ��������ֵ������ɵ�ȫ���м���123��132��213��231��312��321��
 * <p/>
 * ���ڼ�������ȫ�����е�һ�����֣�Ҫ��õ������ֵ���ȫ�����ж�Ӧ����һ�������������磺����123���132������12435���12453��
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
 * 1,2,3 �� 1,3,2
 * 3,2,1 �� 1,2,3
 * 1,1,5 �� 1,5,1
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
