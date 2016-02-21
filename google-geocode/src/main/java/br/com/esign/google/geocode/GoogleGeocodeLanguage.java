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

public enum GoogleGeocodeLanguage {
	
	ARABIC("ar"),
	BASQUE("eu"),
	BULGARIAN("bg"),
	BENGALI("bn"),
	CATALAN("ca"),
	CZECH("cs"),
	DANISH("da"),
	GERMAN("de"),
	GREEK("el"),
	ENGLISH("en"),
	ENGLISH_AUSTRALIAN("en-AU"),
	ENGLISH_GREAT_BRITAIN("en-GB"),
	SPANISH("es"),
	FARSI("fa"),
	FINNISH("fi"),
	FILIPINO("fil"),
	FRENCH("fr"),
	GALICIAN("gl"),
	GUJARATI("gu"),
	HINDI("hi"),
	CROATIAN("hr"),
	HUNGARIAN("hu"),
	INDONESIAN("id"),
	ITALIAN("it"),
	HEBREW("iw"),
	JAPANESE("ja"),
	KANNADA("kn"),
	KOREAN("ko"),
	LITHUANIAN("lt"),
	LATVIAN("lv"),
	MALAYALAM("ml"),
	MARATHI("mr"),
	DUTCH("nl"),
	NORWEGIAN_NYNORSK("nn"),
	NORWEGIAN("no"),
	ORIYA("or"),
	POLISH("pl"),
	PORTUGUESE("pt"),
	PORTUGUESE_BRAZIL("pt-BR"),
	PORTUGUESE_PORTUGAL("pt-PT"),
	ROMANSCH("rm"),
	ROMANIAN("ro"),
	RUSSIAN("ru"),
	SLOVAK("sk"),
	SLOVENIAN("sl"),
	SERBIAN("sr"),
	SWEDISH("sv"),
	TAGALOG("tl"),
	TAMIL("ta"),
	TELUGU("te"),
	THAI("th"),
	TURKISH("tr"),
	UKRAINIAN("uk"),
	VIETNAMESE("vi"),
	CHINESE_SIMPLIFIED("zh-CN"),
	CHINESE_TRADITIONAL("zh-TW");
	
	private final String code;
	
	private GoogleGeocodeLanguage(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}
	
}