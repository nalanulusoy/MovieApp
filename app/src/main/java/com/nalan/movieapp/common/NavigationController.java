package com.nalan.movieapp.common;

import com.nalan.movieapp.R;
import com.nalan.movieapp.constants.AppConstants;
import com.nalan.movieapp.ui.MainActivity;
import com.nalan.movieapp.ui.fragment.HomeMovieFragment;

import javax.inject.Inject;

import androidx.fragment.app.FragmentManager;

public class NavigationController {
    private final int containerId;
    private final FragmentManager fragmentManager;

    @Inject
    public NavigationController(MainActivity mainActivity) {
        containerId = R.id.contentFrame;
        this.fragmentManager = mainActivity.getSupportFragmentManager();
    }
    public void navigateToHomeFragment() {
        HomeMovieFragment fragment = new HomeMovieFragment();
        fragmentManager.beginTransaction()
                .replace(containerId, fragment, AppConstants.FRAGMENT_TAG.HOME_MOVİE_FRAGMENT)
                .commitAllowingStateLoss();
    }
}
