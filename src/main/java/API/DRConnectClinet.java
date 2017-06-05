package API;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import RespnseParser.ParseResponse;


public class DRConnectClinet {

	private final String USER_AGENT = "Mozilla/5.0";

	
	// HTTP GET request
		public String sendGet() throws Exception {

	        System.out.println("##########################################in sendGet################################");
			String url = "http://api-cte-ext.digitalriver.com/v1/shoppers/me/products?apiKey=86099f88dfbe4f0986419cdac707cb0f";

			//String url="https://api-cte-ext.digitalriver.com/v1/shoppers/me/carts/active/line-items?apiKey=86099f88dfbe4f0986419cdac707cb0f&token=81973f539f3b665238072b63813847b2f8afa4a195a19831bd1e19b9d8464579609cd0a7440d59c21200e55bea502d6e0f22f81a5a74aa52b62281ea35f109b74ee918255551650b5cf5aa25b171edaa";
			
			
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
           System.out.println("################connection created="+con);
			// optional default is GET
			con.setRequestMethod("GET");
			System.out.println("################connection GET method set#######");
			//add request header
			con.setRequestProperty("User-Agent", USER_AGENT);

			int responseCode = con.getResponseCode();
			System.out.println("################connection responseCode="+responseCode);
			System.out.println("\nSending 'GET' request to URL : " + url);


			ParseResponse parse=new ParseResponse();
			
			return parse.getProductList(con.getInputStream());

		}

		// HTTP POST request
		public String sendPost() throws Exception {

			String url = "http://api-cte-ext.digitalriver.com/v1/shoppers/me/carts/active/line-items?productId=5073603100&apiKey=86099f88dfbe4f0986419cdac707cb0f&token=81973f539f3b665238072b63813847b2f8afa4a195a19831bd1e19b9d8464579609cd0a7440d59c21200e55bea502d6e0f22f81a5a74aa52b62281ea35f109b74ee918255551650b5cf5aa25b171edaa";
					
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			//add reuqest header
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", USER_AGENT);
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            con.setRequestProperty("apiKey", "86099f88dfbe4f0986419cdac707cb0f");
			String urlParameters = "apiKey=86099f88dfbe4f0986419cdac707cb0f";

			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			ParseResponse parse=new ParseResponse();
			
			return parse.getProductList(con.getInputStream());


		}
	
	
}
