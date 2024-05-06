package code.problems.DSImpl.Impl;

import code.problems.DSImpl.CustomMap;

import java.util.HashMap;
import java.util.Map;

public class HashMapImpl implements CustomMap {
    public static final int DEFAULT_CAPACITY =  16;
    int size = 0;

    Entry<Integer, Integer> buckets[];

    HashMapImpl(){
        buckets = new Entry[DEFAULT_CAPACITY];
    }

    int getIndex(Integer key){
        return key.hashCode()%buckets.length;
    }

    @Override
    public Integer put(Integer key, Integer val) {
        int bucketIndex = getIndex(key);
        Entry<Integer,Integer> entry = buckets[bucketIndex];
        if(entry == null){ // old value not present
            buckets[bucketIndex] = new Entry<>(key, val);
            size++;
            return val;
        } else {
            while(entry.next != null){
                if(entry.key.equals(key)){ // old value present
                    Integer oldValue = entry.value;
                    entry.value = val;
                    return oldValue;
                }
                entry = entry.next;
            }
            if(entry.key.equals(key)){
                Integer oldValue = entry.value;
                entry.value = val;
                return oldValue;
            }
            entry.next = new Entry<>(key, val); // old value not present
            size++;
            return val;
        }
    }

    @Override
    public Integer get(Integer key) {
        int bucketIndex = getIndex(key);
        Entry<Integer,Integer> entry = buckets[bucketIndex];
        while(entry != null){
            if(entry.key.equals(key)){
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    @Override
    public Integer remove(Integer key) {
        int bucketIndex = getIndex(key);
        Entry<Integer,Integer> entry = buckets[bucketIndex];
        Entry<Integer,Integer> prev = null;
        while(entry != null){
            if(entry.key.equals(key)){
                if(prev == null){
                    buckets[bucketIndex] = entry.next;
                } else {
                    prev.next = entry.next;
                }
                size--;
                return entry.value;
            }
            prev = entry;
            entry = entry.next;
        }
        return null;
    }
}
