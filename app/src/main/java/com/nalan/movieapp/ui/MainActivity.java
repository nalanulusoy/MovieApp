package com.nalan.movieapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.nalan.movieapp.R;
import com.nalan.movieapp.common.NavigationController;

public class MainActivity extends AppCompatActivity {
NavigationController navigationController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationController=new NavigationController(getSupportFragmentManager());
        if (savedInstanceState == null) {
            navigationController.navigateToHomeFragment();
        }
    }
}
