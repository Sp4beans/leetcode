package com.sp4beans.leetcode.easy.solved;

//	给一个 非空 字符串 s 和一个单词缩写 abbr ，判断这个缩写是否可以是给定单词的缩写。
//
//	字符串 "word" 的所有有效缩写为：
//
//	["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
//	注意单词 "word" 的所有有效缩写仅包含以上这些。任何其他的字符串都不是 "word" 的有效缩写。
//
//	注意:
//	假设字符串 s 仅包含小写字母且 abbr 只包含小写字母和数字。
//
//	示例 1:
//
//	给定 s = "internationalization", abbr = "i12iz4n":
//
//	函数返回 true.
//	 
//
//	示例 2:
//
//	给定 s = "apple", abbr = "a2e":
//
//	函数返回 false.

public class P408 {

	private static class Solution {

		public boolean validWordAbbreviation(String word, String abbr) {

			char[] wordArray = word.toCharArray();
			char[] abbrArray = abbr.toCharArray();

			int index = 0;
			int curCount = 0;
			for (char c : abbrArray) {
				if (c >= '0' && c <= '9') {
					if (curCount == 0 && c == '0') {
						return false;
					}
					curCount = curCount * 10 + (c - '0');
				} else {
					if (curCount + index >= wordArray.length) {
						return false;
					}
					if (wordArray[curCount + index] != c) {
						return false;
					}
					index = index + curCount + 1;
					curCount = 0;
				}
			}

			return index + curCount == wordArray.length;
		}
	}

	public static void main(String args[]) {
		Solution solution = new Solution();
		System.out.println(solution.validWordAbbreviation("internationalization", "i12iz4n"));
		System.out.println(solution.validWordAbbreviation("apple", "a2e"));
	}

}
