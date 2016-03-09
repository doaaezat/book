package com.example.dododo.book_store;

import android.content.Entity;
import android.net.http.AndroidHttpClient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by DoDo DO on 24/12/2015.
 */
public class httpmanager {
    public static String getdatafromurl(String url){

        HttpClient httpClient = new DefaultHttpClient();
        HttpContext localContext = new BasicHttpContext();
        HttpGet request = new HttpGet(url);


        try {
            HttpResponse response = httpClient.execute(request,
                    localContext);
            HttpEntity entity = response.getEntity();

            return EntityUtils.toString(entity);
        } catch (IOException e) {
            e.printStackTrace();
            return null ;
        }

        }
    }

