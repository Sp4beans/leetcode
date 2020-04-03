package com.sp4beans.leetcode.easy;

//        编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
//
//        示例1:
//
//        输入：[1, 2, 3, 3, 2, 1]
//        输出：[1, 2, 3]
//        示例2:
//
//        输入：[1, 1, 1, 1, 2]
//        输出：[1, 2]
//        提示：
//
//        链表长度在[0, 20000]范围内。
//        链表元素在[0, 20000]范围内。
//        进阶：
//
//        如果不得使用临时缓冲区，该怎么解决？

import java.util.HashSet;
import java.util.Set;

public class M02_01 {
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
        public ListNode removeDuplicateNodes(ListNode head) {
            if (head == null) {
                return head;
            }
            Set<Integer> shown = new HashSet();
            ListNode fake = new ListNode(0);
            ListNode tail = fake;
            ListNode cur = head;
            while (cur != null) {
                if (!shown.contains(cur.val)) {
                    shown.add(cur.val);
                    tail.next = cur;
                    tail = tail.next;
                }
                cur = cur.next;
            }

            tail.next = null;
            return fake.next;
        }
    }
}
