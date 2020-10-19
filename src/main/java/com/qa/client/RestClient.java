package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {

	
    	//1.GET Method
	    public void get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();   //httpClient class variable
		HttpGet httpget = new HttpGet(url);
		CloseableHttpResponse closeableHttpResponse  = httpClient.execute(httpget);   //hit the get url
	
		//2.status code:
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();         //will get status code
		System.out.println("staus code ----?"+ statusCode);                           //staus code print
		
		//3.JSON String
	    String  responseString = EntityUtils.toString( closeableHttpResponse.getEntity(), "UTF-8");
	    
	    JSONObject responseJson = new JSONObject(responseString);
	    System.out.println("Responce Json from API--->"+responseJson);
	    
	    //4.All header:
	    Header[] headerArray = closeableHttpResponse.getAllHeaders();       //collecting all header in headerArray
	    HashMap<String,String> allHeader = new HashMap<String,String>();       //
		for(Header header : headerArray) {
			allHeader.put(header.getName(), header.getValue());
		}
	
}
	
	
}
