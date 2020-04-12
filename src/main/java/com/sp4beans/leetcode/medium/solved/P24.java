package com.sp4beans.leetcode.medium.solved;

//        给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
//        你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//         
//
//        示例:
//
//        给定 1->2->3->4, 你应该返回 2->1->4->3.

public class P24 {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode index = head;
            while (null != index && index.next != null) {
                int tmp = index.val;
                index.val = index.next.val;
                index.next.val = tmp;
                index = index.next.next;
            }
            return head;
        }
    }
}
