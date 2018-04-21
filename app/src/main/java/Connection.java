package com.example.lucas.myapplication;

import android.os.StrictMode;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class Connection {
    private final String USER_AGENT = "Mozilla/5.0";

    // HTTP GET request
    public List<Filme> sendGet() throws Exception {

        String url = "https://api.myjson.com/bins/h5ar7";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        List<Filme> found = findAllItems(new JSONArray(response.toString()));

        return found;
    }

    public List<Filme> findAllItems(JSONArray response) {

        List<Filme> found = new LinkedList<Filme>();

        try {

            for (int i = 0; i < response.length(); i++) {
                JSONObject obj = response.getJSONObject(i);
                found.add(new Filme(obj.getString("filme"), obj.getString("url"),obj.getString("nota"),obj.getString("location")));
            }

        } catch (JSONException e) {
            // handle exception
        }

        return found;
    }
}
