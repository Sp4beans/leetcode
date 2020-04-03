package com.sp4beans.leetcode.easy.solved;

//        设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
//
//        你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
//
//        示例:
//
//        int k = 3;
//        int[] arr = [4,5,8,2];
//        KthLargest kthLargest = new KthLargest(3, arr);
//        kthLargest.add(3);   // returns 4
//        kthLargest.add(5);   // returns 5
//        kthLargest.add(10);  // returns 5
//        kthLargest.add(9);   // returns 8
//        kthLargest.add(4);   // returns 8
//        说明:
//        你可以假设 nums 的长度≥ k-1 且k ≥ 1。

public class P703 {
    private static class KthLargest {

        int[] heap;
        int curSize;
        int maxSize;

        public KthLargest(int k, int[] nums) {
            init(k, nums);
        }

        public int add(int val) {
//            System.out.println("add : " + val);
            if (curSize < maxSize || val > top()) {
                push(val);
            }
            return top();
        }

        private void init(int k, int[] nums) {
            heap = new int[k + 2];
            curSize = 0;
            maxSize = k;
            for (int i = 1; i <= nums.length; i++) {
                int num = nums[i - 1];
                if (i <= k || num > top()) {
                    push(num);
                }
            }
        }

        private void push(int num) {
            if (curSize >= maxSize) {
                pop();
            }
            curSize++;
            heap[curSize] = num;
            shiftUp();

//            System.out.print("push : ");
//            print();
        }

        private int top() {
            return heap[1];
        }

        private void pop() {
            if (curSize >= 1) {
                swap(1, curSize);
                curSize--;
                shiftDown();
            }

//            System.out.print("pop : ");
//            print();
        }

        private void shiftUp() {
            int cur = curSize;
            while (cur > 1) {
                int next = cur >> 1;
                if (heap[cur] < heap[next]) {
                    swap(cur, next);
                }
                cur = next;
            }
        }

        private void shiftDown() {
            int cur = 1;
            while (cur < curSize) {
                int j = cur << 1;
                int k = j + 1;
                if (j <= curSize) {
                    if (k <= curSize && heap[j] > heap[k]) {
                        j = k;
                    }
                    if (heap[cur] > heap[j]) {
                        swap(cur, j);
                    }
                }
                cur = j;
            }
        }

        private void swap(int i, int j) {
            int tmp = heap[i];
            heap[i] = heap[j];
            heap[j] = tmp;
        }

        private void print() {
            for (int i = 1; i <= curSize; i++) {
                System.out.print(heap[i] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Your KthLargest object will be instantiated and called as such:
     * KthLargest obj = new KthLargest(k, nums);
     * int param_1 = obj.add(val);
     */
    public static void main(String args[]) {
        KthLargest largest = new KthLargest(7, new int[]{-10, 1, 3, 1, 4, 10, 3, 9, 4, 5, 1});
        System.out.println(largest.add(3));
        System.out.println(largest.add(2));
        System.out.println(largest.add(3));
        System.out.println(largest.add(1));
        System.out.println(largest.add(2));
        System.out.println(largest.add(4));

        System.out.println(largest.add(5));
        System.out.println(largest.add(5));
        System.out.println(largest.add(6));
        System.out.println(largest.add(7));
        System.out.println(largest.add(7));
        System.out.println(largest.add(8));

    }

}
