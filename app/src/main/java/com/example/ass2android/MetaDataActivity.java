package com.example.ass2android;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MetaDataActivity extends AppCompatActivity {
    DatabaseReference photoDB;
    EditText image;
    EditText name;
    EditText tag;
    EditText description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_metadata);
        image = findViewById(R.id.image);
        name = findViewById(R.id.name);
        tag = findViewById(R.id.tags);
        description = findViewById(R.id.description);
        photoDB = FirebaseDatabase.getInstance().getReference("images");
        findViewById(R.id.add_btn).setOnClickListener(v ->
                addMetaData(image.getText().toString().trim(),
                        name.getText().toString().trim(),
                        tag.getText()
                                .toString()
                                .trim(),
                        description.getText()
                                .toString()
                                .trim()));

        findViewById(R.id.galleryBTN).setOnClickListener(v -> startActivity(new Intent(MetaDataActivity.this, Image_Gallery.class)));

    }

    private void addMetaData(String image, String name, String tags, String description) {
        String id = photoDB.push().getKey();
        ImageModel imageModel = new ImageModel(image, name, tags, description);
        photoDB.child(id).setValue(imageModel);
    }

}