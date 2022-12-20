package com.example.ass2android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

public class Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_layout);

        Button showGallery;
        showGallery = (Button) findViewById(R.id.button);
        showGallery.setOnClickListener(v -> showGallery.startAnimation(AnimationUtils.loadAnimation(Homepage.this, R.anim.move)));
        showGallery.setOnClickListener(v -> startActivity(new Intent(Homepage.this, Image_Gallery.class)));
        Button uploadpic;
        uploadpic = findViewById(R.id.uploadPic);
        uploadpic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Toast.makeText(Homepage.this, "Coming soon..? ", Toast.LENGTH_SHORT).show();
                uploadpic.startAnimation(AnimationUtils.loadAnimation(Homepage.this, R.anim.shake));}
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                Intent intent = new Intent(this, ThanksActivity.class);
                startActivity(intent);
            case R.id.exit:
                System.exit(0);
            case R.id.editTags:
                Intent i = new Intent(this, MetaDataActivity.class);
                startActivity(i);

            default:
                return super.onOptionsItemSelected(item);
        }

    }


}