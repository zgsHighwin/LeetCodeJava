package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class _217_存在重复元素 {
    public static void main(String[] args) {
        System.out.println(new _217_存在重复元素().containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
        System.out.println(new _217_存在重复元素().containsDuplicate(new int[]{1, 2, 3, 4}));
        System.out.println(new _217_存在重复元素().containsDuplicate(new int[]{1, 2, 3, 1}));
    }

    public boolean containsDuplicate(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        int i = 0;
        while (i < nums.length) {

            if (map.containsKey(nums[i])) {
                return true;
            } else {
                map.put(nums[i], i);
            }
            i++;
        }
        return false;
    }
}
