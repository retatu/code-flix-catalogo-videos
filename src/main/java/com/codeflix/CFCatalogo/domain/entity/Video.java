package com.codeflix.CFCatalogo.domain.entity;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import com.codeflix.CFCatalogo.domain.entity.BaseEntity;

public class Video extends BaseEntity {

	private String title;
	private String description;
	private Integer yearLaunched;
	private Boolean opened;
	private String rating;
	private Float duration;

	public Video(){}

	public Video(UUID id, String title, String description, Integer yearLaunched, Boolean openend){
		super.setId(id);
		this.setTitle(title);
		this.setDescription(description);
		this.setYearLaunched(yearLaunched);
		this.setOpened(opened);
	}
	
	public Video(String title, String description, Integer yearLaunched, Boolean openend){
		super.generateUUID();
		this.setTitle(title);
		this.setDescription(description);
		this.setYearLaunched(yearLaunched);
		this.setOpened(opened);
	}

	public Video(String title, String description, Integer yearLaunched, Boolean openend, String rating, Float duration){
		super.generateUUID();
		this.setTitle(title);
		this.setDescription(description);
		this.setYearLaunched(yearLaunched);
		this.setOpened(opened);
		this.setRating(rating);
		this.setDuration(duration);
	}

	public Video(String title, String description, Integer yearLaunched, Float duration){
		super.generateUUID();
		this.setTitle(title);
		this.setDescription(description);
		this.setYearLaunched(yearLaunched);
		this.setDuration(duration);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if(title == null) throw new IllegalArgumentException("title is marked as non-null but got null");
		if(title.isEmpty()) throw new IllegalArgumentException("title is marked as non-blank but got blank");
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getYearLaunched() {
		return yearLaunched;
	}

	public void setYearLaunched(Integer yearLaunched) {
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		if (yearLaunched > currentYear) throw new IllegalArgumentException("yearLauncher is greater than currentYear");
		this.yearLaunched = yearLaunched;
	}

	public Boolean getOpened() {
		return opened;
	}

	public void setOpened(Boolean opened) {
		this.opened = opened;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getRating() {
		return rating;
	}

	public void setDuration(Float duration) {
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		this.duration = Float.valueOf(decimalFormat.format(duration));
	}

	public Float getDuration() {
		return duration;
	}
}
