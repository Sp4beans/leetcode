package com.sp4beans.leetcode.medium;

//        字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
//
//         
//
//        示例 1:
//
//        输入:
//        first = "pale"
//        second = "ple"
//        输出: True
//         
//
//        示例 2:
//
//        输入:
//        first = "pales"
//        second = "pal"
//        输出: False

public class M01_05 {
    private static class Solution {
        public boolean oneEditAway(String first, String second) {
            int lengthA = first.length();
            int lengthB = second.length();
            if (lengthA - lengthB == 1) {
                return isAddOrDelete(first, second);
            } else if (lengthA == lengthB) {
                return isReplace(first, second);
            } else if (lengthB - lengthA == 1) {
                return isAddOrDelete(second, first);
            }
            return false;
        }

        private boolean isAddOrDelete(String longer, String shorter) {
            boolean isShown = false;
            char[] lc = longer.toCharArray();
            char[] sc = shorter.toCharArray();
            for (int i = 0; i < sc.length; i++) {
                char curSc = sc[i];
                char curLc = isShown ? lc[i + 1] : lc[i];
                if (curSc != curLc) {
                    if (isShown) {
                        return false;
                    } else {
                        isShown = true;
                        i--;
                    }
                }
            }
            return true;
        }

        private boolean isReplace(String a, String b) {
            if (a.equals(b)) {
                return true;
            }

            char[] ac = a.toCharArray();
            char[] bc = b.toCharArray();
            int count = 0;
            for (int i = 0; i < ac.length; i++) {
                if (ac[i] != bc[i]) {
                    count ++;
                    if (count > 1) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

}
