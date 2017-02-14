package com.lepsec.services;

import io.reactivex.Observable;

import java.util.LinkedHashMap;

/**
 * Created by jonatannietoa on 13/2/17.
 */
public interface LRUService {
    int addStringInLRU(String string);

    String getStringFromLRU(int id) throws Exception;

    Observable<LinkedHashMap<Integer,String>> getLRUState();
}
