package com.example.ass2android;


public class ImageModel {

    String imageUrl;
    String name;
    String tags;
    String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImageModel() {
        this.imageUrl = imageUrl;
    }

    public ImageModel(String imageUrl, String name, String tags, String description) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.tags = tags;
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
