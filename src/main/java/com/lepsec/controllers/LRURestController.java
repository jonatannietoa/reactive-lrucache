package com.lepsec.controllers;

import com.lepsec.services.LRUService;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subscribers.ResourceSubscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by jonatannietoa on 13/2/17.
 */
@RestController
@RequestMapping("/api")
public class LRURestController {
    private LRUService lruService;
    private Map<Integer,String> linkedHashMap;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public LRURestController(LRUService lruService) {
        this.lruService = lruService;
        this.linkedHashMap = new LinkedHashMap<>();
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
    public Map<Integer,String> getLRUState() throws InterruptedException {

        ResourceSubscriber<Map<Integer,String>> subscriber = new ResourceSubscriber<Map<Integer,String>>() {
            @Override
            public void onNext(Map<Integer,String> s) {
                linkedHashMap = s;
            }

            @Override
            public void onError(Throwable throwable) {
                log.error(throwable.getMessage());
            }

            @Override
            public void onComplete() {
                log.info("Complete");
            }
        };
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(Flowable.just(lruService.getLRUState()).subscribeWith(subscriber));

        Thread.sleep(5000);

        return linkedHashMap;
    }
}
