package me.eglp.genius.entity;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import me.eglp.genius.entity.lyrics.GeniusLyricsSection;
import me.eglp.genius.entity.lyrics.GeniusSongLyrics;
import me.mrletsplay.mrcore.http.HttpRequest;
import me.mrletsplay.mrcore.http.HttpResult;
import me.mrletsplay.mrcore.json.converter.JSONConstructor;
import me.mrletsplay.mrcore.json.converter.JSONConvertible;
import me.mrletsplay.mrcore.json.converter.JSONValue;

public class GeniusSongResult implements JSONConvertible {
	
	@JSONValue("annotation_count")
	private Long annotationCount;
	
	@JSONValue("full_title")
	private String fullTitle;
	
	@JSONValue("header_image_thumbnail_url")
	private String headerImageThumbnailURL;
	
	@JSONValue("header_image_url")
	private String headerImageURL;
	
	@JSONValue("id")
	private long id;
	
	@JSONValue("lyrics_owner_id")
	private long lyricsOwnerID;
	
	@JSONValue("lyrics_state")
	private String lyricsState;
	
	@JSONValue("pyongs_count")
	private Long pyongsCount;
	
	@JSONValue("song_art_image_thumbnail_url")
	private String songArtImageThumbnailURL;
	
	@JSONValue("song_art_image_url")
	private String songArtImageURL;
	
	@JSONValue("stats")
	private GeniusSongStats stats;

	@JSONValue("title")
	private String title;
	
	@JSONValue("title_with_featured")
	private String titleWithFeatured;
	
	@JSONValue("url")
	private String url;
	
	@JSONValue("primary_artist")
	private GeniusSongArtistInfo primaryArtist;
	
	@JSONConstructor
	protected GeniusSongResult() {}

	public Long getAnnotationCount() {
		return annotationCount;
	}

	public String getFullTitle() {
		return fullTitle;
	}

	public String getHeaderImageThumbnailURL() {
		return headerImageThumbnailURL;
	}

	public String getHeaderImageURL() {
		return headerImageURL;
	}

	public long getID() {
		return id;
	}

	public long getLyricsOwnerID() {
		return lyricsOwnerID;
	}

	public String getLyricsState() {
		return lyricsState;
	}

	public Long getPyongsCount() {
		return pyongsCount;
	}

	public String getSongArtImageThumbnailURL() {
		return songArtImageThumbnailURL;
	}

	public String getSongArtImageURL() {
		return songArtImageURL;
	}

	public GeniusSongStats getStats() {
		return stats;
	}

	public String getTitle() {
		return title;
	}

	public String getTitleWithFeatured() {
		return titleWithFeatured;
	}

	public String getURL() {
		return url;
	}

	public GeniusSongArtistInfo getPrimaryArtist() {
		return primaryArtist;
	}
	
	public GeniusSongLyrics retrieveLyrics() {
		HttpResult r = HttpRequest.createGet(url)
				.setHeaderParameter("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36")
				.execute();
		
		Document d = Jsoup.parse(r.asString());
		Element lyricsElement;
		Elements lEls = d.getElementsByClass("lyrics");
		
		if(lEls.isEmpty()) { // Because that happens sometimes for some reason
			lyricsElement = d.getElementsByTag("div").stream()
					.filter(div -> div.classNames().stream().anyMatch(c -> c.startsWith("Lyrics__Container")))
					.findFirst().orElse(null);
		}else {
			lyricsElement = d.getElementsByClass("lyrics").get(0).child(0);
		}
		
		List<GeniusLyricsSection> sc = new ArrayList<>();
		String title = null;
		StringBuilder lyrics = new StringBuilder();
		
		append(lyrics, lyricsElement);
		
		StringBuilder sec = new StringBuilder();
		for(String line : lyrics.toString().split("\n", -1)) {
			if(line.startsWith("[")) {
				if(title != null) sc.add(new GeniusLyricsSection(title, sec.toString().trim()));
				title = line.trim();
				sec = new StringBuilder();
			}else {
				sec.append(line).append('\n');
			}
		}
		
		if(title != null || sec.length() > 0) sc.add(new GeniusLyricsSection(title == null ? "Lyrics" : title, sec.toString().trim()));
		
		return new GeniusSongLyrics(sc);
	}
	
	private static void append(StringBuilder builder, Node n) {
		if(n instanceof TextNode) {
			builder.append(((TextNode) n).text()
					.replaceAll("^( |\\t)++", "")
					.replaceAll("^( |\\t)++$", ""));
		}
		
		if(n instanceof Element) {
			Element e = (Element) n;
			if(e.tag().normalName().equals("br")) {
				builder.append('\n');
			}else {
				for(Node c : n.childNodes()) {
					append(builder, c);
				}
			}
		}
	}
	
}
