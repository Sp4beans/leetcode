package com.sp4beans.leetcode.medium;

//        给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
//        如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
//        您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//        示例：
//
//        输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//        输出：7 -> 0 -> 8
//        原因：342 + 465 = 807

public class P2 {

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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (null == l1) return l2;
            if (null == l2) return l1;

            ListNode result = l1;
            ListNode idx1 = l1;
            ListNode idx2 = l2;

            while (idx1.next != null && idx2 != null) {
                idx1.val = idx1.val + idx2.val;
                idx1 = idx1.next;
                idx2 = idx2.next;
            }

            if (idx1.next == null && idx2 != null) {
                idx1.val += idx2.val;
                idx1.next = idx2.next;
            }

            ListNode idx = l1;
            while (idx != null) {
                if (idx.val >= 10) {
                    idx.val = idx.val - 10;
                    if (idx.next != null) {
                        idx.next.val++;
                    } else {
                        idx.next = new ListNode(1);
                    }
                }
                idx = idx.next;
            }

            return result;
        }
    }
}
