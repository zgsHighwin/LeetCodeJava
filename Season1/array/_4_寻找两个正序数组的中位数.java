package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 相关标签
 * 相关企业
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * <p>
 * <p>
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class _4_寻找两个正序数组的中位数 {
    public static void main(String[] args) {
        System.out.println(new _4_寻找两个正序数组的中位数().findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(new _4_寻找两个正序数组的中位数().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(new _4_寻找两个正序数组的中位数().findMedianSortedArrays(new int[]{2, 3}, new int[]{}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1Index = 0;
        int n2Index = 0;

        List<Integer> list = new ArrayList<>();
        while (n1Index < nums1.length && n2Index < nums2.length) {
            if (nums1[n1Index] < nums2[n2Index]) {
                list.add(nums1[n1Index]);
                n1Index++;
            } else {
                list.add(nums2[n2Index]);
                n2Index++;
            }
        }

        if (n1Index == nums1.length) {
            //如果n1已经结束了。则加上n2
            for (int i = n2Index; i < nums2.length; i++) {
                list.add(nums2[i]);
            }
        } else {
            for (int i = n1Index; i < nums1.length; i++) {
                list.add(nums1[i]);
            }
        }


        if ((list.size() & 1) == 1) {
            return list.get(list.size() / 2);
        } else {
            Integer i = list.get(list.size() / 2 - 1);
            Integer i1 = list.get(list.size() / 2);

            return (i + i1) / 2.0;
        }
    }
}
