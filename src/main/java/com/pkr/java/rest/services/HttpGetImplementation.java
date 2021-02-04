package com.pkr.java.rest.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HttpGetImplementation {

	public static void main(String[] args) throws IOException{
		URL url = new URL("http://localhost:8080/greeting");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Accept", "application/json");

		conn.setRequestMethod("GET");

		int code = conn.getResponseCode();
		System.out.println(code);

		BufferedReader bf = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		List<String> response = new ArrayList<>();	
		String res = null;
		while((res = bf.readLine()) != null) {
			response.add(res);
		}
		System.out.println(response);
	}

}
