package com.pkr.java.rest.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class HttpPostImplementation {

	public static void main(String[] args) throws IOException {
		URL url = new URL("https://reqres.in/api/users");
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Accept", "application/json");
		con.setRequestMethod("POST");
		
		con.setDoOutput(true);
		
		String params = "{\"name\":\"Pradeep\",\"job\":\"java developer\"}";
		OutputStream stream = con.getOutputStream();
		byte[] requestParam = params.getBytes("utf-8");
		stream.write(requestParam);
		
		int code = con.getResponseCode();
		System.out.println(code);
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(con.getInputStream()));
		List<String> response = new ArrayList<>();	
		String res = null;
		while((res = bf.readLine()) != null) {
			response.add(res);
		}
		System.out.println(response);
	}
}