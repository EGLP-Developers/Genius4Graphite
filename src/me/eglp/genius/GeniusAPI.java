package me.eglp.genius;

import java.util.List;
import java.util.stream.Collectors;

import me.eglp.genius.entity.GeniusSearchHit;
import me.eglp.genius.entity.GeniusSong;
import me.eglp.genius.util.GeniusEndpoint;
import me.mrletsplay.mrcore.http.HttpGet;
import me.mrletsplay.mrcore.http.HttpRequest;
import me.mrletsplay.mrcore.json.JSONObject;
import me.mrletsplay.mrcore.json.converter.JSONConverter;

public class GeniusAPI {

	public static final String
		ENDPOINT = "https://api.genius.com/";

	private String clientAccessToken;
	
	public GeniusAPI(String clientAccessToken) {
		this.clientAccessToken = clientAccessToken;
	}
	
	public String getClientAccessToken() {
		return clientAccessToken;
	}
	
	public List<GeniusSearchHit> search(String query) {
		return makeGetRequest(GeniusEndpoint.SEARCH, "q", query).getJSONObject("response").getJSONArray("hits").stream()
				.map(o -> JSONConverter.decodeObject((JSONObject) o, GeniusSearchHit.class))
				.collect(Collectors.toList());
	}
	
	public GeniusSong getSong(long id) {
		return JSONConverter.decodeObject(makeGetRequest(GeniusEndpoint.SONGS.subPath(String.valueOf(id)), "text_format", "plain").getJSONObject("response").getJSONObject("song"), GeniusSong.class);
	}
	
	public synchronized JSONObject makeGetRequest(GeniusEndpoint endpoint, String... queryParams) {
		return makeGetRequest(endpoint.getURL(), queryParams);
	}
	
	public synchronized JSONObject makeGetRequest(String url, String... queryParams) {
		HttpGet r = HttpRequest.createGet(url);
		
		r.setHeaderParameter("Authorization", "Bearer " + clientAccessToken);
		for(int i = 0; i < queryParams.length; i += 2) {
			r.setQueryParameter(queryParams[i], queryParams[i+1]);
		}
		
		return r.execute().asJSONObject();
	}
	
}
