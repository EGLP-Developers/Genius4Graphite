package me.eglp.genius.entity;

import me.mrletsplay.mrcore.json.converter.JSONConstructor;
import me.mrletsplay.mrcore.json.converter.JSONConvertible;
import me.mrletsplay.mrcore.json.converter.JSONValue;

public class GeniusSongStats implements JSONConvertible {
	
	@JSONValue("accepted_annotations")
	private long acceptedAnnotations;
	
	@JSONValue("contributors")
	private long contributors;
	
	@JSONValue("iq_earners")
	private long iqEarners;
	
	@JSONValue("transcribers")
	private long transcribers;
	
	@JSONValue("unreviewed_annotations")
	private long unreviewedAnnotations;
	
	@JSONValue("verified_annotations")
	private long verifiedAnnotations;
	
	@JSONValue("hot")
	private boolean hot;
	
	@JSONValue("pageviews")
	private long pageviews;
	
	@JSONConstructor
	private GeniusSongStats() {}

	public long getAcceptedAnnotations() {
		return acceptedAnnotations;
	}

	public long getContributors() {
		return contributors;
	}

	public long getIqEarners() {
		return iqEarners;
	}

	public long getTranscribers() {
		return transcribers;
	}

	public long getUnreviewedAnnotations() {
		return unreviewedAnnotations;
	}

	public long getVerifiedAnnotations() {
		return verifiedAnnotations;
	}

	public boolean isHot() {
		return hot;
	}

	public long getPageviews() {
		return pageviews;
	}
	
}
