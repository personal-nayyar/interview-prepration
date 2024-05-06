package code.problems.DSImpl.Impl;

import code.problems.DSImpl.CustomMap;

import java.awt.desktop.PreferencesEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentHashMapImpl implements CustomMap {

    public static final int DEFAULT_CAPACITY =  16;

    Map<Integer, Integer> segments[];
    ReentrantLock[] locks;

    int size = 0;

    ConcurrentHashMapImpl(){
        segments = new Map[DEFAULT_CAPACITY];
        locks =  new ReentrantLock[DEFAULT_CAPACITY];
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            segments[i] = new HashMap<>();
            locks[i] = new ReentrantLock();
        }
    }

    int getIndex(Integer key){
        return key.hashCode()%segments.length;
    }

    @Override
    public Integer put(Integer key, Integer val) {
        int bucketIndex = getIndex(key);
        locks[bucketIndex].lock(); // acquire lock
        try{
            Map<Integer, Integer> map = segments[bucketIndex];
            Integer v = map.get(key);
            if (v == null){ // old value not present
                // put in map/segments
                map.put(key,val);
                size++;
            }else{ // update
                map.put(key,val);
            }
        }finally {
            locks[bucketIndex].unlock(); // release the lock
        }
        return val;
    }

    @Override
    public Integer get(Integer key) {
        int segmentIndex = getIndex(key);
        Map<Integer,Integer> segment = segments[segmentIndex];
        return segment.get(key);
    }

    @Override
    public Integer remove(Integer key) {
        int segmentIndex = getIndex(key);
        locks[segmentIndex].lock();
        try{
            Map<Integer,Integer> segment = segments[segmentIndex];
            Integer oldValue = segment.get(key);
            if(oldValue != null){
                segment.remove(key);
                size--;
            }
            return oldValue;
        } finally {
            locks[segmentIndex].unlock();
        }
    }
}
