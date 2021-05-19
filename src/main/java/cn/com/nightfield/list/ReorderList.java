package cn.com.nightfield.list;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: zhochi
 * @create: 2021/4/24
 *
 *
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 **/
public class ReorderList {
    public void solution(ListNode head) {
        // boundary check
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        ListNode fast = head, slow = head, next;
        while (fast != null) {
            if (fast.next == null || fast.next.next == null) {
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        Deque<ListNode> stack = new LinkedList<>();
        next = slow.next;
        slow.next = null;
        slow = next;
        while (slow != null) {
            next = slow.next;
            // unlink
            slow.next = null;
            stack.push(slow);
            slow = next;
        }

        // merge two lists
        while (head != null && !stack.isEmpty()) {
            next = head.next;
            head.next = stack.pop();
            head.next.next = next;
            head = next;
        }
        /*// boundary check
        if (head == null || head.next == null) {
            return;
        }

        ListNode dummyHead = new ListNode(-1, head), next, nextnext;
        Deque<ListNode> stack = new LinkedList<>();
        while (head != null)  {
            next = head.next;
            if (next != null) {
                nextnext = next.next;
                // link to first list
                head.next = nextnext;
                // unlink second node
                next.next = null;
                stack.push(next);
                // move cursor
                head = nextnext;
            }
            else {
                // no more node
                break;
            }
        }

        head = dummyHead.next;
        while (head != null && !stack.isEmpty()) {
            next = head.next;
            head.next = stack.pop();
            head.next.next = next;
            head = next;
        }
        head = dummyHead.next;*/
    }

    public static void main(String[] args) {
        ReorderList reorderList = new ReorderList();
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        reorderList.solution(node1);
    }
}
