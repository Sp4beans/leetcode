package com.sp4beans.leetcode.easy;

//        稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
//
//        示例1:
//
//        输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
//        输出：-1
//        说明: 不存在返回-1。
//        示例2:
//
//        输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
//        输出：4
//        提示:
//
//        words的长度在[1, 1000000]之间

public class M10_05 {

    private static class Solution {
        public int findString(String[] words, String s) {
            int low = 0;
            int high = words.length - 1;
            int ans = -1;
            while (low <= high) {
                int mid = (low + high) >> 1;
                int newMid = mid;
                while (words[newMid].equals("") && newMid < high) {
                    newMid++;
                }
                if (words[newMid].equals("")) {
                    high = mid - 1;
                    continue;
                }

                if (words[newMid].equals(s)) {
                    ans = newMid;
                    break;
                } else if (words[newMid].compareTo(s) > 0) {
                    high = newMid - 1;
                } else {
                    low = newMid + 1;
                }
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.findString(new String[]{"at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""}, "ta"));
//        System.out.println(solution.findString(new String[]{"at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""}, "ball"));
        System.out.println(solution.findString(new String[]{"DirNnILhARNS hOYIFB", "SM ", "YSPBaovrZBS", "evMMBOf", "mCrS", "oRJfjw gwuo", "xOpSEXvfI"}, "mCrS"));
    }
}
