package com.padigender.wordcount.service;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.ws.rs.core.Application;


public class WebApplication extends Application {

    /**
     * Starts a server, initializes and keeps the server alive
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Jersey app started\nHit enter to stop it...");
        System.out.println("Server stopped successfully.");
    }

    /**
     * Default constructor
     */
    public WebApplication() {
        super();
    }

    /**
     * Initialize the web application
     */
    @PostConstruct
    public static void initialize() {
        System.out.print("PostConstruct......");
        try {
            IndexBuilder.buildIndex();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
