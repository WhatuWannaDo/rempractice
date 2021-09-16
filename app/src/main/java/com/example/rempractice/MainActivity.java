package com.example.rempractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.rempractice.R;
import com.example.rempractice.project.Repos.Repos;

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Repos.init(getApplication());
    }
}
