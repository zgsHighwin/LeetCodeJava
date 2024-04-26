package array;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 为 无重复元素 的 升序 排列数组
 * -104 <= target <= 104
 */
public class _35_搜索插入位置 {
    public static void main(String[] args) {

        System.out.println(new _35_搜索插入位置().searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(new _35_搜索插入位置().searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(new _35_搜索插入位置().searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println();
        System.out.println(new _35_搜索插入位置().searchInsert(new int[]{1, 3, 5, 6, 7}, 7));
        System.out.println(new _35_搜索插入位置().searchInsert(new int[]{1, 3, 5, 6, 7}, 2));
        System.out.println(new _35_搜索插入位置().searchInsert(new int[]{1, 3, 5, 6, 7}, 5));
    }

    public int searchInsert(int[] nums, int target) {
        if (target <= nums[0]) {
            return 0;
        }

        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            if (nums[(l + r) >> 1] > target) {
                r = ((l + r) >> 1);
            } else if (nums[(l + r) >> 1] < target) {
                l = ((l + r) + 1 >> 1);
            } else {
                return ((l + r) >> 1);
            }

        }
        return ((l + r) >> 1);
    }
}
