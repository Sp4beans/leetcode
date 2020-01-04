package com.sp4beans.leetcode.easy;

//        在无限的平面上，机器人最初位于 (0, 0) 处，面朝北方。机器人可以接受下列三条指令之一：
//
//        "G"：直走 1 个单位
//        "L"：左转 90 度
//        "R"：右转 90 度
//        机器人按顺序执行指令 instructions，并一直重复它们。
//
//        只有在平面中存在环使得机器人永远无法离开时，返回 true。否则，返回 false。
//
//         
//
//        示例 1：
//
//        输入："GGLLGG"
//        输出：true
//        解释：
//        机器人从 (0,0) 移动到 (0,2)，转 180 度，然后回到 (0,0)。
//        重复这些指令，机器人将保持在以原点为中心，2 为半径的环中进行移动。
//        示例 2：
//
//        输入："GG"
//        输出：false
//        解释：
//        机器人无限向北移动。
//        示例 3：
//
//        输入："GL"
//        输出：true
//        解释：
//        机器人按 (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ... 进行移动。

public class P1041 {
    private static class Solution {
        public boolean isRobotBounded(String instructions) {

            int x = 0;
            int y = 0;
            // 1 right
            // 2 left
            // 3 up
            // 4 down
            int dir = 3;

            for (int i = 0; i < 4; i++) {
                for (char c : instructions.toCharArray()) {
                    if (c == 'G') {
                        switch (dir) {
                            case 1:
                                x++;
                                break;
                            case 2:
                                x--;
                                break;
                            case 3:
                                y++;
                                break;
                            case 4:
                                y--;
                                break;
                        }
                    } else if (c == 'L') {
                        switch (dir) {
                            case 1:
                                dir = 3;
                                break;
                            case 2:
                                dir = 4;
                                break;
                            case 3:
                                dir = 2;
                                break;
                            case 4:
                                dir = 1;
                                break;
                        }
                    } else if (c == 'R') {
                        switch (dir) {
                            case 1:
                                dir = 4;
                                break;
                            case 2:
                                dir = 3;
                                break;
                            case 3:
                                dir = 1;
                                break;
                            case 4:
                                dir = 2;
                                break;
                        }
                    }
                }
            }

            return x == 0 && y == 0;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.isRobotBounded("GGLLGG"));
        System.out.println(solution.isRobotBounded("GG"));
        System.out.println(solution.isRobotBounded("GGL"));
    }
}
