package com.padigender.wordcount.service;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

import java.io.IOException;
import java.util.concurrent.ThreadPoolExecutor;

class RunSearch implements Runnable {
    private Thread t;
    private String threadName;

    RunSearch( String name){
        threadName = name;
    }
    public void run() {
        System.out.println("Running " +  threadName );
        long time = System.currentTimeMillis();
        String res  = WordCountImpl.getWordCount("what");
        time = System.currentTimeMillis() - time;
        System.out.println("Time :" + time);
        System.out.println(res);
        //Assert.assertEquals(res, "10357," +threadName);
    }

    public void start ()
    {
        System.out.println("Starting " +  threadName );
        if (t == null)
        {
            t = new Thread (this, threadName);
            t.start ();
        }
    }

}
/**
 * Created by pkyasaram on 4/4/16.
 */
public class WordCountServiceTest {

    //@BeforeClass
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
        for(int i=1; i< 10000; i++) {
            RunSearch searchTask1 = new RunSearch(i+"");
            searchTask1.start();
            RunSearch searchTask2 = new RunSearch(i+1+"");
            searchTask2.start();
        }
    }

}
