package com.video.domain;

public class Video {

    private String url;
    private String title;
    private Tag tags;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Tag getTags() {
        return tags;
    }

    public void setTags(Tag tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Vídeo info: URL = '" + url + "', title = '" + title + "', tags: " + tags;
    }
}
