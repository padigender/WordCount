package com.padigender.wordcount.service;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

import java.io.IOException;

/**
 * Created by pkyasaram on 4/4/16.
 */
public class WordCountServiceTest {

    @BeforeClass
    public static void oneTimeSetUp() {
        try {
            System.out.println("Building Index...");
            IndexBuilder.buildIndex();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testSearch(){


        for(int i=1; i< 10; i++) {
            String res  = WordCountImpl.getWordCount("what");
            System.out.println(res);
            Assert.assertEquals(res, "10357," +i);
        }
    }

}
