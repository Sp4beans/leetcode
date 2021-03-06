package com.sp4beans.leetcode.easy.solved;

//        给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
//
//
//
//        在杨辉三角中，每个数是它左上方和右上方的数的和。
//
//        示例:
//
//        输入: 3
//        输出: [1,3,3,1]
//        进阶：
//
//        你可以优化你的算法到 O(k) 空间复杂度吗？

import java.util.ArrayList;
import java.util.List;

public class P119 {
    private class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> ret = new ArrayList<>(rowIndex + 1);
            long num = 1;
            ret.add((int) num);
            for (int i = 0; i < rowIndex; i++) {
                num = num * (rowIndex - i) / (i + 1);
                ret.add((int) num);
            }
            return ret;
        }
    }
}
