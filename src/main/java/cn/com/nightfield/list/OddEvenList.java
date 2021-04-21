package cn.com.nightfield.list;

/**
 * @author: zhochi
 * @create: 2021/4/18
 **/
public class OddEvenList {
    public ListNode solution(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode odd = head, even = head.next, evenHead = head.next, oddNext, evenNext;
        while (even != null && even.next != null) {
            oddNext = even.next;
            evenNext = oddNext.next;
            odd.next = oddNext;
            even.next = evenNext;
            odd = oddNext;
            even = evenNext;
        }

        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        OddEvenList oddEvenList = new OddEvenList();
        ListNode result = oddEvenList.solution(node1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
