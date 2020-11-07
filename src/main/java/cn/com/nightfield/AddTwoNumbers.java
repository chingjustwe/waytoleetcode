package cn.com.nightfield;

import java.util.Random;

/**
 * @author: zhochi
 * @create: 2020/11/6
 *
 * https://leetcode-cn.com/problems/add-two-numbers
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 思路：
 * 类似于个位与个位相加，十位与十位相加。构造一个result链表，每加记录每次相加的结果。如果相加结果小于10，则result链表中新增一个
 * 节点；如果相加结果大于10，则result链表中新增两个节点：结果的个位数和val为1的十位数，注意，这种情况下的十位数也要参与到下一轮
 * 的结果计算中。
 *
 **/
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode result = new ListNode(0), current = result;
        while (l1 != null || l2 != null) {
            int value1 = l1 == null ? 0 : l1.val;
            int value2 = l2 == null ? 0 : l2.val;
            int value = current.val + value1 + value2;
            int placeOne = value % 10;
            int placeTen = value / 10;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;

            current.val = placeOne;
            if (l1 != null || l2 != null || placeTen != 0) {
                current.next = new ListNode(placeTen);
                current = current.next;
            }
        }

        return result;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // verify
    public static void main(String[] args) {
        Random random = new Random();
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode ln1 = new ListNode(random.nextInt(10)), current1 = ln1;
        ListNode ln2 = new ListNode(random.nextInt(10)), current2 = ln2;
        for (int i = 0; i < 5; i++) {
            current1.next = new ListNode(random.nextInt(10));
            current1 = current1.next;
        }
        for (int i = 0; i < 8; i++) {
            current2.next = new ListNode(random.nextInt(10));
            current2 = current2.next;
        }
        print(ln1);
        print(ln2);
        ListNode listNode = addTwoNumbers.addTwoNumbers(ln1, ln2);
        print(listNode);
    }

    static void print(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + ",");
            listNode = listNode.next;
        }
        System.out.println();
    }
}
