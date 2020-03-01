package com.sp4beans.leetcode.easy;

//        定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
//
//         
//
//        示例:
//
//        输入: 1->2->3->4->5->NULL
//        输出: 5->4->3->2->1->NULL
//         
//
//        限制：
//
//        0 <= 节点个数 <= 5000

public class M24 {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    private class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode last = null;
            ListNode cur = head;
            ListNode next = head.next;
            while (next != null) {
                cur.next = last;
                last = cur;
                cur = next;
                next = next.next;
            }
            cur.next = last;
            return cur;
        }
    }
}
