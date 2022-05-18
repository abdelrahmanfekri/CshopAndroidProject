package com.example.cshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SectionsFragment fragment = new SectionsFragment();

        FragmentManager manger = getSupportFragmentManager();
        manger.beginTransaction().add(R.id.addFragment,fragment);
    }
}