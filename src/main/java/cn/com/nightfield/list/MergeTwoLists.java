package cn.com.nightfield.list;

/**
 * @author: zhochi
 * @create: 2021/4/18
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 **/
public class MergeTwoLists {
    public ListNode solution(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = l1.val <= l2.val ? l1 : l2;
        ListNode firstCurrent = l1, secondCurrent = l2, current = dummy.next;
        while (firstCurrent != null || secondCurrent != null) {
            ListNode next;
            if (secondCurrent == null || (firstCurrent != null && firstCurrent.val <= secondCurrent.val)) {
                next = firstCurrent;
                firstCurrent = firstCurrent.next;
            }
            else {
                next = secondCurrent;
                secondCurrent = secondCurrent.next;
            }
            current.next = next;
            current = next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode node6 = new ListNode(9);
        ListNode node7 = new ListNode(8, node6);
        ListNode node8 = new ListNode(7, node7);
        ListNode node9 = new ListNode(6, node8);
        ListNode node0 = new ListNode(0, node9);
        ListNode head = mergeTwoLists.solution(node1, node0);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
