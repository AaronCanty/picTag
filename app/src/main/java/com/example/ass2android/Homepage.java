package com.example.ass2android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

public class Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_layout);

        Button btn;
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(v -> startActivity(new Intent(Homepage.this, Image_Gallery.class)));


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
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }


}