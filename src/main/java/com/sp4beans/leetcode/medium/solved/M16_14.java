package com.sp4beans.leetcode.medium.solved;

//        给定一个二维平面及平面上的 N 个点列表Points，其中第i个点的坐标为Points[i]=[Xi,Yi]。请找出一条直线，其通过的点的数目最多。
//
//        设穿过最多点的直线所穿过的全部点编号从小到大排序的列表为S，你仅需返回[S[0],S[1]]作为答案，若有多条直线穿过了相同数量的点，则选择S[0]值较小的直线返回，S[0]相同则选择S[1]值较小的直线返回。
//
//        示例：
//
//        输入： [[0,0],[1,1],[1,0],[2,0]]
//        输出： [0,2]
//        解释： 所求直线穿过的3个点的编号为[0,2,3]
//        提示：
//
//        2 <= len(Points) <= 300
//        len(Points[i]) = 2

public class M16_14 {
    private static class Solution {

        private class Node {
            int dx;
            int dy;

            public Node(int dx, int dy) {
                this.dx = dx;
                this.dy = dy;
            }
        }

        public int[] bestLine(int[][] points) {
            int[] ans = new int[2];
            int maxCount = 0;
            for (int i = 0; i < points.length; i++) {
                int[] basePoint = points[i];
                for (int k = i + 1; k < points.length; k++) {
                    int[] newPoint = points[k];
                    int count = 1;
                    Node node = new Node(basePoint[0] - newPoint[0], basePoint[1] - newPoint[1]);
                    for (int j = k + 1; j < points.length; j++) {
                        int[] curPoint = points[j];
                        Node curNode = new Node(basePoint[0] - curPoint[0], basePoint[1] - curPoint[1]);
                        if (equals(node, curNode)) {
                            count++;
                        }
                    }
                    if (count > maxCount) {
                        maxCount = count;
                        ans = new int[] {i, k};
                    }
                }
            }
            return ans;
        }

        public boolean equals(Node a, Node b) {
            return a.dx * b.dy == a.dy * b.dx;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ans = solution.bestLine(new int[][] {{0, 0}, {1, 1}, {1, 0}, {2, 0}});
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
}
