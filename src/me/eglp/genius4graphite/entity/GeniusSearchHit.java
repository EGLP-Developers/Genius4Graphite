package me.eglp.genius4graphite.entity;

import me.mrletsplay.mrcore.json.converter.JSONConstructor;
import me.mrletsplay.mrcore.json.converter.JSONConvertible;
import me.mrletsplay.mrcore.json.converter.JSONValue;

public class GeniusSearchHit implements JSONConvertible {

	@JSONValue
	private GeniusSongResult result;
	
	@JSONConstructor
	private GeniusSearchHit() {}
	
	public GeniusSongResult getResult() {
		return result;
	}
	
}
