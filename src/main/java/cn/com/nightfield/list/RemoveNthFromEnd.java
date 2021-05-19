package cn.com.nightfield.list;

/**
 * @author: zhochi
 * @create: 2021/4/26
 *
 * 给定一个链表，删除链表的倒数第n个节点并返回链表的头指针
 *
 **/
public class RemoveNthFromEnd {
    public ListNode solution (ListNode head, int n) {
        // boundary check
        if (n == 0) {
            return head;
        }
        if (head == null) {
            return null;
        }
        if (head.next == null && n == 1) {
            return null;
        }

        // set node as placeholder
        ListNode node = head;

        ListNode first = head, second = head;
        // first node start
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        if (first == null) {
            return null;
        }

        // first node and second node both move forward
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        // remove target node
        second.next = second.next.next;
        return node;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        removeNthFromEnd.solution(node1, 2);
    }
}
