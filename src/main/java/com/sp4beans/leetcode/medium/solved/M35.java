package com.sp4beans.leetcode.medium.solved;

//        请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
//
//         
//
//        示例 1：
//
//
//
//        输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//        输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
//        示例 2：
//
//
//
//        输入：head = [[1,1],[2,1]]
//        输出：[[1,1],[2,1]]
//        示例 3：
//
//
//
//        输入：head = [[3,null],[3,0],[3,null]]
//        输出：[[3,null],[3,0],[3,null]]
//        示例 4：
//
//        输入：head = []
//        输出：[]
//        解释：给定的链表为空（空指针），因此返回 null。
//         
//
//        提示：
//
//        -10000 <= Node.val <= 10000
//        Node.random 为空（null）或指向链表中的节点。
//        节点数目不超过 1000 。
//         
//
//        注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-pointer/

public class M35 {
    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    private class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }

            Node cur = head;
            Node result = new Node(-1);
            Node last = result;
            while (cur != null) {
                last.next = copyNode(cur);
                last = last.next;
                cur = cur.next;
            }

            Node cur1 = head;
            Node cur2 = result.next;

            while (cur1 != null && cur2 != null) {
                Node tmp1 = head;
                Node tmp2 = result.next;
                while (tmp1 != null && tmp2 != null) {
                    if (tmp1.random == cur1) {
                        tmp2.random = cur2;
                    }
                    tmp1 = tmp1.next;
                    tmp2 = tmp2.next;
                }
                cur1 = cur1.next;
                cur2 = cur2.next;
            }

            return result.next;
        }

        public Node copyNode(Node node) {
            if (node == null) {
                return null;
            }
            return new Node(node.val);
        }
    }
}
