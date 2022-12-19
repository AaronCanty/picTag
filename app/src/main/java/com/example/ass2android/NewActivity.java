package com.example.ass2android;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class NewActivity extends AppCompatActivity {

    private Button share;
    private Button download;
    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        ImageView fullImageView = findViewById(R.id.fullImageView);
        Glide.with(NewActivity.this).load(getIntent().getStringExtra("image@#")).into(fullImageView);
        Glide.with(this)
                .load(getIntent().getStringExtra("image@#"))
                .into(fullImageView);
    }
}