package com.sp4beans.leetcode.easy.solved;

//        给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。
//
//        数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。
//
//        示例:
//
//        输入:
//        letters = ["c", "f", "j"]
//        target = "a"
//        输出: "c"
//
//        输入:
//        letters = ["c", "f", "j"]
//        target = "c"
//        输出: "f"
//
//        输入:
//        letters = ["c", "f", "j"]
//        target = "d"
//        输出: "f"
//
//        输入:
//        letters = ["c", "f", "j"]
//        target = "g"
//        输出: "j"
//
//        输入:
//        letters = ["c", "f", "j"]
//        target = "j"
//        输出: "c"
//
//        输入:
//        letters = ["c", "f", "j"]
//        target = "k"
//        输出: "c"
//        注:
//
//        letters长度范围在[2, 10000]区间内。
//        letters 仅由小写字母组成，最少包含两个不同的字母。
//        目标字母target 是一个小写字母。

public class P744 {
    private static class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            int min = 0;
            int max = letters.length - 1;
            int mid = min;
            while (max >= min) {
                mid = (max + min) >> 1;
                if (letters[mid] > target) {
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
            }

            return mid == letters.length - 1 && letters[mid] <= target
                    ? letters[0]
                    : letters[mid] <= target ? letters[mid + 1] : letters[mid];
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.nextGreatestLetter(new char[]{'c', 'c', 'f', 'j'}, 'd'));
        System.out.println(solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'g'));
        System.out.println(solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));
        System.out.println(solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'k'));
        System.out.println(solution.nextGreatestLetter(new char[]{'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n'}, 'e'));
    }
}
