package com.sp4beans.leetcode.easy;

//        给你一个不同学生的分数列表，请按 学生的 id 顺序 返回每个学生 最高的五科 成绩的 平均分。
//
//        对于每条 items[i] 记录， items[i][0] 为学生的 id，items[i][1] 为学生的分数。平均分请采用整数除法计算。
//
//         
//
//        示例：
//
//        输入：[[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
//        输出：[[1,87],[2,88]]
//        解释：
//        id = 1 的学生平均分为 87。
//        id = 2 的学生平均分为 88.6。但由于整数除法的缘故，平均分会被转换为 88。
//         
//
//        提示：
//
//        1 <= items.length <= 1000
//        items[i].length == 2
//        学生的 ID 在 1 到 1000 之间
//        学生的分数在 1 到 100 之间
//        每个学生至少有五个分数

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class P1086 {
    private class Solution {
        public int[][] highFive(int[][] items) {
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            List<Integer> idList = new ArrayList<>();
            for (int[] item : items) {
                int id = item[0];
                int score = item[1];
                if (map.containsKey(id)) {
                    map.get(id).add(score);
                } else {
                    idList.add(id);
                    List<Integer> temp = new ArrayList<>();
                    temp.add(score);
                    map.put(id, temp);
                }
            }

            Collections.sort(idList);

            int[][] ans = new int[idList.size()][2];
            for (int i = 0; i < idList.size(); i++) {
                int id = idList.get(i);

                ans[i][0] = id;

                int sum = 0;
                List<Integer> list = map.get(id);
                Collections.sort(list);
                for (int j = list.size() - 1; j > list.size() - 6; j--) {
                    sum += list.get(j);
                }
                ans[i][1] = sum / 5;
            }

            return ans;
        }
    }
}
