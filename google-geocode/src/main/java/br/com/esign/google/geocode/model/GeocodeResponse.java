package br.com.esign.google.geocode.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class GeocodeResponse {
	
	private List<Result> results;
	private String status;
	private String error_message;
	
	@JsonIgnore
	private int index = 0;
	
	public List<Result> getResults() {
		return results;
	}
	public void setResults(List<Result> results) {
		this.results = results;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getError_message() {
		return error_message;
	}
	public void setError_message(String error_message) {
		this.error_message = error_message;
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	public AddressComponent getAddressComponentByType(AddressComponentType t) {
		return getAddressComponentByType(index, t);
	}
	
	public AddressComponent getAddressComponentByType(int i, AddressComponentType t) {
		if (isStatusOK()) {
			List<Result> results = getResults();
			if (results != null && -1 < i && i < results.size()) {
				for (AddressComponent addressComponent : results.get(i).getAddress_components()) {
					for (String type : addressComponent.getTypes()) {
						if (type.equals(t.getValue())) {
							return addressComponent;
						}
					}
				}
			}
		}
		return null;
	}
	
	@JsonIgnore
	public String getSublocalityLongName() {
		return getSublocalityLongName(index);
	}
	
	public String getSublocalityLongName(int i) {
		AddressComponent addressComponent = getAddressComponentByType(i, AddressComponentType.SUBLOCALITY);
		return (addressComponent == null) ? null : addressComponent.getLong_name();
	}
	
	@JsonIgnore
	public String getNeighborhoodLongName() {
		return getNeighborhoodLongName(index);
	}
	
	public String getNeighborhoodLongName(int i) {
		AddressComponent addressComponent = getAddressComponentByType(i, AddressComponentType.NEIGHBORHOOD);
		return (addressComponent == null) ? null : addressComponent.getLong_name();
	}
	
	@JsonIgnore
	public String getLocalityLongName() {
		return getLocalityLongName(index);
	}
	
	public String getLocalityLongName(int i) {
		AddressComponent addressComponent = getAddressComponentByType(i, AddressComponentType.LOCALITY);
		return (addressComponent == null) ? null : addressComponent.getLong_name();
	}
	
	@JsonIgnore
	public String getAdministrativeAreaLevel2LongName() {
		return getAdministrativeAreaLevel2LongName(index);
	}
	
	public String getAdministrativeAreaLevel2LongName(int i) {
		AddressComponent addressComponent = getAddressComponentByType(i, AddressComponentType.ADMINISTRATIVE_AREA_LEVEL_2);
		return (addressComponent == null) ? null : addressComponent.getLong_name();
	}
	
	@JsonIgnore
	public String getAdministrativeAreaLevel1LongName() {
		return getAdministrativeAreaLevel1LongName(index);
	}
	
	public String getAdministrativeAreaLevel1LongName(int i) {
		AddressComponent addressComponent = getAddressComponentByType(i, AddressComponentType.ADMINISTRATIVE_AREA_LEVEL_1);
		return (addressComponent == null) ? null : addressComponent.getLong_name();
	}
	
	@JsonIgnore
	public String getCountryShortName() {
		return getCountryShortName(index);
	}
	
	public String getCountryShortName(int i) {
		AddressComponent addressComponent = getAddressComponentByType(i, AddressComponentType.COUNTRY);
		return (addressComponent == null) ? null : addressComponent.getShort_name();
	}
	
	@JsonIgnore
	public String getFormattedAddress() {
		return getFormattedAddress(index);
	}
	
	public String getFormattedAddress(int i) {
		String formattedAddress = null;
		if (isStatusOK()) {
			List<Result> results = getResults();
			if (results != null && !results.isEmpty()) {
				formattedAddress = getResults().get(i).getFormatted_address();
			}
		}
		return formattedAddress;
	}
	
	@JsonIgnore
	public Geometry getGeometry() {
		return getGeometry(index);
	}
	
	public Geometry getGeometry(int i) {
		Geometry geometry = null;
		if (isStatusOK()) {
			List<Result> results = getResults();
			if (results != null && !results.isEmpty()) {
				geometry = getResults().get(i).getGeometry();
			}
		}
		return geometry;
	}
	
	@JsonIgnore
	public boolean isStatusOK() {
		return GeocodeResponseStatus.OK.getValue().equals(getStatus());
	}
	
}