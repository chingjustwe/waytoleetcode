package cn.com.nightfield.list;

/**
 * @author: zhochi
 * @create: 2021/4/17
 *
 * https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 **/
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        int index = 0;
        ListNode placeHolder = dummyNode, current = dummyNode, next;
        while (current.next != null) {
            if (index >= right) {
                break;
            } else if (index < left) {
                placeHolder = current;
                current = current.next;
            } else {
                next = current.next;
                current.next = next.next;
                next.next = placeHolder.next;
                placeHolder.next = next;
            }
            index++;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode head = reverseLinkedListII.reverseBetween(node1, 3, 4);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

