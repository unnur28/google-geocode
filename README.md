# google-geocode

Java library for Google Geocoding API.

## Code examples:

```java
GoogleGeocode googleGeocode = new GoogleGeocode(address); // the address must not be encoded<br>
String jsonString = googleGeocode.getJsonString(); // throws IOException
```

Alternatively, an object representing the Google Geocoding API json response can be get:

```java
GoogleGeocode googleGeocode = new GoogleGeocode(latitude, longitude); // reverse geocoding<br>
GeocodeResponse geocodeResponse = googleGeocode.getResponseObject(); // throws IOException
```

This object is usefull to get the response content:

```java
if (googleResponse.isStatusOK()) {<br>
   String country = getCountryShortName(); // returns the country short name of the first result<br>
   // more code<br>
}
```

Any result in the list of results can be accessed through two ways:

```java
// returns the formatted address of the third result<br>
// or null if the index is out of bounds<br>
geocodeResponse.setIndex(2);<br>
String formattedAddress = geocodeResponse.getFormattedAddress();
```

Or

```java
// returns the geometry object of the position in the results list defined by the index parameter<br>
// or null if it is out of bounds<br>
Geometry geometry = geocodeResponse.getGeometry(index);
```

The Google Geocoding API language parameter can also be defined:

```java
GoogleGeocode googleGeocode = new GoogleGeocode(address);<br>
googleGeocode.setLanguage(GoogleGeocodeLanguage.PORTUGUESE_BRAZIL);
```

Enjoy! :simple_smile:
