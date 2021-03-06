package com.sp4beans.leetcode.easy.solved;

//        实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
//
//        注意：本题相对原题稍作改动
//
//        示例：
//
//        输入： 1->2->3->4->5 和 k = 2
//        输出： 4
//        说明：
//
//        给定的 k 保证是有效的。

public class M02_02 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
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
        public int kthToLast(ListNode head, int k) {
            ListNode fast = head;
            ListNode slow = head;
            for (int i = 0; i < k; i++) {
                fast = fast.next;
            }
            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow.val;
        }
    }
}
