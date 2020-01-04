package com.sp4beans.leetcode.easy;

//        机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
//
//        -2：向左转 90 度
//        -1：向右转 90 度
//        1 <= x <= 9：向前移动 x 个单位长度
//        在网格上有一些格子被视为障碍物。
//
//        第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
//
//        如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
//
//        返回从原点到机器人的最大欧式距离的平方。
//
//         
//
//        示例 1：
//
//        输入: commands = [4,-1,3], obstacles = []
//        输出: 25
//        解释: 机器人将会到达 (3, 4)
//        示例 2：
//
//        输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
//        输出: 65
//        解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class P874 {
    private static class Solution {
        public int robotSim(int[] commands, int[][] obstacles) {
            HashMap<Integer, Set<Integer>> x2y = new HashMap<>();
            HashMap<Integer, Set<Integer>> y2x = new HashMap<>();
            for (int[] ob : obstacles) {
                int x = ob[0];
                int y = ob[1];
                if (x2y.containsKey(x)) {
                    x2y.get(x).add(y);
                } else {
                    HashSet set = new HashSet<>();
                    set.add(y);
                    x2y.put(x, set);
                }
                if (y2x.containsKey(y)) {
                    y2x.get(y).add(x);
                } else {
                    HashSet set = new HashSet<>();
                    set.add(x);
                    y2x.put(y, set);
                }
            }

            // 0 up
            // 1 right
            // 2 down
            // 3 left
            int max = 0;
            int dir = 0;
            int ansX = 0;
            int ansY = 0;
            for (int command : commands) {
                if (command == -2) {
                    dir = (dir + 3) % 4;
                } else if (command == -1) {
                    dir = (dir + 1) % 4;
                } else if (dir == 0) {
                    Set<Integer> set = x2y.get(ansX);
                    for (int i = 0; i < command; i++) {
                        if (null != set && set.contains(ansY + 1)) {
                            break;
                        } else {
                            ansY++;
                        }
                    }
                } else if (dir == 1) {
                    Set<Integer> set = y2x.get(ansY);
                    for (int i = 0; i < command; i++) {
                        if (null != set && set.contains(ansX + 1)) {
                            break;
                        } else {
                            ansX++;
                        }
                    }
                } else if (dir == 2) {
                    Set<Integer> set = x2y.get(ansX);
                    for (int i = 0; i < command; i++) {
                        if (null != set && set.contains(ansY - 1)) {
                            break;
                        } else {
                            ansY--;
                        }
                    }
                } else if (dir == 3) {
                    Set<Integer> set = y2x.get(ansY);
                    for (int i = 0; i < command; i++) {
                        if (null != set && set.contains(ansX - 1)) {
                            break;
                        } else {
                            ansX--;
                        }
                    }
                }
                max = Integer.max(max, ansX * ansX + ansY * ansY);
            }
            return max;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.robotSim(new int[]{4, -1, 3}, new int[][]{}));
        System.out.println(solution.robotSim(new int[]{4, -1, 4, -2, 4}, new int[][]{{2, 4}}));
    }
}
