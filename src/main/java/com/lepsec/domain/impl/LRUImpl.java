package com.lepsec.domain.impl;


import com.lepsec.domain.LRU;

import java.util.LinkedHashMap;

/**
 * Created by jonatannietoa on 13/2/17.
 */
public class LRUImpl implements LRU {
    private static LRUImpl ourInstance = new LRUImpl(3);
    private LinkedHashMap<Integer,String> lruMap;
    private int lruSize;

    public static LRUImpl getInstance() {
        return ourInstance;
    }

    public LRUImpl(int lruSize) {
        this.lruMap = new LinkedHashMap<Integer, String>();
        this.lruSize = lruSize;
    }

    public void put(int key, String value) {
        if(lruMap.values().size()>=lruSize){
            lruMap.remove(lruMap.keySet().iterator().next());
        }
        lruMap.put(key, value);
    }

    public String get(int key) throws Exception {
        if(lruMap.get(key)!=null){
            final String value = lruMap.get(key);
            lruMap.remove(key);
            lruMap.put(key, value);
            return value;
        } else {
            throw new NullPointerException("Key is not in cache");
        }
    }

    @Override
    public LinkedHashMap<Integer, String> getLRU() {
        return this.lruMap;
    }

    @Override
    public String toString(){
        String lruString = "";
        for (String value : lruMap.values()) {
            lruString = lruString + value + " ";
        }
        return lruString;
    }
}
