package br.com.esign.google.geocode;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

import br.com.esign.google.geocode.model.GeocodeResponse;

public class GoogleGeocodeTest {
	
	@Test
	public void testGetResponseObject() throws IOException {
		GoogleGeocode googleGeocode = new GoogleGeocode("-23.544969", "-46.641846");
		GeocodeResponse geocodeResponse = googleGeocode.getResponseObject();
		assertNotNull(geocodeResponse);
		assertNotNull(geocodeResponse.getStatus());
	}
	
}