package me.eglp.genius4graphite;

import java.util.List;
import java.util.stream.Collectors;

import me.eglp.genius4graphite.entity.GeniusSearchHit;
import me.eglp.genius4graphite.util.GeniusEndpoint;
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
	
	public JSONObject getSong(long id) {
		return makeGetRequest(GeniusEndpoint.SONGS.subPath(String.valueOf(id)));
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
