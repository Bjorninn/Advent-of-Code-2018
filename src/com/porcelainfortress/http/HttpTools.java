package com.porcelainfortress.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpTools
{
    public static String Get(URL url)
    {
        String reply = null;

        try
        {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int status = connection.getResponseCode();
            InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = bufferedReader.readLine()) != null)
            {
                content.append(inputLine);
            }

            bufferedReader.close();
            connection.disconnect();

            reply = bufferedReader.toString();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return reply;
    }

    public static String Get(String url)
    {
        String reply = null;

        try
        {
            URL myUrl = new URL(url);
            reply = Get(myUrl);
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }

        return reply;
    }
}
