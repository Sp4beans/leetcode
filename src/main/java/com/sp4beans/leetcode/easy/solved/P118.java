package com.sp4beans.leetcode.easy.solved;

//        给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
//
//
//
//        在杨辉三角中，每个数是它左上方和右上方的数的和。
//
//        示例:
//
//        输入: 5
//        输出:
//        [
//        [1],
//        [1,1],
//        [1,2,1],
//        [1,3,3,1],
//        [1,4,6,4,1]
//        ]

import java.util.ArrayList;
import java.util.List;

public class P118 {

    private class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                List<Integer> line = new ArrayList<>();
                if (i == 0) {
                    line.add(1);
                } else if (i == 1) {
                    line.add(1);
                    line.add(1);
                } else {
                    List<Integer> lastLine = result.get(i - 1);
                    line.add(1);
                    for (int j = 0; j < lastLine.size() - 1; j++) {
                        line.add(lastLine.get(j) + lastLine.get(j + 1));
                    }
                    line.add(1);
                }
                result.add(line);
            }
            return result;
        }
    }

}
