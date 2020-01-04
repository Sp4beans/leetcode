package com.sp4beans.leetcode.hard;

//        合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
//
//        示例:
//
//        输入:
//        [
//          1->4->5,
//          1->3->4,
//          2->6
//        ]
//        输出: 1->1->2->3->4->4->5->6

public class P23 {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private class Solution {
        public ListNode mergeKLists(ListNode[] heads) {
            ListNode dummy = new ListNode(-1);
            ListNode index = dummy;

            while (true) {
                ListNode minNode = null;
                int minI = 0;
                int nullCount = 0;
                for (int i = 0; i < heads.length; i++) {
                    if (heads[i] != null) {
                        if (minNode == null) {
                            minNode = heads[i];
                            minI = i;
                        } else {
                            if (heads[i].val < minNode.val) {
                                minNode = heads[i];
                                minI = i;
                            }
                        }
                    } else {
                        nullCount++;
                    }
                }
                if (nullCount == heads.length) {
                    break;
                }
                index.next = minNode;
                index = index.next;
                heads[minI] = heads[minI].next;
            }
            return dummy.next;
        }
    }
}
