package com.example.ass2android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    //step1
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        setContentView(R.layout.main_activity);
//        //step2
//        tabLayout = findViewById(R.id.tablayout);
//
//        //step3  setup the first fragment on start
//        getSupportFragmentManager().beginTransaction()
//                .add(R.id.frameLayout, new MainFragment()).commit();
//
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                //step4 switch positions on tab
//                switch (tab.getPosition()) {
//                    case 0:
//                        getSupportFragmentManager().beginTransaction()
//                                .replace(R.id.frameLayout,
//                                        new MainFragment()).commit();
//                        break;
//                    case 1:
//                        getSupportFragmentManager().beginTransaction()
//                                .replace(R.id.frameLayout,
//                                        new AboutUsFragment()).commit();
//                        break;
//                    case 2:
//                        getSupportFragmentManager().beginTransaction()
//                                .replace(R.id.frameLayout,
//                                        new ContactUsFragment()).commit();
//                        break;
//
//                }
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//
//    }
}}