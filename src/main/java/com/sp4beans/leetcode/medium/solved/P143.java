package com.sp4beans.leetcode.medium.solved;

//        给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
//        将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
//
//        你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//        示例 1:
//
//        给定链表 1->2->3->4, 重新排列为 1->4->2->3.
//        示例 2:
//
//        给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.

public class P143 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private class Solution {
        public void reorderList(ListNode head) {
            if (head == null || head.next == null) {
                return;
            }
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            if (fast != null) {
                ListNode tmp = slow.next;
                slow.next = null;
                slow = tmp;
            }
            ListNode pre = slow;
            ListNode cur = slow.next;
            pre.next = null;
            while (cur != null) {
                ListNode tmp = cur;
                cur = cur.next;
                tmp.next = pre;
                pre = tmp;
            }

            ListNode newNode = pre;
            ListNode idx = head;
            while (idx != null && idx.next != pre) {
                ListNode tmp1 = idx.next;
                ListNode tmp2 = newNode == null ? null : newNode.next;
                idx.next = newNode;
                if (newNode != null) {
                    newNode.next = tmp1;
                }
                idx = tmp1;
                newNode = tmp2;
            }
        }
    }
}
