package linkedlist;

public class ListNodeHelper {

    public static ListNode create(int[] nodeList) {
        if (nodeList == null || nodeList.length == 0) {
            return null;
        }

        ListNode listNode = new ListNode();
        ListNode tmp = listNode;
        for (int i = 0; i < nodeList.length; i++) {
            listNode.next = new ListNode(nodeList[i]);
            listNode = listNode.next;
        }
        return tmp.next;
    }

    public static void printListNode(ListNode node) {
        if (node == null) {
            return;
        }

        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}
