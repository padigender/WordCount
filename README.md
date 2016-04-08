# WordCount


WordCount is a REST service to search for a word in the data set and return the frequency of that word. </br>

Request GET : http://localhost:8080/word_count/api/index/word-count?search=what </br>
search is the query param to search for a specific word </br>
Response : 10357,1 </br>
frequency of the word in whole data set, numbers of requests with this word as query param </br>


Implementation: </br>
</br>
1. It is REST service implemented using JAX-RS. </br>
2. It can be deployed on a Tomcat server using the generated .war file. </br>
3. Maven plugin for deploying the war to Tomcat is also included. </br>
4. During the post deploy step a Lucene Index is genearted for the words in the given dataset. </br>
5. There is only one GET end point which will call the internal search on Lucene Index to get the Frequenct of a word. </br>
6. And a ConcurrentHashMap is used to store the number of requests with each query word. </br>
 </br>
Tests: </br>
  </br>
Test file WordCountServiceTest.java is included to test basic Index building and searching on the Data set. </br>
