package code.problems.DSImpl.Impl;

import code.problems.DSImpl.LRUCache;

import java.util.LinkedHashMap;

public class LRUCacheImpl implements LRUCache {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCacheImpl(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }

    LinkedHashMap<Integer, Integer> cache;
    final int INITIAL_CAP;
    int size = 0;
    LRUCacheImpl(int capacity){
        cache =  new LinkedHashMap<>(capacity);
        INITIAL_CAP = capacity;
    }
    @Override
    public int get(int key) {
        if (cache.containsKey(key)){
            int val =  cache.remove(key);
            cache.put(key, val); // add at the end most recent used
            System.out.println("return "+val);
            return val;
        }
        System.out.println("return "+ "-1");
        return -1;
    }

    @Override
    public void put(int key, int val) {
        if (cache.size() == INITIAL_CAP){
            // get first element
            int firstKey = cache.keySet().stream().findFirst().get(); // get the first key i.e. least recently used
            cache.remove(firstKey);
        }
        cache.put(key,val);
        System.out.println("cache is "+cache);
    }

    @Override
    public String toString(){
        return cache.toString();
    }
}
