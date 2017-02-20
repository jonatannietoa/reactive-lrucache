package com.lepsec.services;

import java.util.Map;

/**
 * Created by jonatannietoa on 13/2/17.
 */
public interface LRUService {
    int addStringInLRU(String string);

    String getStringFromLRU(int id) throws NullPointerException;

    Map<Integer,String> getLRUState();
}
