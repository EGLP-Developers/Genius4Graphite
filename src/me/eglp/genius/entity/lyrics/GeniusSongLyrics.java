package me.eglp.genius.entity.lyrics;

import java.util.List;
import java.util.stream.Collectors;

public class GeniusSongLyrics {
	
	private List<GeniusLyricsSection> sections;

	public GeniusSongLyrics(List<GeniusLyricsSection> sections) {
		this.sections = sections;
	}
	
	public List<GeniusLyricsSection> getSections() {
		return sections;
	}
	
	@Override
	public String toString() {
		return sections.stream()
				.map(s -> s.toString())
				.collect(Collectors.joining("\n\n"));
	}

}
