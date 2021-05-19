package cn.com.nightfield.list;

/**
 * @author: zhochi
 * @create: 2021/4/24
 *
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 进阶：
 *
 *     你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 *     你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 **/
public class ReverseKGroup {
    public ListNode solution(ListNode head, int k) {
        // boundary check
        if (head.next == null || k == 1) {
            return head;
        }

        // placeholder
        ListNode dummyHead = new ListNode(-1), prev = dummyHead;
        while (head != null && head.next != null) {
            // previous head node
            ListNode preHead = head;
            int i = 1;
            // k group reverse
            for (; i < k && head.next != null; i++) {
                head = head.next;
            }
            // node number less than k
            if (i < k && head.next == null) {
                break;
            }

            // previous tail node
            ListNode preTail = head;
            // move cursor to next
            head = preTail.next;
            // reverse
            reverse(preHead, preTail);

            // update cursor
            prev.next = preTail;
            preHead.next = head;
            prev = preHead;
        }

        return dummyHead.next;
    }

    private void reverse(ListNode head, ListNode tail) {
        if (head == tail) {
            return;
        }

        reverse(head.next, tail);
        head.next.next = head;
        head.next = null;
    }

    public static void main(String[] args) {
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        reverseKGroup.solution(node1, 3);
    }
}
