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

import com.fasterxml.jackson.annotation.JsonProperty;

public class Geometry {

    private final Bounds bounds;
    private final Location location;
    @JsonProperty("location_type")
    private final String locationType;
    private final Bounds viewport;

    public Geometry() {
        this(null, null, null, null);
    }

    public Geometry(Bounds bounds, Location location, String locationType, Bounds viewport) {
        this.bounds = bounds;
        this.location = location;
        this.locationType = locationType;
        this.viewport = viewport;
    }

    public Bounds getBounds() {
        return bounds;
    }

    public Location getLocation() {
        return location;
    }

    public String getLocationType() {
        return locationType;
    }

    public Bounds getViewport() {
        return viewport;
    }

}
