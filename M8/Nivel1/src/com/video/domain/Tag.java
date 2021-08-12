package com.video.domain;

import java.util.ArrayList;
import java.util.List;

public class Tag {

    private String name;
    private List<String> tags;

    public Tag(List<String> tags) {
        this.tags = new ArrayList<>();
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return tags.toString();
    }
}
