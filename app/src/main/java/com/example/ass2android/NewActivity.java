package com.example.ass2android;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

public class NewActivity extends AppCompatActivity {

    private ImageView fullImageView;
    private Button share, download;
    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        fullImageView = findViewById(R.id.fullImageView);

        Glide.with(this).load(getIntent().getStringExtra("image@#"));
    }
}