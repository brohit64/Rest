package com.tutorialspoint;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class Client {
	  static URL url;
	  static URL url2;
	   static HttpURLConnection conn;
	   static HttpURLConnection conn2;
	   static String output;
	   static String inputToOtherService;
	   static String inputToOtherService1;
	   static String countryCode;
	   static String ipAddress;
	   static String CountryName;
	   public static void main(String[] args) {

	try 
	{
        url = new URL("http://localhost:8080/UserManagement/rest/UserService/users");
        url2 = new URL("http://localhost:8080/UserManagement/rest/UserService2/users");
        conn = (HttpURLConnection) url.openConnection();
        conn2 = (HttpURLConnection) url2.openConnection();
        conn.setRequestMethod("GET");
        conn2.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        conn2.setRequestProperty("Accept", "application/json");
        
        if (conn.getResponseCode() != 200 || conn2.getResponseCode() != 200) {
           throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }
        
        BufferedReader br = new BufferedReader(new InputStreamReader(
           (conn.getInputStream())));
        while ((output = br.readLine()) != null) {
           inputToOtherService = output;
        }
        conn.disconnect();
        
        br = new BufferedReader(new InputStreamReader(
                (conn2.getInputStream())));
             while ((output = br.readLine()) != null) {
                inputToOtherService1 = output;
             }
             conn.disconnect();

     
     } catch (MalformedURLException e) {
        e.printStackTrace();
     } catch (IOException e) {
        e.printStackTrace();
     }
	 System.out.println(inputToOtherService);
	 System.out.println(inputToOtherService1);
	

}
}
