package com.padigender.wordcount.service;

import javax.ws.rs.*;

/**
 * Created by ragudipati on 11/30/15.
 */
@Path("/index")
public class WordCountService {
    @GET
    @Path("/word-count")
    @Produces("text/plain")
    @Consumes("text/plain")
    public String getWordCount(@QueryParam("search") String word) {
        if(word ==null || word.isEmpty()){
            return "0"+","+"0";
        }
        return WordCountImpl.getWordCount(word);
    }
}
