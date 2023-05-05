package com.example.ass2android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;


// taken help from https://firebase.google.com/docs/database/android/read-and-write
public class Image_Gallery extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<ImageModel> imageModelArrayList;
    private RecyclerViewAdaptor recyclerViewAdaptor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Image Gallery");
LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerViewAdaptor);

//        recyclerView.setLayoutManager(new GridLayoutManager(Image_Gallery.this, 2));
//        recyclerView.setHasFixedSize(true);


        imageModelArrayList = new ArrayList<>();
        clearAll();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("images");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                clearAll();

                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    ImageModel imageModel = new ImageModel();

                    imageModel.setImage(Objects.requireNonNull(snapshot1.child("image").getValue()).toString());

                    imageModelArrayList.add(imageModel);
                }

                recyclerViewAdaptor = new RecyclerViewAdaptor(getApplicationContext(), imageModelArrayList);
                recyclerView.setAdapter(recyclerViewAdaptor);
                recyclerViewAdaptor.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Image_Gallery.this,
                        "DB Error:" + error.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
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
                Intent intent = new Intent(Image_Gallery.this, ThanksActivity.class);
                startActivity(intent);
            case R.id.exit:
                System.exit(0);
                return true;
            case R.id.editTags:
                Intent in = new Intent(Image_Gallery.this, MetaDataActivity.class);
                startActivity(in);
            default:
                return super.onOptionsItemSelected(item);
        }

    }


    @SuppressLint("NotifyDataSetChanged")
    private void clearAll() {
        if (imageModelArrayList != null) {
            imageModelArrayList.clear();
            if (recyclerViewAdaptor != null) {
                recyclerViewAdaptor.notifyDataSetChanged();
            }
        }
        imageModelArrayList = new ArrayList<>();
    }
}

