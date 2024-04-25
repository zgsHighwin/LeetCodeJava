package linkedlist;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 * <p>
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 列表中的节点数目在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 */

public class _203_移除链表元素 {
    public static void main(String[] args) {

        ListNode listNode = ListNodeHelper.create(new int[]{1,2,6,3,4,5,6});
        ListNodeHelper.printListNode(new _203_移除链表元素().removeElements(listNode, 6));
    }

    public ListNode removeElements(ListNode head, int val) {
        //考虑头结点
        ListNode dumpy = new ListNode(-1, head);
        ListNode tmp = dumpy;
        while (dumpy.next != null) {
            if (dumpy.next.val == val) {
                dumpy.next = dumpy.next.next;
            } else {
                dumpy = dumpy.next;
            }
        }
        return tmp.next;
    }
}
