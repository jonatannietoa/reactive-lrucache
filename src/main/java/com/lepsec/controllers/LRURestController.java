package com.lepsec.controllers;

import com.lepsec.services.LRUService;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

/**
 * Created by jonatannietoa on 13/2/17.
 */
@RestController
@RequestMapping("/api")
public class LRURestController {
    private LRUService lruService;

    @Autowired
    public LRURestController(LRUService lruService) {
        this.lruService = lruService;
    }

    @RequestMapping(value = "/lru/add", method = RequestMethod.POST)
    public int addStringInCache(@RequestParam String string){
        return lruService.addStringInLRU(string);
    }

    @RequestMapping(value = "/lru/{key}")
    public String getStringByKey(@PathVariable int key) throws Exception {
        return lruService.getStringFromLRU(key);
    }

    @RequestMapping(value = "/lru/state")
    public Observable<LinkedHashMap<Integer, String>> getLRUState(){
        return lruService.getLRUState();
    }
}
