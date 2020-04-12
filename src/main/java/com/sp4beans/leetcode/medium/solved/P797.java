package com.sp4beans.leetcode.medium.solved;

//        给一个有 n 个结点的有向无环图，找到所有从 0 到 n-1 的路径并输出（不要求按顺序）
//
//        二维数组的第 i 个数组中的单元都表示有向图中 i 号结点所能到达的下一些结点（译者注：有向图是有方向的，即规定了a→b你就不能从b→a）空就是没有下一个结点了。
//
//        示例:
//        输入: [[1,2], [3], [3], []]
//        输出: [[0,1,3],[0,2,3]]
//        解释: 图是这样的:
//        0--->1
//        |    |
//        v    v
//        2--->3
//        这有两条路: 0 -> 1 -> 3 和 0 -> 2 -> 3.
//        提示:
//
//        结点的数量会在范围 [2, 15] 内。
//        你可以把路径以任意顺序输出，但在路径内的结点的顺序必须保证。

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P797 {
    private class Solution {

        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

            for (int i = 0; i < graph.length; i++) {
                HashSet<Integer> set = new HashSet<Integer>();
                for (int num : graph[i]) {
                    set.add(num);
                }
                map.put(i, set);
            }

            List<Integer> tmp = new ArrayList<>();
            tmp.add(0);
            func(tmp, graph.length - 1);
            return ans;
        }

        public void func(List<Integer> curList, int end) {
            int last = curList.get(curList.size() - 1);
            if (last == end) {
                List<Integer> ansItem = new ArrayList<>();
                ansItem.addAll(curList);
                ans.add(ansItem);
                return;
            }
            for (int num : map.get(last)) {
                curList.add(num);
                func(curList, end);
                curList.remove(curList.size() - 1);
            }
        }
    }
}
