package com.lepsec.domain;

import java.util.Map;

/**
 * Created by jonatannietoa on 13/2/17.
 */
public interface LRU {
    void put(int key, String value);

    String get(int key) throws NullPointerException;

    Map<Integer,String> getLRU();
}
