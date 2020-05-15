package me.eglp.genius.entity;

import me.mrletsplay.mrcore.json.converter.JSONConstructor;
import me.mrletsplay.mrcore.json.converter.JSONConvertible;
import me.mrletsplay.mrcore.json.converter.JSONValue;

public class GeniusAlbum implements JSONConvertible {
	
	@JSONValue("cover_art_url")
	private String coverArtURL;
	
	@JSONValue("full_title")
	private String fullTitle;
	
	@JSONValue
	private long id;
	
	@JSONValue
	private String name;
	
	@JSONValue
	private String url;

	@JSONConstructor
	private GeniusAlbum() {}

	public String getCoverArtURL() {
		return coverArtURL;
	}

	public String getFullTitle() {
		return fullTitle;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getURL() {
		return url;
	}
	
}
