package com.sp4beans.leetcode.easy;

//        请判断一个链表是否为回文链表。
//
//        示例 1:
//
//        输入: 1->2
//        输出: false
//        示例 2:
//
//        输入: 1->2->2->1
//        输出: true
//        进阶：
//        你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

public class P234 {
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
        public boolean isPalindrome(ListNode head) {
            if (null == head || null == head.next) {
                return true;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            ListNode pre = null;
            ListNode prepre = null;
            while (null != fast && null != fast.next) {
                pre = slow;
                slow = slow.next;
                fast = fast.next.next;
                pre.next = prepre;
                prepre = pre;
            }

            ListNode p2 = slow.next;
            slow.next = pre;
            ListNode p1 = fast == null ? slow.next : slow;
            while (p1 != null) {
                if (p1.val != p2.val)
                    return false;
                p1 = p1.next;
                p2 = p2.next;
            }
            return true;
        }
    }
}
