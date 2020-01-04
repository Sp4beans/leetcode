package com.sp4beans.leetcode.easy;

//        删除链表中等于给定值 val 的所有节点。
//
//        示例:
//
//        输入: 1->2->6->3->4->5->6, val = 6
//        输出: 1->2->3->4->5

public class P203 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private class Solution {
        public ListNode removeElements(ListNode head, int val) {

            ListNode newHead = head;
            while (null != newHead && newHead.val == val) {
                newHead = newHead.next;
            }

            ListNode cur = newHead;
            while (null != cur) {
                if (null != cur.next && cur.next.val == val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }
            return newHead;
        }
    }
}
