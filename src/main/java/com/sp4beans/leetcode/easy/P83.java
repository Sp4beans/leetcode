package com.sp4beans.leetcode.easy;

//        给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
//
//        示例 1:
//
//        输入: 1->1->2
//        输出: 1->2
//        示例 2:
//
//        输入: 1->1->2->3->3
//        输出: 1->2->3

public class P83 {
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

    private static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode result = head;
            ListNode cur = head;

            while (null != cur && cur.next != null) {
                if (cur.val == cur.next.val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }
            return result;
        }
    }
}
