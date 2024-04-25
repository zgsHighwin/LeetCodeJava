package linkedlist;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 * <p>
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 */
public class _21_合并两个有序链表 {
    public static void main(String[] args) {
        ListNodeHelper.printListNode(new _21_合并两个有序链表().mergeTwoLists(ListNodeHelper.create(new int[]{1, 2, 4}), ListNodeHelper.create(new int[]{1, 3, 4})));
        ListNodeHelper.printListNode(new _21_合并两个有序链表().mergeTwoLists(ListNodeHelper.create(new int[]{}), ListNodeHelper.create(new int[]{0})));
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode tmp = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                dummy.next = list2;
                list2 = list2.next;
            } else {
                dummy.next = list1;
                list1 = list1.next;
            }
            dummy = dummy.next;
        }

        if (list1 == null) {
            dummy.next = list2;
        } else {
            dummy.next = list1;
        }
        return tmp.next;
    }
}
