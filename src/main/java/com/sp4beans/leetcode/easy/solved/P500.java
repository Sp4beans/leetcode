package com.sp4beans.leetcode.easy.solved;


//        给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
//
//        示例：
//
//        输入: ["Hello", "Alaska", "Dad", "Peace"]
//        输出: ["Alaska", "Dad"]
//         
//
//        注意：
//
//        你可以重复使用键盘上同一字符。
//        你可以假设输入的字符串将只包含字母。

import java.util.ArrayList;
import java.util.List;

public class P500 {
    private static class Solution {
        private static final String REG = "[q,w,e,r,t,y,u,i,o,p,Q,W,E,R,T,Y,U,I,O,P]+|[a,s,d,f,g,h,j,k,l,A,S,D,F,G,H,J,K,L]+|[z,x,c,v,b,n,m,Z,X,C,V,B,N,M]+";


        public String[] findWords(String[] words) {

            List<String> result = new ArrayList<>();
            for (String word : words) {
                if (word.matches(REG)) {
                    result.add(word);
                }
            }
            String[] ret = new String[result.size()];
            return result.toArray(ret);
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"}));
    }

}
