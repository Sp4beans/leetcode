package com.sp4beans.leetcode.easy.solved;

//        给定一个嵌套的整数列表，请返回该列表按深度加权后所有整数的总和。
//
//        每个元素要么是整数，要么是列表。同时，列表中元素同样也可以是整数或者是另一个列表。
//
//        示例 1:
//
//        输入: [[1,1],2,[1,1]]
//        输出: 10
//        解释: 因为列表中有四个深度为 2 的 1 ，和一个深度为 1 的 2。
//        示例 2:
//
//        输入: [1,[4,[6]]]
//        输出: 27
//        解释: 一个深度为 1 的 1，一个深度为 2 的 4，一个深度为 3 的 6。所以，1 + 4*2 + 6*3 = 27。

import java.util.List;

public class P339 {
    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     * // Constructor initializes an empty nested list.
     * public NestedInteger();
     * <p>
     * // Constructor initializes a single integer.
     * public NestedInteger(int value);
     * <p>
     * // @return true if this NestedInteger holds a single integer, rather than a nested list.
     * public boolean isInteger();
     * <p>
     * // @return the single integer that this NestedInteger holds, if it holds a single integer
     * // Return null if this NestedInteger holds a nested list
     * public Integer getInteger();
     * <p>
     * // Set this NestedInteger to hold a single integer.
     * public void setInteger(int value);
     * <p>
     * // Set this NestedInteger to hold a nested list and adds a nested integer to it.
     * public void add(NestedInteger ni);
     * <p>
     * // @return the nested list that this NestedInteger holds, if it holds a nested list
     * // Return null if this NestedInteger holds a single integer
     * public List<NestedInteger> getList();
     * }
     */

    private interface NestedInteger {

        boolean isInteger();

        Integer getInteger();

        void setInteger(int value);

        void add(NestedInteger ni);

        List<NestedInteger> getList();

    }

    private class Solution {
        public int depthSum(List<NestedInteger> nestedList) {
            return calc(nestedList, 1);
        }

        public int calc(List<NestedInteger> nestedList, int depth) {
            int ans = 0;
            for (NestedInteger ni : nestedList) {
                if (ni.isInteger()) {
                    ans += ni.getInteger() * depth;
                } else {
                    ans += calc(ni.getList(), depth + 1);
                }
            }
            return ans;
        }
    }
}
