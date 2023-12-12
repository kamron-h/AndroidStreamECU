package com.example.android_stream_ecu.models;

public class Movie {
    private String title;
    private String thumbnailUrl;
    private String videoUrl;
    private String date;
    private String description;
    private String broadcaster;

    // Default constructor is required for Firebase
    public Movie() {
    }

    // Constructor with fields (excluding broadcaster)
    public Movie(String title, String thumbnailUrl, String videoUrl, String date, String description) {
        this.title = title;
        this.thumbnailUrl = thumbnailUrl;
        this.videoUrl = videoUrl;
        this.date = date;
        this.description = description;
    }

    // Getters and setters for each field
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    Get the description
    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public void setBroadcaster(String broadcaster) {
        this.broadcaster = broadcaster;
    }

    public String getBroadcaster() {
        return broadcaster;
    }
    // Add getters and setters for other fields
}
