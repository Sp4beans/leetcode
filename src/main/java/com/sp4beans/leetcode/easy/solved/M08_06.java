package com.sp4beans.leetcode.easy.solved;

//        在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
//        (1) 每次只能移动一个盘子;
//        (2) 盘子只能从柱子顶端滑出移到下一根柱子;
//        (3) 盘子只能叠在比它大的盘子上。
//
//        请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
//
//        你需要原地修改栈。
//
//        示例1:
//
//        输入：A = [2, 1, 0], B = [], C = []
//        输出：C = [2, 1, 0]
//        示例2:
//
//        输入：A = [1, 0], B = [], C = []
//        输出：C = [1, 0]
//        提示:
//
//        A中盘子的数目不大于14个。

import java.util.List;

public class M08_06 {
    private class Solution {
        public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
            hanota(A.size(), A, B, C);
        }

        private void hanota(int size, List<Integer> a, List<Integer> b, List<Integer> c) {
            if (size == 1) {
                move(a, c);
                return;
            }

            hanota(size - 1, a, c, b);
            move(a, c);
            hanota(size - 1, b, a, c);
        }

        private void move(List<Integer> a, List<Integer> b) {
            b.add(a.remove(a.size() - 1));
        }
    }
}
