package HashMap;

import java.util.Arrays;

public class MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;

    private Entry<K, V>[] buckets;
    private int size;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        this.buckets = (Entry<K, V>[]) new Entry[DEFAULT_CAPACITY];
        this.size = 0;
    }

    private int getBucketIndex(K key) {
        int hash = key == null ? 0 : key.hashCode();
        return Math.abs(hash) % buckets.length;
    }

    private boolean keysEqual(K key1, K key2) {
        return (key1 == null && key2 == null) ||
                (key1 != null && key1.equals(key2));
    }

    public V put(K key, V value) {
        int index = getBucketIndex(key);
        Entry<K, V> bucket = buckets[index];

        if (bucket == null) {
            buckets[index] = new Entry<>(key, value);
            size++;
            return null;
        }

        Entry<K, V> current = bucket;
        while (current != null) {
            if (keysEqual(current.key, key)) {
                V oldValue = current.value;
                current.value = value;
                return oldValue;
            }
            current = current.next;
        }

        Entry<K, V> newEntry = new Entry<>(key, value);
        newEntry.next = bucket;
        buckets[index] = newEntry;
        size++;
        return null;
    }

    public V get(Object key) {
        int index = getBucketIndex((K) key);
        Entry<K, V> bucket = buckets[index];

        while (bucket != null) {
            if (keysEqual(bucket.key, (K) key)) {
                return bucket.value;
            }
            bucket = bucket.next;
        }
        return null;
    }

    public V remove(Object key) {
        int index = getBucketIndex((K) key);
        Entry<K, V> bucket = buckets[index];
        Entry<K, V> prev = null;

        while (bucket != null) {
            if (keysEqual(bucket.key, (K) key)) {
                V removedValue = bucket.value;

                if (prev == null) {
                    buckets[index] = bucket.next;
                } else {
                    prev.next = bucket.next;
                }
                size--;
                return removedValue;
            }
            prev = bucket;
            bucket = bucket.next;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        Arrays.fill(buckets, null);
        size = 0;
    }

    private static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
