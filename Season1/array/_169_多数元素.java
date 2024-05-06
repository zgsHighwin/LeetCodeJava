package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 */
public class _169_多数元素 {
    public static void main(String[] args) {
        System.out.println(new _169_多数元素().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        System.out.println(new _169_多数元素().majorityElement(new int[]{2, 2, 1, 1, 1, 1, 1, 2, 2}));
        System.out.println(new _169_多数元素().majorityElement(new int[]{1}));
    }

    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> data = new HashMap<Integer, Integer>();

        for (int num : nums) {
            if (data.containsKey(num)) {
                data.put(num, data.get(num) + 1);
            } else {
                data.put(num, 1);
            }
        }

        int max = 0;
        int value = 0;

        for (Map.Entry<Integer, Integer> entry : data.entrySet()) {
            if(entry.getValue()>max){
                max = entry.getValue();
                value = entry.getKey();
            }
        }
        return value;
    }

    public int majorityElement(int[] nums) {

        int count = 0;
        int target = -1;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                target = nums[i];
            }

            count = (nums[i] == target ? count + 1 : count - 1);
        }
        return target;
    }
}
