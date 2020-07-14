package com.refactoring.noteorganizerproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        //setAppTheme();
        setAppNavigation();
        //hideKeyBoard();
    }

    private void setAppNavigation() {
        BottomNavigationView navigationView = findViewById(R.id.navigation_view);
    }
}