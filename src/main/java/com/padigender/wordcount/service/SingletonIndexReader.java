package com.padigender.wordcount.service;

import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;

import static java.nio.file.Paths.get;

/**
 * Created by pkyasaram on 4/7/16.
 */
public class SingletonIndexReader {

    static FileLoader index = new FileLoader();
    static String dirPath = index.getIndexPath();
    static IndexReader reader ;

    public static IndexReader getIndexReader(){
        if(reader == null) {
            synchronized (IndexReader.class) {
                if (reader == null) {
                    try {
                        reader = DirectoryReader.open(FSDirectory.open(get(dirPath)));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return reader;
    }
}
