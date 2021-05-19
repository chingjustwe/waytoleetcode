package cn.com.nightfield.list;

/**
 * @author: zhochi
 * @create: 2021/5/8
 *
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * 给定一个链表，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 **/
public class LinkedListCycle {
    public boolean solution(ListNode head) {
        // boundary check
        if (head == null || head.next == null) {
            return false;
        }

        // point each node to head
        ListNode current = head.next, next = null;
        head.next = null;
        while (current.next != null) {
            next = current.next;
            current.next = head;

            current = next;
        }

        // in this situation, if there is a cycle, the tail will be head
        return current == head;
    }
}
