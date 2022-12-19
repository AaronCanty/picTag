package com.example.ass2android;


import androidx.annotation.Keep;

@Keep // when you want to publish your apk to Google play store

public class ImageModel {

    String imageUrl;

    public ImageModel() {
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
