package com.lepsec.controllers;

import com.lepsec.services.LRUService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by jonatannietoa on 20/2/17.
 */
public class LRURestControllerTest {
    @Mock
    private LRUService lruService;

    @InjectMocks
    private LRURestController lruRestController;

    @Before
    public void setUp() throws InterruptedException {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addStringInCache() throws InterruptedException {
        when(lruService.addStringInLRU("Message")).thenReturn(1);
        assertEquals(lruRestController.addStringInCache("Message"),1);
    }

    @Test
    public void getStringByKey() throws InterruptedException {
        when(lruService.getStringFromLRU(1)).thenReturn("Message");
        assertEquals(lruRestController.getStringByKey(1),"Message");
    }

    @Test
    public void getLRUState() throws InterruptedException {
        Map<Integer, String> lruMap = new LinkedHashMap<>();
        lruMap.put(1, "Message 1");
        lruMap.put(2, "Message 2");
        when(lruService.getLRUState()).thenReturn(lruMap);
        assertEquals(lruRestController.getLRUState().toString(),"{1=Message 1, 2=Message 2}");
    }

}