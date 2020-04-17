package com.sp4beans.leetcode.medium.solved;

//        给定两个用链表表示的整数，每个节点包含一个数位。
//
//        这些数位是反向存放的，也就是个位排在链表首部。
//
//        编写函数对这两个整数求和，并用链表形式返回结果。
//
//         
//
//        示例：
//
//        输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
//        输出：2 -> 1 -> 9，即912
//        进阶：假设这些数位是正向存放的，请再做一遍。
//
//        示例：
//
//        输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
//        输出：9 -> 1 -> 2，即912

public class M02_05 {
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
