package com.sp4beans.leetcode.easy.solved;

//        你和朋友玩一个叫做「翻转游戏」的游戏，游戏规则：给定一个只有 + 和 - 的字符串。你和朋友轮流将 连续 的两个 "++" 反转成 "--"。 当一方无法进行有效的翻转时便意味着游戏结束，则另一方获胜。
//
//        请你写出一个函数，来计算出每个有效操作后，字符串所有的可能状态。
//
//        示例：
//
//        输入: s = "++++"
//        输出:
//        [
//        "--++",
//        "+--+",
//        "++--"
//        ]
//        注意：如果不存在可能的有效操作，请返回一个空列表 []。

import java.util.ArrayList;
import java.util.List;

public class P293 {

    private class Solution {
        public List<String> generatePossibleNextMoves(String s) {
            char[] cs = s.toCharArray();
            List<String> ans = new ArrayList<>();

            for (int i = 0; i < cs.length - 1; i++) {
                if (cs[i] == '+' && cs[i + 1] == '+') {
                    cs[i] = '-';
                    cs[i + 1] = '-';
                    ans.add(new String(cs));
                    cs[i] = '+';
                    cs[i + 1] = '+';
                }
            }
            return ans;
        }
    }


}
