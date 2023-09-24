package com.yt.september;

import java.util.*;

public class LRUCache_146 {
    // 创建一个 哈希表+双向链表
    private Map<Integer, DLinkedNode_146> cache = new HashMap<Integer, DLinkedNode_146>();
    private int size;
    private int capacity;
    private DLinkedNode_146 head, tail;
    public LRUCache_146(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode_146();
        tail = new DLinkedNode_146();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode_146 node = cache.get(key);
        // 判断是否存在
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，然后再移到头部 （表示使用过一次）
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        // 使用put方法时: 1. 判断是否本身包含key 2. 判断容量是否超限
        DLinkedNode_146 node = cache.get(key);
        if(node == null){
            // 如果key不存在，创建一个新的节点
            DLinkedNode_146 newNode = new DLinkedNode_146(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加到双端队列的头部
            addToHead(newNode);
            if(cache.size() > this.capacity) {
                // 移除最后一个
                DLinkedNode_146 tail = removeTail();
                // 哈希表中对应的项也要去掉
                cache.remove(tail.key);
            }
        } else {
            // 不为空，key存在，覆盖原来的值，并将其移动到头部
            node.value = value;
            moveToHead(node);
        }
    }
    // 将一个新的节点移动到头部
    private void addToHead(DLinkedNode_146 node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next= node;
    }
    // 将节点移除
    private void removeNode(DLinkedNode_146 node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    // 将某个后面的节点移到头部
    private void moveToHead(DLinkedNode_146 node) {
        removeNode(node);
        addToHead(node);
    }
    // 移除尾部节点
    private DLinkedNode_146 removeTail() {
        DLinkedNode_146 res = tail.prev;
        removeNode(res);
        return res;
    }

    public static void main(String[] args) {

    }
}
