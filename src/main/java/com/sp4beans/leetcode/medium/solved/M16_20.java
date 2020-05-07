package com.sp4beans.leetcode.medium.solved;

//        在老式手机上，用户通过数字键盘输入，手机将提供与这些数字相匹配的单词列表。每个数字映射到0至4个字母。给定一个数字序列，实现一个算法来返回匹配单词的列表。你会得到一张含有有效单词的列表。映射如下图所示：
//
//
//
//        示例 1:
//
//        输入: num = "8733", words = ["tree", "used"]
//        输出: ["tree", "used"]
//        示例 2:
//
//        输入: num = "2", words = ["a", "b", "c", "d"]
//        输出: ["a", "b", "c"]
//        提示：
//
//        num.length <= 1000
//        words.length <= 500
//        words[i].length == num.length
//        num中不会出现 0, 1 这两个数字

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class M16_20 {

    private class Solution {
        Set<Character>[] map;

        public List<String> getValidT9Words(String num, String[] words) {
            initMap();
            return Stream.of(words).filter(word -> isMatch(num, word)).collect(Collectors.toList());
        }

        public boolean isMatch(String num, String word) {
            if (num.length() != word.length()) {
                return false;
            }
            char[] nums = num.toCharArray();
            char[] words = word.toCharArray();
            for (int i = 0; i < num.length(); i++) {
                if (!map[nums[i] - '0'].contains(words[i])) {
                    return false;
                }
            }
            return true;
        }

        public void initMap() {
            map = new Set[10];
            for (int i = 0; i < 10; i++) {
                Set<Character> item = new HashSet<>();
                switch (i) {
                    case 2:
                        item.add('a');
                        item.add('b');
                        item.add('c');
                        break;
                    case 3:
                        item.add('d');
                        item.add('e');
                        item.add('f');
                        break;
                    case 4:
                        item.add('g');
                        item.add('h');
                        item.add('i');
                        break;
                    case 5:
                        item.add('j');
                        item.add('k');
                        item.add('l');
                        break;
                    case 6:
                        item.add('m');
                        item.add('n');
                        item.add('o');
                        break;
                    case 7:
                        item.add('p');
                        item.add('q');
                        item.add('r');
                        item.add('s');
                        break;
                    case 8:
                        item.add('t');
                        item.add('u');
                        item.add('v');
                        break;
                    case 9:
                        item.add('w');
                        item.add('x');
                        item.add('y');
                        item.add('z');
                        break;
                    default:
                        break;
                }
                map[i] = item;
            }
        }
    }

}
