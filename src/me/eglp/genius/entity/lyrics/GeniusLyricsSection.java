package me.eglp.genius.entity.lyrics;

public class GeniusLyricsSection {
	
	private String
		title,
		text;
	
	public GeniusLyricsSection(String title, String text) {
		this.title = title;
		this.text = text;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getText() {
		return text;
	}
	
	@Override
	public String toString() {
		return title + "\n" + text;
	}
	
}
