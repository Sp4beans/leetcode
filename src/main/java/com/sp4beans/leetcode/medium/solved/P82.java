package com.sp4beans.leetcode.medium.solved;

//        82. 删除排序链表中的重复元素 II
//        给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
//
//        示例 1:
//
//        输入: 1->2->3->3->4->4->5
//        输出: 1->2->5
//        示例 2:
//
//        输入: 1->1->1->2->3
//        输出: 2->3


public class P82 {
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
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            ListNode last = dummy;
            while (last.next != null) {
                ListNode cur = last.next;
                ListNode next = cur.next;
                boolean hasSame = false;
                while (next != null && next.val == cur.val) {
                    hasSame = true;
                    cur.next = next.next;
                    next = cur.next;
                }

                if (hasSame) {
                    last.next = cur.next;
                } else {
                    last = last.next;
                }
            }

            return dummy.next;
        }
    }
}
