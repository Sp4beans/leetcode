package com.sp4beans.leetcode.easy;

//        反转一个单链表。
//
//        示例:
//
//        输入: 1->2->3->4->5->NULL
//        输出: 5->4->3->2->1->NULL
//        进阶:
//        你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

public class P206 {

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
        public ListNode reverseList(ListNode head) {
            ListNode lastNode = null;
            ListNode curNode = head;
            ListNode result = null;
            while (curNode != null) {
                ListNode tmpNode = curNode;
                curNode = curNode.next;
                tmpNode.next = lastNode;
                lastNode = tmpNode;
                if (curNode == null) {
                    result = tmpNode;
                }
            }
            return result;
        }
    }
}
