package com.nalan.movieapp.ui;


import android.os.Bundle;

import com.nalan.movieapp.R;
import com.nalan.movieapp.base.BaseActivity;
import com.nalan.movieapp.common.NavigationController;

import javax.inject.Inject;

import androidx.fragment.app.Fragment;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends BaseActivity implements HasSupportFragmentInjector {
    @Inject
    NavigationController navigationController;
    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidInjection.inject(this);
        setStatusBarColor(R.color.colorAccent);
        if (savedInstanceState == null) {
            navigationController.navigateToHomeFragment();
        }
    }


    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
}
