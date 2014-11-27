package br.com.esign.google.geocode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import br.com.esign.google.geocode.model.GeocodeResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GoogleGeocode {
	
	private String languageCode = System.getProperty("google.geocode.language.code");
	
	private String address;
	private String lat, lng;
	private boolean reverse;
	
	public GoogleGeocode(String address) {
		this.address = address;
	}
	
	public GoogleGeocode(String lat, String lng) {
		this.lat = lat;
		this.lng = lng;
		reverse = true;
	}
	
	public void setLanguage(GoogleGeocodeLanguage language) {
		this.languageCode = language.getCode();
	}
	
	public String getJsonString() throws IOException {
		StringBuilder httpUrl = new StringBuilder("http://maps.googleapis.com/maps/api/geocode/json?sensor=false&");
		if (languageCode != null && !languageCode.isEmpty()) {
			httpUrl.append("language=").append(languageCode).append("&");
		}
		if (reverse) {
			httpUrl.append("latlng=").append(lat).append(",").append(lng);
		} else {
			httpUrl.append("address=").append(URLEncoder.encode(address, "utf-8"));
		}
		
		URL url = new URL(httpUrl.toString());
		URLConnection conn = url.openConnection();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
		StringBuilder out = new StringBuilder();
		String line;
		while ((line = in.readLine()) != null) {
			out.append(line);
		}
		return out.toString();
	}
	
	public GeocodeResponse getResponseObject() throws IOException {
		String json = getJsonString();
		ObjectMapper mapper = new ObjectMapper();
		GeocodeResponse response = mapper.readValue(json, GeocodeResponse.class);
		return response;
	}
	
}