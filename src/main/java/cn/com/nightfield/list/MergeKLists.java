package cn.com.nightfield.list;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: zhochi
 * @create: 2021/4/23
 *
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 **/
public class MergeKLists {
    public ListNode solution(ListNode[] lists) {
        // bundary check
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode dummyHead = new ListNode(-1), prev = dummyHead;
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(listNode -> listNode.val));
        // init heap
        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }

        while (!queue.isEmpty()) {
            ListNode current = queue.poll();
            if (current.next != null) {
                queue.offer(current.next);
            }
            // link to previous node
            prev.next = current;
            // move cursor
            prev = current;
        }

        return dummyHead.next;
    }
}
