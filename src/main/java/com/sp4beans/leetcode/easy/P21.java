package com.sp4beans.leetcode.easy;

//        将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
//        示例：
//
//        输入：1->2->4, 1->3->4
//        输出：1->1->2->3->4->4

public class P21 {
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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (null == l1) {
                return l2;
            }
            if (null == l2) {
                return l1;
            }

            ListNode result = null;
            ListNode newList = null;

            while (null != l1 && null != l2) {
                if (null == newList) {
                    if (l1.val <= l2.val) {
                        newList = l1;
                        l1 = l1.next;
                    } else {
                        newList = l2;
                        l2 = l2.next;
                    }
                    result = newList;
                } else {
                    if (l1.val <= l2.val) {
                        newList.next = l1;
                        l1 = l1.next;
                    } else {
                        newList.next = l2;
                        l2 = l2.next;
                    }
                    newList = newList.next;
                }
            }
            if (null != l1) {
                newList.next = l1;
            }
            if (null != l2) {
                newList.next = l2;
            }

            return result;
        }
    }
}
