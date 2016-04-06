package com.padigender.wordcount.service;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;

/**
 * Created by pkyasaram on 4/4/16.
 */
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import javax.ws.rs.core.Context;


public class FileLoader extends ResourceConfig {
    @Context ServletContext servletContext;
    public InputStream[] loadFiles() {

        File folder;
        URL url = getClassLoader().getResource("txtfiles");
        folder = new File(url.getFile());
        String[] files = folder.list();
        InputStream[] inputList = new InputStream[files.length];
        for(int i =0; i < files.length; i++){
            InputStream is = getClassLoader().getResourceAsStream("txtfiles/" + files[i]);
            files[i] = url  + files[i];

            inputList[i] = is;
        }

        return inputList;
    }
    public String getIndexPath() {

        URL url2 = getClassLoader().getResource("txtfiles");
        URL url = getClassLoader().getResource("index");
        return url.getFile();
    }

}
