/* 
 * The MIT License
 *
 * Copyright 2016 Esign Consulting.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
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
	private String lat;
	private String lng;
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
		return mapper.readValue(json, GeocodeResponse.class);
	}
	
}