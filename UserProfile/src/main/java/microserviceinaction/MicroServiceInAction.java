package microserviceinaction;

import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MicroServiceInAction {
	  static URL url;
	   static HttpURLConnection conn;
	   static String output;
	   static String inputToOtherService;
	   static String countryCode;
	   static String ipAddress;
	   static String CountryName;
	   public static void main(String[] args) {

	try 
	{
        url = new URL("http://localhost:8080/UserProfile/webapi/Profile/");
        conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/xml");
        
        if (conn.getResponseCode() != 200) {
           throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }
        
        BufferedReader br = new BufferedReader(new InputStreamReader(
           (conn.getInputStream())));
        while ((output = br.readLine()) != null) {
           inputToOtherService = output;
        }
        conn.disconnect();
     
     } catch (MalformedURLException e) {
        e.printStackTrace();
     } catch (IOException e) {
        e.printStackTrace();
     }
	 System.out.println(inputToOtherService);
	
	 try
	 {
				url = new URL("http://localhost:8080/UserProfile/webapi/Profile");
				conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("POST");
				conn.setDoOutput(true);
				conn.setRequestProperty("content-type", "application/xml");
				OutputStream os = conn.getOutputStream();
				byte[] input = "<userProfile><add>Test</add><FName>test</FName><LName>test</LName></userProfile>".getBytes("utf-8");
				os.write(input,0,input.length);
				os.flush();
				os.close();
				;
				int responseCode = conn.getResponseCode();
				System.out.println("POST Response Code :: " + responseCode);

				if (responseCode == HttpURLConnection.HTTP_OK) { 

					BufferedReader in = new BufferedReader(new InputStreamReader(
							conn.getInputStream()));
					String inputLine;
					StringBuffer response = new StringBuffer();

					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
					in.close();

					// print result
					System.out.println(response.toString());
				} else {
					System.out.println("POST request not worked");
				}
	 }
			
				 catch (MalformedURLException e) {
				        e.printStackTrace();
				     } catch (IOException e) {
				        e.printStackTrace();
				     }
	 
	 
}
}
