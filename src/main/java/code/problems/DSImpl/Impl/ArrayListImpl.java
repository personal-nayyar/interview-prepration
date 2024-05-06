package code.problems.DSImpl.Impl;

import code.problems.DSImpl.CustomArrayList;

import java.util.Arrays;


public class ArrayListImpl implements CustomArrayList {
    public static final int DEFAULT_CAPACITY = 10;
    int size = 0;

    Integer[] arr;

    ArrayListImpl(){
        arr = new Integer[DEFAULT_CAPACITY];
    }

    @Override
    public boolean add(Integer element) {
        ensureCapacity(size+1);
        arr[++size] =  element;
        return true;
    }

    @Override
    public Integer remove(int index) {
        checkIndexAndThrowException(index);
        Integer removedVal =  arr[index];
        int numShift =  arr.length - index - 1;
        if(numShift > 0)
            System.arraycopy(arr, index+1, arr, index, numShift);
        size--;
        return removedVal;
    }

    @Override
    public Integer get(int index) {
        checkIndexAndThrowException(index);
        return arr[index];
    }

    private void ensureCapacity(int capacity){
        int newCapacity = Math.max(capacity, size+size >> 1);
        grow(newCapacity);
    }

    private void grow(int capacity){
        arr = Arrays.copyOf(arr, capacity);
    }

    private void checkIndexAndThrowException(int index){
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
    }

}
