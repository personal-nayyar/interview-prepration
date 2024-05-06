package code.problems.DSImpl.Impl;

import java.util.HashMap;
import java.util.Map;

class Cache<K, V> {
    private final Map<K, CacheEntry<V>> cacheMap;
    private final long defaultExpirationMs;
    private final Thread cleanupThread;

    public Cache(long defaultExpirationMs) {
        this.cacheMap = new HashMap<>();
        this.defaultExpirationMs = defaultExpirationMs;

        // Start the cleanup thread
        this.cleanupThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(defaultExpirationMs);
                    cleanupExpiredEntries();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        this.cleanupThread.setDaemon(true);
        this.cleanupThread.start();
    }

    public void set(K key, V value) {
        set(key, value, defaultExpirationMs);
    }

    public void set(K key, V value, long expirationMs) {
        long expirationTime = expirationMs > 0 ? System.currentTimeMillis() + expirationMs : Long.MAX_VALUE;
        cacheMap.put(key, new CacheEntry<>(value, expirationTime));
    }

    public V get(K key) {
        CacheEntry<V> entry = cacheMap.get(key);
        return entry != null && !isExpired(entry) ? entry.getValue() : null;
    }

    public void remove(K key) {
        cacheMap.remove(key);
    }

    public boolean contains(K key) {
        return cacheMap.containsKey(key);
    }

    public void clear() {
        cacheMap.clear();
    }

    private boolean isExpired(CacheEntry<V> entry) {
        return entry.getExpirationTime() <= System.currentTimeMillis();
    }

    private void cleanupExpiredEntries() {
        cacheMap.entrySet().removeIf(entry -> isExpired(entry.getValue()));
    }

    private static class CacheEntry<V> {
        private final V value;
        private final long expirationTime;

        public CacheEntry(V value, long expirationTime) {
            this.value = value;
            this.expirationTime = expirationTime;
        }

        public V getValue() {
            return value;
        }

        public long getExpirationTime() {
            return expirationTime;
        }
    }
}

public class RedisLikeCache {
    public static void main(String[] args) {
        Cache<String, String> cache = new Cache<>(5000); // Default expiration time of 5 seconds

        // Set some key-value pairs
        cache.set("key1", "value1");
        cache.set("key2", "value2", 3000); // Set expiration time of 3 seconds for key2

        // Retrieve values
        System.out.println("Value for key1: " + cache.get("key1"));
        System.out.println("Value for key2: " + cache.get("key2"));

        // Wait for expiration of key2
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Retrieve values after expiration
        System.out.println("Value for key1 after expiration: " + cache.get("key1"));
        System.out.println("Value for key2 after expiration: " + cache.get("key2"));
    }
}
