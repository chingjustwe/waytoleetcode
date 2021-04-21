package cn.com.nightfield.list;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhochi
 * @create: 2021/4/18
 *
 * https://leetcode-cn.com/problems/lru-cache
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 *
 * 实现 LRUCache 类：
 *
 *     LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 *     int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 *     void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 **/
public class LRUCache {
    private int capacity;
    private Map<Integer, DuListNode> map;
    private DuListNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head = new DuListNode();
        tail = new DuListNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DuListNode node = map.get(key);
        if (node != null) {
            moveToHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        DuListNode oldNode = map.get(key);
        if (oldNode == null) {
            DuListNode node = new DuListNode(key, value);
            head.next.prev = node;
            node.next = head.next;
            head.next = node;
            node.prev = head;
            map.put(key, node);

            while (map.size() > capacity) {
                removeTail();
            }
        }
        else {
            oldNode.val = value;
            moveToHead(oldNode);
        }
    }

    private void moveToHead(DuListNode node) {
        DuListNode next = node.next, prev = node.prev;
        prev.next = next;
        next.prev = prev;

        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void removeTail() {
        int tailKey = tail.prev.key;
        map.remove(tailKey);
        DuListNode prev = tail.prev;
        tail.prev = prev.prev;
        prev.prev.next = tail;
    }

    class DuListNode {
        DuListNode prev;
        DuListNode next;
        int key;
        int val;

        DuListNode() {
        }

        DuListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
