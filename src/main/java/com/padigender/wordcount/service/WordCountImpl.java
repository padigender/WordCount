package com.padigender.wordcount.service;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by pkyasaram on 4/5/16.
 */
public class WordCountImpl {

    private static Map<String,Integer> wordMap = new HashMap<String, Integer>();

    public static String getWordCount(String word) {

        String wordCount = DataScanner.searchWord(word);
        Integer count = wordMap.get(word);
        if(count == null){
            wordMap.put(word,1);
            count = 1;
        } else {
            count++;
            wordMap.put(word,count);
        }
        String wordRequests = count.toString();
        return wordCount +"," + wordRequests;
    }
}