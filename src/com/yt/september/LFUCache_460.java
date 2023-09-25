package com.yt.september;

import java.util.HashMap;
import java.util.Map;

public class LFUCache_460 {
    /* 最不经常使用缓存 */
    private int capacity;
    // Map映射数据结构
    Map<Integer, DLinkedNode_460> cache = new HashMap<>();

    public LFUCache_460(int capacity) {
        this.capacity = capacity;
    }
    // get方法 - 如果key值存在缓存中，则获取键的值，否则返回-1
    public int get(int key) {
        if (cache.containsKey(key)) {
            // 让计数器加一，说明最近被使用了
            cache.get(key).count++;
            return cache.get(key).value;
        }
        return -1;
    }

    // put方法 - 如果键key已存在，则变更其值；如果不存在，则插入新的键值对, 当缓存容量达到capacity时，则应该插入新项之前，移除最不经常使用的项。
    // 在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。
    // 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。
    public void put(int key, int value) {
        DLinkedNode_460 node = cache.get(key);
        if(node == null) {
            DLinkedNode_460 newNode = new DLinkedNode_460(key, value, 1);
            cache.put(key, newNode);
            if (cache.size() > this.capacity) {
                // 移除最不经常使用的项, 按照count的值，把最小的移除
            }
        } else {
            node.value = value;
            node.count++;

        }
    }

//    private moveNode()

}
