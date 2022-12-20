package com.example.ass2android;


public class ImageModel {

    String image;
    String name;
    String tags;
    String description;

    public ImageModel(String name, String tags, String description) {
        this.name = name;
        this.tags = tags;
        this.description = description;
    }

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
        this.image = image;
    }

    public ImageModel(String image, String name, String tags, String description) {
        this.image = image;
        this.name = name;
        this.tags = tags;
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
