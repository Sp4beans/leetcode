package com.sp4beans.leetcode.easy;

//        输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
//
//        示例1：
//
//        输入：1->2->4, 1->3->4
//        输出：1->1->2->3->4->4
//        限制：
//
//        0 <= 链表长度 <= 1000
//
//        注意：本题与主站 21 题相同

public class M25 {
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
