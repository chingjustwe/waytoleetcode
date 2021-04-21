package cn.com.nightfield.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: zhochi
 * @create: 2021/4/20
 *
 * https://leetcode-cn.com/problems/all-oone-data-structure
 *
 * 请你实现一个数据结构支持以下操作：
 *
 *     Inc(key) - 插入一个新的值为 1 的 key。或者使一个存在的 key 增加一，保证 key 不为空字符串。
 *     Dec(key) - 如果这个 key 的值是 1，那么把他从数据结构中移除掉。否则使一个存在的 key 值减一。如果这个 key 不存在，这个函数不做任何事情。key 保证不为空字符串。
 *     GetMaxKey() - 返回 key 中值最大的任意一个。如果没有元素存在，返回一个空字符串"" 。
 *     GetMinKey() - 返回 key 中值最小的任意一个。如果没有元素存在，返回一个空字符串""。
 *
 * 你能够以 O(1) 的时间复杂度实现所有操作吗？
 *
 **/
public class AllOne {
    Map<String, Integer> cache;
    Map<Integer, Set<String>> helper;
    int maxValue;
    int minValue;

    /** Initialize your data structure here. */
    public AllOne() {
        cache = new HashMap<>();
        helper = new HashMap<>();
        maxValue = 1;
        minValue = 1;
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        Integer value = cache.get(key);
        Set<String> keysWithValue;
        if (value == null) {
            value = 0;
            if (value < minValue) {
                minValue = 1;
            }
        }
        else {
            // remove key in old set
            keysWithValue = helper.get(value);
            keysWithValue.remove(key);
            if (keysWithValue.isEmpty() && value == minValue) {
                minValue++;
            }
        }
        cache.put(key, ++value);

        // add key in new set
        keysWithValue = helper.get(value);
        if (keysWithValue == null) {
            keysWithValue = new HashSet<>();
            helper.put(value, keysWithValue);
        }
        keysWithValue.add(key);

        // update threshold
        if (value > maxValue) {
            maxValue = value;
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        Integer value = cache.get(key);
        Set<String> keysWithValue;
        if (value == null) {
            return;
        }

        // remove in old set
        keysWithValue = helper.get(value);
        keysWithValue.remove(value);
        if (keysWithValue.isEmpty() && value == maxValue) {
            maxValue--;
        }

        if (value == 1) {
            cache.remove(key);
        }
        else {
            cache.put(key, --value);
            // add key in new set
            keysWithValue = helper.get(value);
            if (keysWithValue == null) {
                keysWithValue = new HashSet<>();
                helper.put(value, keysWithValue);
            }
            keysWithValue.add(key);
        }

        // update threshold
        if (value < minValue) {
            minValue = value;
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (helper.isEmpty()) {
            return "";
        }

        Set<String> keysWithValue = helper.get(maxValue);
        if (keysWithValue.isEmpty()) {
            return "";
        }

        return keysWithValue.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (helper.isEmpty()) {
            return "";
        }

        Set<String> keysWithValue = helper.get(minValue);
        if (keysWithValue.isEmpty()) {
            return "";
        }

        return keysWithValue.iterator().next();
    }

    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("hello");
        allOne.getMaxKey();
        allOne.getMinKey();
        allOne.inc("leet");
        allOne.getMaxKey();
        allOne.getMinKey();
    }
}
