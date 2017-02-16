package com.github.h0ngyue.leetcode;

/**
 * Created by shuailongcheng on 16/02/2017.
 */

public class ReverseLink {

    public static class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverse(ListNode head) {
        ListNode newHead = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }

        return newHead;
    }

    public static void test(int n) {
        ListNode head = new ListNode(0);
        ListNode pos = head;
        for (int i = 1; i < n; i++) {
            pos.next = new ListNode(i);
            pos = pos.next;
        }

        printList(head);

        printList(reverse(head));
    }

    public static void printList(ListNode head) {        StringBuffer sb = new StringBuffer();
        boolean first = true;
        while (head != null) {
            sb.append((first ? "" : ", ") + head.val);
            first = false;
            head = head.next;
        }

        System.out.print(sb.toString());
        System.out.println();
    }
}
