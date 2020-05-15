package me.eglp.genius.entity;

import java.util.List;

import me.mrletsplay.mrcore.json.JSONObject;
import me.mrletsplay.mrcore.json.converter.JSONComplexListType;
import me.mrletsplay.mrcore.json.converter.JSONConstructor;
import me.mrletsplay.mrcore.json.converter.JSONValue;

public class GeniusSong extends GeniusSongResult {
	
	@JSONValue("apple_music_id")
	private String appleMusicID;
	
	@JSONValue("apple_music_player_url")
	private String appleMusicPlayerURL;
	
	private String description;
	
	@JSONValue("embed_content")
	private String embedContent;
	
	@JSONValue("featured_video")
	private boolean featuredVideo;
	
	@JSONValue("lyrics_placeholder_reason")
	private String lyricsPlaceholderReason;
	
	@JSONValue("recording_location")
	private String recordingLocation;
	
	@JSONValue("release_date")
	private String releaseDate;

	@JSONValue("release_date_for_display")
	private String releaseDateForDisplay;
	
	@JSONValue
	private GeniusAlbum album;
	
	// Custom performances
	
//	private GeniusAnnotation descriptionAnnotation;
	
	@JSONValue("featured_artists")
	@JSONComplexListType(GeniusSongArtistInfo.class)
	private List<GeniusSongArtistInfo> featuredArtists;
	
	@JSONValue("media")
	@JSONComplexListType(GeniusMedia.class)
	private List<GeniusMedia> media;
	
	@JSONValue("producer_artists")
	@JSONComplexListType(GeniusSongArtistInfo.class)
	private List<GeniusSongArtistInfo> producerArtists;
	
	// Verified annotations by
	
	// Verified contributors
	
	// Verified lyrics by
	
	private List<GeniusSongArtistInfo> writerArtists;
	
	@JSONConstructor
	private GeniusSong() {}
	
	@Override
	public void preDeserialize(JSONObject object) {
		this.description = object.getJSONObject("description").getString("plain");
	}

	public String getAppleMusicID() {
		return appleMusicID;
	}

	public String getAppleMusicPlayerURL() {
		return appleMusicPlayerURL;
	}

	public String getDescription() {
		return description;
	}

	public String getEmbedContent() {
		return embedContent;
	}

	public boolean isFeaturedVideo() {
		return featuredVideo;
	}

	public String getLyricsPlaceholderReason() {
		return lyricsPlaceholderReason;
	}

	public String getRecordingLocation() {
		return recordingLocation;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public String getReleaseDateForDisplay() {
		return releaseDateForDisplay;
	}

	public GeniusAlbum getAlbum() {
		return album;
	}

	public List<GeniusSongArtistInfo> getFeaturedArtists() {
		return featuredArtists;
	}

	public List<GeniusMedia> getMedia() {
		return media;
	}

	public List<GeniusSongArtistInfo> getProducerArtists() {
		return producerArtists;
	}

	public List<GeniusSongArtistInfo> getWriterArtists() {
		return writerArtists;
	}
	
}
