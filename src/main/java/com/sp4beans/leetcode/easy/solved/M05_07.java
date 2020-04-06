package com.sp4beans.leetcode.easy.solved;

//        配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。
//
//        示例1:
//
//        输入：num = 2（或者0b10）
//        输出 1 (或者 0b01)
//        示例2:
//
//        输入：num = 3
//        输出：3
//        提示:
//
//        num的范围在[0, 2^30 - 1]之间，不会发生整数溢出。

public class M05_07 {
    private class Solution {
        public int exchangeBits(int num) {
            int a = 0b01010101010101010101010101010101;
            int b = 0b10101010101010101010101010101010;

            int aa = num & a;
            int bb = num & b;
            return (aa << 1) | (bb >> 1);
        }
    }
}
