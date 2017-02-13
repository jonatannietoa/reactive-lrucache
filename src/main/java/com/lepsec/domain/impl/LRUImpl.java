package com.lepsec.domain.impl;


import com.lepsec.domain.LRU;

/**
 * Created by jnieto on 13/2/17.
 */
public class LRUImpl implements LRU {
    private static LRUImpl ourInstance = new LRUImpl(3);

    public static LRUImpl getInstance() {
        return ourInstance;
    }

    public LRUImpl(int lruSize) {

    }

    public void put(int key, String value) {

    }

    public String get(int key) throws Exception {

        return "";
    }

    @Override
    public String toString(){

        return "";
    }
}
