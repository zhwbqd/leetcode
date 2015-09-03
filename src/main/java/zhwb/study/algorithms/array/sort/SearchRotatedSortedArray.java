package zhwb.study.algorithms.array.sort;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * <p/>
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * <p/>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p/>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p/>
 * You may assume no duplicate exists in the array.
 *
 * @author jack.zhang
 * @since 2015/9/2
 */
public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[start] <= nums[mid]){
                if (target < nums[mid] && target >= nums[start])
                    end = mid - 1;
                else
                    start = mid + 1;
            }

            if (nums[mid] <= nums[end]){
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new SearchRotatedSortedArray().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4));
    }
}
