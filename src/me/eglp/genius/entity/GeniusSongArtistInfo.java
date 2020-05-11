package me.eglp.genius.entity;

import me.mrletsplay.mrcore.json.converter.JSONConstructor;
import me.mrletsplay.mrcore.json.converter.JSONConvertible;
import me.mrletsplay.mrcore.json.converter.JSONValue;

public class GeniusSongArtistInfo implements JSONConvertible {
	
	@JSONValue("id")
	private int id;
	
	@JSONValue("header_image_url")
	private String headerImageURL;
	
	@JSONValue("image_url")
	private String imageURL;
	
	@JSONValue("is_meme_verified")
	private boolean isMemeVerified;
	
	@JSONValue("is_verified")
	private boolean isVerified;
	
	@JSONValue("name")
	private String name;
	
	@JSONValue("url")
	private String url;

	@JSONConstructor
	private GeniusSongArtistInfo() {}
	
	public int getID() {
		return id;
	}
	
	public String getHeaderImageURL() {
		return headerImageURL;
	}
	
	public String getImageURL() {
		return imageURL;
	}
	
	public boolean isMemeVerified() {
		return isMemeVerified;
	}
	
	public boolean isVerified() {
		return isVerified;
	}
	
	public String getName() {
		return name;
	}
	
	public String getURL() {
		return url;
	}
	
}
