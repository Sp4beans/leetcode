package com.sp4beans.leetcode.medium.solved;

//        给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
//        示例：
//
//        给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//        当删除了倒数第二个节点后，链表变为 1->2->3->5.
//        说明：
//
//        给定的 n 保证是有效的。
//
//        进阶：
//
//        你能尝试使用一趟扫描实现吗？

public class P19 {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode start = dummy;
            ListNode end = dummy;
            for (int i = 0; i <= n; i++) {
                end = end.next;
            }

            while (end != null) {
                start = start.next;
                end = end.next;
            }

            start.next = start.next.next;

            return dummy.next;
        }
    }
}
