package me.eglp.genius4graphite.util;

import me.eglp.genius4graphite.GeniusAPI;

public enum GeniusEndpoint {
	
	SEARCH(GeniusAPI.ENDPOINT + "search"),
	SONGS(GeniusAPI.ENDPOINT + "songs"),
	;
	
	public final String url;
	
	private GeniusEndpoint(String url) {
		this.url = url;
	}
	
	public String getURL() {
		return url;
	}
	
	public String subPath(String path) {
		return url + "/" + path;
	}
	
}
