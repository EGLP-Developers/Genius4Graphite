package me.eglp.genius.entity;

import me.mrletsplay.mrcore.json.converter.JSONConstructor;
import me.mrletsplay.mrcore.json.converter.JSONConvertible;
import me.mrletsplay.mrcore.json.converter.JSONValue;

public class GeniusSongStats implements JSONConvertible {
	
	@JSONValue("accepted_annotations")
	private Long acceptedAnnotations;
	
	@JSONValue("contributors")
	private Long contributors;
	
	@JSONValue("iq_earners")
	private Long iqEarners;
	
	@JSONValue("transcribers")
	private Long transcribers;
	
	@JSONValue("unreviewed_annotations")
	private Long unreviewedAnnotations;
	
	@JSONValue("verified_annotations")
	private Long verifiedAnnotations;
	
	@JSONValue("hot")
	private boolean hot;
	
	@JSONValue("pageviews")
	private Long pageviews;
	
	@JSONConstructor
	private GeniusSongStats() {}

	public Long getAcceptedAnnotations() {
		return acceptedAnnotations;
	}

	public Long getContributors() {
		return contributors;
	}

	public Long getIqEarners() {
		return iqEarners;
	}

	public Long getTranscribers() {
		return transcribers;
	}

	public Long getUnreviewedAnnotations() {
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
