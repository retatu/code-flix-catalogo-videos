package com.codeflix.CFCatalogo.domain.entity;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import com.codeflix.CFCatalogo.domain.entity.BaseEntity;
import com.codeflix.CFCatalogo.domain.entity.Category;
import com.codeflix.CFCatalogo.domain.entity.Genre;
import com.codeflix.CFCatalogo.domain.entity.CastMember;

public class Video extends BaseEntity {

	private String title;
	private String description;
	private Integer yearLaunched;
	private Boolean opened;
	private String rating;
	private Float duration;
	private List<Category> categories = new ArrayList<>();
	private List<Genre> genres = new ArrayList<>();
	private List<CastMember> castMembers = new ArrayList<>();

	public Video() {
	}

	public Video(UUID id, String title, String description, Integer yearLaunched, Boolean openend) {
		super.setId(id);
		this.setTitle(title);
		this.setDescription(description);
		this.setYearLaunched(yearLaunched);
		this.setOpened(opened);
	}

	public Video(String title, String description, Integer yearLaunched, Boolean openend) {
		super.generateUUID();
		this.setTitle(title);
		this.setDescription(description);
		this.setYearLaunched(yearLaunched);
		this.setOpened(opened);
	}

	public Video(String title, String description, Integer yearLaunched, Boolean openend, String rating,
			Float duration) {
		super.generateUUID();
		this.setTitle(title);
		this.setDescription(description);
		this.setYearLaunched(yearLaunched);
		this.setOpened(opened);
		this.setRating(rating);
		this.setDuration(duration);
	}

	public Video(String title, String description, Integer yearLaunched, Float duration) {
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
		if (title == null)
			throw new IllegalArgumentException("title is marked as non-null but got null");
		if (title.isEmpty())
			throw new IllegalArgumentException("title is marked as non-blank but got blank");
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
		if (yearLaunched > currentYear)
			throw new IllegalArgumentException("yearLauncher is greater than currentYear");
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

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		if (categories == null)
			throw new IllegalArgumentException("categories is marked as non-null but got null");
		this.categories = categories;
	}

	public void setGenres(List<Genre> genres) {
		if (genres == null)
			throw new IllegalArgumentException("genres is marked as non-null but got null");
		this.genres = genres;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setCastMembers(List<CastMember> castMembers) {
		if (castMembers == null)
			throw new IllegalArgumentException("castMembers is marked as non-null but got null");
		this.castMembers = castMembers;
	}

	public List<CastMember> getCastMembers() {
		return castMembers;
	}

	public void addCategory(Category category){
		if (category == null)
			throw new IllegalArgumentException("category is marked as non-null but got null");
		this.categories.add(category);
	}
	public void addGenre(Genre genre){
		if (genre == null)
			throw new IllegalArgumentException("genre is marked as non-null but got null");
		this.genres.add(genre);
	}
	public void addCastMember(CastMember castMember){
		if (castMember == null)
			throw new IllegalArgumentException("castMember is marked as non-null but got null");
		this.castMembers.add(castMember);
	}

	public void removeCategory(Category category){
		if (category == null)
			throw new IllegalArgumentException("category is marked as non-null but got null");
		this.categories.removeIf(c -> this.categories.contains(category));
	}
	public void removeGenre(Genre genre){
		if (genre == null)
			throw new IllegalArgumentException("genre is marked as non-null but got null");
		this.genres.removeIf(c -> this.genres.contains(genre));
	}
	public void removeCastMember(CastMember castMember){
		if (castMember == null)
			throw new IllegalArgumentException("castMember is marked as non-null but got null");
		this.castMembers.removeIf(c -> this.castMembers.contains(castMember));
	}
}
