package com.example.pictag;



import androidx.annotation.Keep;

@Keep // when you want to publish your apk to Google play store

public class ImageModel {

    String tag, description, location;

    public ImageModel(){

    }

    //shortcut is alt+insert

    public ImageModel(String tag, String description, String location) {
        this.tag = tag;
        this.description = description;
        this.location = location;
    }

    public String getTag() {
        return tag;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }
}
