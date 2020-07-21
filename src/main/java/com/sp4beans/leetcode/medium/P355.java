package com.sp4beans.leetcode.medium;

//        设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
//
//        postTweet(userId, tweetId): 创建一条新的推文
//        getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
//        follow(followerId, followeeId): 关注一个用户
//        unfollow(followerId, followeeId): 取消关注一个用户
//        示例:
//
//        Twitter twitter = new Twitter();
//
//        // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
//        twitter.postTweet(1, 5);
//
//        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//        twitter.getNewsFeed(1);
//
//        // 用户1关注了用户2.
//        twitter.follow(1, 2);
//
//        // 用户2发送了一个新推文 (推文id = 6).
//        twitter.postTweet(2, 6);
//
//        // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
//        // 推文id6应当在推文id5之前，因为它是在5之后发送的.
//        twitter.getNewsFeed(1);
//
//        // 用户1取消关注了用户2.
//        twitter.unfollow(1, 2);
//
//        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//        // 因为用户1已经不再关注用户2.
//        twitter.getNewsFeed(1);

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P355 {
    private class Twitter {

        private Map<Integer, LinkedList<Integer>> userToTwitter;
        private Map<Integer, Set<Integer>> friends;
        private Map<Integer, Integer> tweets;
        private int idx = 0;

        /**
         * Initialize your data structure here.
         */
        public Twitter() {
            userToTwitter = new HashMap<>();
            friends = new HashMap<>();
            tweets = new HashMap<>();
        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {
            tweets.put(tweetId, idx++);
            LinkedList<Integer> tweets = userToTwitter.computeIfAbsent(userId, e -> new LinkedList<>());
            tweets.addLast(tweetId);
            while (tweets.size() > 10) {
                tweets.removeFirst();
            }
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted
         * by users who the user followed or by the user herself. Tweets must be ordered from most recent to least
         * recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            Set<Integer> friendSet = friends.computeIfAbsent(userId, e -> new HashSet<>());

            List<Integer> result = new ArrayList<>();

            result.addAll(userToTwitter.computeIfAbsent(userId, e -> new LinkedList<>()));
            for (int uid : friendSet) {
                result.addAll(userToTwitter.computeIfAbsent(uid, e -> new LinkedList<>()));
            }

            result.sort(Comparator.comparingInt(tweets::get).reversed());

            return result.size() > 10 ? result.subList(0, 10) : result;
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int followerId, int followeeId) {
            if (followeeId != followerId) {
                Set<Integer> friendSet = friends.computeIfAbsent(followerId, e -> new HashSet<>());
                friendSet.add(followeeId);
            }
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId) {
            Set<Integer> friendSet = friends.computeIfAbsent(followerId, e -> new HashSet<>());
            friendSet.remove(followeeId);
        }
    }

    /**
     * Your Twitter object will be instantiated and called as such:
     * Twitter obj = new Twitter();
     * obj.postTweet(userId,tweetId);
     * List<Integer> param_2 = obj.getNewsFeed(userId);
     * obj.follow(followerId,followeeId);
     * obj.unfollow(followerId,followeeId);
     */
}
