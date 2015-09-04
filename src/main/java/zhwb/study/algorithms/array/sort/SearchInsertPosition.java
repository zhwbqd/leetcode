package zhwb.study.algorithms.array.sort;

/**
 * https://leetcode.com/problems/search-insert-position/
 * <p/>
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p/>
 * You may assume no duplicates in the array.
 * <p/>
 * Here are few examples.
 * [1,3,5,6], 5 ¡ú 2
 * [1,3,5,6], 2 ¡ú 1
 * [1,3,5,6], 7 ¡ú 4
 * [1,3,5,6], 0 ¡ú 0
 *
 * @author jack.zhang
 * @since 2015/9/4 0004
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int length = nums.length;
        int hi = length - 1;
        int mid = -1;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (nums[mid] >= target) {
                hi = mid - 1;
                if (mid >= 1 && nums[mid - 1] < target) {
                    return mid;
                }
                if (mid == 0) {
                    return mid;
                }
            } else {
                lo = mid + 1;
                if (mid < length - 1 && nums[mid + 1] > target) {
                    return mid + 1;
                }
                if (mid == length - 1) {
                    return length;
                }
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 0));
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1}, 2));
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1,2}, 2));
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1}, 0));
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1}, 2));
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1,3,5}, 1));
    }
}
