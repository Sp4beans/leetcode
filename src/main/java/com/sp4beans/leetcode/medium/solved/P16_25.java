package com.sp4beans.leetcode.medium.solved;

//        设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存被填满时，它应该删除最近最少使用的项目。
//
//        它应该支持以下操作： 获取数据 get 和 写入数据 put 。
//
//        获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
//        写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
//
//        示例:
//
//        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.get(1);       // 返回  1
//        cache.put(3, 3);    // 该操作会使得密钥 2 作废
//        cache.get(2);       // 返回 -1 (未找到)
//        cache.put(4, 4);    // 该操作会使得密钥 1 作废
//        cache.get(1);       // 返回 -1 (未找到)
//        cache.get(3);       // 返回  3
//        cache.get(4);       // 返回  4

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class P16_25 {
    private class LRUCache {

        Map<Integer, Integer> map;
        LinkedList<Integer> lru;
        int cap;
        int cur;

        public LRUCache(int capacity) {
            this.map = new HashMap<>();
            this.lru = new LinkedList<>();
            this.cap = capacity;
            this.cur = 0;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                lru.removeFirstOccurrence(key);
                lru.addLast(key);
                return map.get(key);
            }
            return -1;
        }

        public void put(int key, int value) {
            if (!map.containsKey(key)) {
                if (cur < cap) {
                    map.put(key, value);
                    lru.addLast(key);
                    cur++;
                } else {
                    int k = lru.pop();
                    map.remove(k);
                    map.put(key, value);
                    lru.removeFirstOccurrence(key);
                    lru.addLast(key);
                }
            } else {
                map.put(key, value);
                lru.removeFirstOccurrence(key);
                lru.addLast(key);
            }
        }
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
}
