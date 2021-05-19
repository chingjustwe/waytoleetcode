package cn.com.nightfield.list;

/**
 * @author: zhochi
 * @create: 2021/4/21
 *
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 *
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 如果两个链表没有交点，返回 null. 在返回结果后，两个链表仍须保持原有的结构。可假定整个链表结构中没有循环。程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 **/
public class GetIntersectionNode {
    public ListNode solution(ListNode headA, ListNode headB) {
        ListNode node1 = headA, node2 = headB;
        while (node1 != node2) {
            if (node1 == null) {
                node1 = headB;
            }
            else {
                node1 = node1.next;
            }

            if (node2 == null) {
                node2 = headA;
            }
            else {
                node2 = node2.next;
            }
        }

        return node1;
    }
}
