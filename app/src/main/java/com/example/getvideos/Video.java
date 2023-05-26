package com.example.getvideos;

public class Video {

    String title;
    String path;



    String thumbnilUri;

    public Video(String title, String path, String thumbnilUri) {
        this.title = title;
        this.path = path;
        this.thumbnilUri = thumbnilUri;
    }

    public String getThumbnilUri() {
        return thumbnilUri;
    }

    public void setThumbnilUri(String thumbnilUri) {
        this.thumbnilUri = thumbnilUri;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
