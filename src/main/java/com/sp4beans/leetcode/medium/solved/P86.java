package com.sp4beans.leetcode.medium.solved;

//        给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
//
//        你应当保留两个分区中每个节点的初始相对位置。
//
//        示例:
//
//        输入: head = 1->4->3->2->5->2, x = 3
//        输出: 1->2->2->4->3->5

public class P86 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public ListNode partition(ListNode head, int x) {
            if (head == null) {
                return head;
            }
            ListNode fake = new ListNode(-1);
            fake.next = head;
            ListNode smaller = fake;
            while (smaller != null && smaller.next != null) {
                while (smaller.next != null && smaller.next.val < x) {
                    smaller = smaller.next;
                }
                ListNode bigger = smaller.next;
                while (bigger != null && bigger.next != null && bigger.next.val >= x) {
                    bigger = bigger.next;
                }
                if (bigger == null || bigger.next == null) {
                    break;
                }
                ListNode smallNext = smaller.next;
                ListNode pre = bigger;
                ListNode biggerNext = bigger.next;
                smaller.next = biggerNext;
                pre.next = biggerNext.next;
                biggerNext.next = smallNext;
                smaller = smaller.next;
            }
            return fake.next;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.partition(new ListNode(1), 0);
    }
}
