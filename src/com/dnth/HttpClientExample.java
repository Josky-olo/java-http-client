package com.dnth;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HttpClientExample {

    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            String result = sendPOST("https://script.google.com/macros/s/AKfycbwyQcFrhOI7WZ7ldfh4YoJi0ezpMGkxMP7ThTEb80g8HDcb92_GvWi_miMnI8CAN_6q/exec");
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String sendPOST(String url) throws IOException {

        String result = "";
        HttpPost post = new HttpPost(url);

        // add request parameters or form parameters
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("username", "abc"));
        urlParameters.add(new BasicNameValuePair("password", "123"));
        urlParameters.add(new BasicNameValuePair("Josky", "olo"));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)){

            result = EntityUtils.toString(response.getEntity());
        }

        return result;
    }
}
