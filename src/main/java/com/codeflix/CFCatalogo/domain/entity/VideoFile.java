package com.codeflix.CFCatalogo.domain.entity;

import java.text.DecimalFormat;

import com.codeflix.CFCatalogo.domain.entity.BaseEntity;

public class VideoFile extends BaseEntity {
    private String title;
    private Float duration;
    private String url;

    private VideoFile() {
    }

    public VideoFile(String title, Float duration, String url) {
        super.generateUUID();
        this.setTitle(title);
        this.setDuration(duration);
        this.setUrl(url);
    }

    public VideoFile(String title, Float duration) {
        super.generateUUID();
        this.setTitle(title);
        this.setDuration(duration);
    }

    public void setTitle(String title) {
        if (title == null)
            throw new IllegalArgumentException("title is marked as non-null but got null");
        if (title.isEmpty())
            throw new IllegalArgumentException("title is marked as non-blank but got blank");
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDuration(Float duration) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        this.duration = Float.valueOf(decimalFormat.format(duration));
    }

    public Float getDuration() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return Float.valueOf(decimalFormat.format(duration));
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
