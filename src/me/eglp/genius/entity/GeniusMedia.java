package me.eglp.genius.entity;

import me.mrletsplay.mrcore.json.converter.JSONConstructor;
import me.mrletsplay.mrcore.json.converter.JSONConvertible;
import me.mrletsplay.mrcore.json.converter.JSONValue;

public class GeniusMedia implements JSONConvertible {

	@JSONValue
	private String provider;
	
	@JSONValue
	private String type;
	
	@JSONValue("native_uri")
	private String nativeURI;
	
	@JSONValue
	private String url;
	
	@JSONConstructor
	private GeniusMedia() {}

	public String getProvider() {
		return provider;
	}

	public String getType() {
		return type;
	}

	public String getNativeURI() {
		return nativeURI;
	}

	public String getURL() {
		return url;
	}
	
}
