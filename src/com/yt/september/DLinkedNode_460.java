package com.yt.september;

public class DLinkedNode_460 {
    /**
     * 用于解决LFU（最近最久未使用）问题的数据结构
     * 键和值 - 还需要一个计数器
     */
    int key;
    int value;
    int count;
    // 头指针
    DLinkedNode_460 prev;
    // 尾指针
    DLinkedNode_460 next;
    public DLinkedNode_460() {}
    public DLinkedNode_460(int key_, int value_, int count_) {
        key = key_;
        value = value_;
        count = count_;
    }
}
