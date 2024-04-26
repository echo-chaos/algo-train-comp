package org.lql.common;

/**
 * @description: 二元组
 * @author: liangqinglong
 * @date: 2024-04-23 17:58
 **/
public class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
