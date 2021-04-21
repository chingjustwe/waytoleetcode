package cn.com.nightfield.list;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: zhochi
 * @create: 2021/4/17
 *
 * https://leetcode-cn.com/problems/reverse-linked-list
 *
 **/
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
    public ListNode reverseList1(ListNode head) {
        Deque<ListNode> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        head = stack.pop();
        for (ListNode current = head; !stack.isEmpty();) {
            ListNode next = stack.pop();
            current.next = next;
            next.next = null;
            current = next;
        }
        return head;
    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode head = reverseList.reverseList1(node1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}