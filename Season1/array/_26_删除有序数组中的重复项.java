package array;

/**
 * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 * <p>
 * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
 * <p>
 * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
 * 返回 k 。
 * 判题标准:
 * <p>
 * 系统会用下面的代码来测试你的题解:
 * <p>
 * int[] nums = [...]; // 输入数组
 * int[] expectedNums = [...]; // 长度正确的期望答案
 * <p>
 * int k = removeDuplicates(nums); // 调用
 * <p>
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 * assert nums[i] == expectedNums[i];
 * }
 * 如果所有断言都通过，那么您的题解将被 通过。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2,_]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * nums 已按 非严格递增 排列
 */
public class _26_删除有序数组中的重复项 {
    public static void main(String[] args) {
        System.out.println(new _26_删除有序数组中的重复项().removeDuplicates(new int[]{
                0, 0, 1, 1, 1, 2, 2, 3, 3, 4

        }));

        System.out.println(new _26_删除有序数组中的重复项().removeDuplicates(new int[]{
                1, 1, 2

        }));
    }

    /**
     * 只操控数组需要实现
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int curIndex = 0;
        // 111 2222 33333
        for (int i = 1; i < nums.length; i++) {
            if (nums[curIndex] == nums[i]) {
                continue;
            } else {
                nums[++curIndex] = nums[i];
            }
        }
        return curIndex + 1;
    }

    //这个性能很差
    public int removeDuplicates1(int[] nums) {
        //n为k n+1为value
        int[] record = new int[nums.length * 2];
        int recordIndex = 0;
        int cur = nums[0];
        record[recordIndex] = cur;
        record[recordIndex + 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == cur) {
                ++record[recordIndex + 1];
            } else {
                cur = nums[i];
                recordIndex += 2;
                record[recordIndex] = cur;
                record[recordIndex + 1] = 1;
            }
        }

        int result = recordIndex / 2 + 1;
        for (int i = 0; i < result; i++) {
            nums[i] = record[i * 2];
        }

        return result;
    }
}
