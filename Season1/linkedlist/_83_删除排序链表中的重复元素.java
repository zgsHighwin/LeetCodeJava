package linkedlist;

/**
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 */
public class _83_删除排序链表中的重复元素 {
    public static void main(String[] args) {
        ListNodeHelper.printListNode(new _83_删除排序链表中的重复元素().deleteDuplicates(ListNodeHelper.create(new int[]{1, 1, 2, 3, 3})));
        ListNodeHelper.printListNode(new _83_删除排序链表中的重复元素().deleteDuplicates(ListNodeHelper.create(new int[]{1, 1, 2})));


        ListNodeHelper.printListNode(new _83_删除排序链表中的重复元素().deleteDuplicates(ListNodeHelper.create(new int[]{1, 1, 1, 2, 2})));
        ListNodeHelper.printListNode(new _83_删除排序链表中的重复元素().deleteDuplicates(ListNodeHelper.create(new int[]{1, 2, 2, 3, 3, 3})));
        ListNodeHelper.printListNode(new _83_删除排序链表中的重复元素().deleteDuplicates(ListNodeHelper.create(new int[]{1, 1, 1, 1, 1})));
        ListNodeHelper.printListNode(new _83_删除排序链表中的重复元素().deleteDuplicates(ListNodeHelper.create(new int[]{1, 2, 3, 4, 5})));
        ListNodeHelper.printListNode(new _83_删除排序链表中的重复元素().deleteDuplicates(ListNodeHelper.create(new int[]{5, 5, 4, 4, 3, 3, 2, 2, 1, 1})));
// ... continue this pattern for your needs
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tmp = head;
        int lastVal = head.val;

        while (head.next != null) {
            if (lastVal == head.next.val) {
                head.next = head.next.next;
            } else {
                lastVal = head.next.val;
                head = head.next;
            }
        }
        return tmp;
    }
}
