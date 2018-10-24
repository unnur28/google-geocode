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
package br.com.esign.google.geocode.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class GeocodeResponse {

    private final List<Result> results;
    private final String status;
    private final String error_message;

    @JsonIgnore
    private int index = 0;

    public GeocodeResponse() {
        this(null, null, null);
    }

    public GeocodeResponse(List<Result> results, String status, String error_message) {
        this.results = results;
        this.status = status;
        this.error_message = error_message;
    }

    public List<Result> getResults() {
        return results;
    }

    public String getStatus() {
        return status;
    }

    public String getError_message() {
        return error_message;
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
        return (addressComponent == null) ? null : addressComponent.getLongName();
    }

    @JsonIgnore
    public String getNeighborhoodLongName() {
        return getNeighborhoodLongName(index);
    }

    public String getNeighborhoodLongName(int i) {
        AddressComponent addressComponent = getAddressComponentByType(i, AddressComponentType.NEIGHBORHOOD);
        return (addressComponent == null) ? null : addressComponent.getLongName();
    }

    @JsonIgnore
    public String getLocalityLongName() {
        return getLocalityLongName(index);
    }

    public String getLocalityLongName(int i) {
        AddressComponent addressComponent = getAddressComponentByType(i, AddressComponentType.LOCALITY);
        return (addressComponent == null) ? null : addressComponent.getLongName();
    }

    @JsonIgnore
    public String getAdministrativeAreaLevel2LongName() {
        return getAdministrativeAreaLevel2LongName(index);
    }

    public String getAdministrativeAreaLevel2LongName(int i) {
        AddressComponent addressComponent = getAddressComponentByType(i, AddressComponentType.ADMINISTRATIVE_AREA_LEVEL_2);
        return (addressComponent == null) ? null : addressComponent.getLongName();
    }

    @JsonIgnore
    public String getAdministrativeAreaLevel1LongName() {
        return getAdministrativeAreaLevel1LongName(index);
    }

    public String getAdministrativeAreaLevel1LongName(int i) {
        AddressComponent addressComponent = getAddressComponentByType(i, AddressComponentType.ADMINISTRATIVE_AREA_LEVEL_1);
        return (addressComponent == null) ? null : addressComponent.getLongName();
    }

    @JsonIgnore
    public String getCountryShortName() {
        return getCountryShortName(index);
    }

    public String getCountryShortName(int i) {
        AddressComponent addressComponent = getAddressComponentByType(i, AddressComponentType.COUNTRY);
        return (addressComponent == null) ? null : addressComponent.getShortName();
    }

    @JsonIgnore
    public String getFormattedAddress() {
        return getFormattedAddress(index);
    }

    public String getFormattedAddress(int i) {
        String formattedAddress = null;
        if (isStatusOK()) {
            List<Result> results = getResults();
            if (results != null && -1 < i && i < results.size()) {
                formattedAddress = results.get(i).getFormatted_address();
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
            if (results != null && -1 < i && i < results.size()) {
                geometry = results.get(i).getGeometry();
            }
        }
        return geometry;
    }

    @JsonIgnore
    public boolean isStatusOK() {
        return GeocodeResponseStatus.OK.getValue().equals(getStatus());
    }

}
