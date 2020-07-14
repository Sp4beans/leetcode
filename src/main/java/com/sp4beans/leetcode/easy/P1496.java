package com.sp4beans.leetcode.easy;

//        给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。
//
//        机器人从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。
//
//        如果路径在任何位置上出现相交的情况，也就是走到之前已经走过的位置，请返回 True ；否则，返回 False 。
//
//         
//
//        示例 1：
//
//
//
//        输入：path = "NES"
//        输出：false
//        解释：该路径没有在任何位置相交。
//        示例 2：
//
//
//
//        输入：path = "NESWW"
//        输出：true
//        解释：该路径经过原点两次。
//         
//
//        提示：
//
//        1 <= path.length <= 10^4
//        path 仅由 {'N', 'S', 'E', 'W} 中的字符组成

import java.util.HashSet;
import java.util.Set;

public class P1496 {
    private class Solution {
        public boolean isPathCrossing(String path) {
            Set<String> set = new HashSet<>();
            int x = 0;
            int y = 0;
            for (char c : path.toCharArray()) {
                String key = "" + x + "," + y;
                if (set.contains(key)) {
                    return true;
                }
                set.add(key);
                switch (c) {
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                }
            }
            String key = "" + x + "," + y;
            return set.contains(key);
        }
    }
}
