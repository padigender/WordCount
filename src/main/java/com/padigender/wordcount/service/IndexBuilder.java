package com.padigender.wordcount.service;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.util.CharArraySet;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import org.apache.lucene.document.TextField;


import java.io.*;
import java.nio.file.Paths;


public class IndexBuilder
{
	public static void buildIndex() throws IOException {

		FileLoader fileLoader = new FileLoader();
		CharArraySet stopdwords = new CharArraySet(1,true);
		IndexWriterConfig iwc = new IndexWriterConfig(new StandardAnalyzer(stopdwords));
		iwc.setOpenMode(OpenMode.CREATE);  /* (OpenMode.CREATE_OR_APPEND) for existing index */

		Directory dir = FSDirectory.open(Paths.get(fileLoader.getIndexPath()));

		IndexWriter writer = new IndexWriter(dir, iwc);
		InputStream[] files = fileLoader.loadFiles();
		for(InputStream file: files){

			BufferedReader b_reader = new BufferedReader(new InputStreamReader(file));
			String line;
			while ((line = b_reader.readLine()) != null) {
				Document doc = new Document();
				line = Util.simpleNormalize(line);
				doc.add(new TextField("word",line, Field.Store.YES));
				writer.addDocument(doc);
			}
		}
		writer.close();
	}
}