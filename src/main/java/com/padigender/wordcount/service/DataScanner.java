package com.padigender.wordcount.service;

import org.apache.lucene.index.IndexReader;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import org.apache.lucene.index.DirectoryReader;
import static java.nio.file.Paths.get;
import org.apache.lucene.index.Term;

public class DataScanner {
	// configuration

	public static String searchWord(String word) {
		// Use Indexes from existing folder
		FileLoader index = new FileLoader();
		String dirPath = index.getIndexPath();
		IndexReader reader = SingletonIndexReader.getIndexReader();
		long termFreq = 0;
		if(reader != null) {
			try {
				word = word.toLowerCase();
				word = word.trim();
				Term termInstance = new Term("word", word);
				termFreq = reader.totalTermFreq(termInstance);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return String.valueOf(termFreq);
	}
}