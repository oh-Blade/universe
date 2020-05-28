package com.universe.ali;

import com.universe.leetCode.LRUCache;

/**
 * @Description 设计和实现一个 LRU(最近最少使用)缓存数据结构，使它应该支 持一下操作:get 和 put。
 * get(key) - 如果 key 存在于缓存中，则获取 key 的 value(总是正 数)，否则返回 -1。
 * put(key,value) - 如果 key 不存在，请设置或插入 value。当缓存 达到其容量时，它应该在插入新项目之前使最近最少使用的项目作 废。
 * @Author naikuo
 * @Date 2020/2/4 3:42 PM
 */
public class ALiLRUCache extends LRUCache {

    public ALiLRUCache(int capacity) {
        super(capacity);
    }
}
