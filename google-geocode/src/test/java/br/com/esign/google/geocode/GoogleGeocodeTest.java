package br.com.esign.google.geocode;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import br.com.esign.google.geocode.model.AddressComponentType;
import br.com.esign.google.geocode.model.GeocodeResponse;

public class GoogleGeocodeTest {
	
	private final static String apiKey = System.getProperty("google.geocode.api.key");

	@Test
	public void testGetResponseObject1() throws IOException {
		GoogleGeocode googleGeocode = new GoogleGeocode(apiKey, "-23.544969", "-46.641846");
		GeocodeResponse geocodeResponse = googleGeocode.getResponseObject();
		assertNotNull(geocodeResponse);
		assertTrue(geocodeResponse.isStatusOK());
	}

	@Test
	public void testGetResponseObject2() throws IOException {
		GoogleGeocode googleGeocode = new GoogleGeocode(apiKey, "R. 7 de Abril, 346 - Centro, São Paulo - SP, 01044-000, Brazil");
		googleGeocode.setLanguage(GoogleGeocodeLanguage.PORTUGUESE_BRAZIL);
		GeocodeResponse geocodeResponse = googleGeocode.getResponseObject();
		assertNotNull(geocodeResponse);
		assertTrue(geocodeResponse.isStatusOK());
		assertEquals("346", geocodeResponse.getAddressComponentByType(AddressComponentType.STREET_NUMBER).getShortName());
	}
	
}