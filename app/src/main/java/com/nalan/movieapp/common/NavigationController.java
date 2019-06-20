package com.nalan.movieapp.common;

import com.nalan.movieapp.R;
import com.nalan.movieapp.constants.AppConstants;
import com.nalan.movieapp.ui.fragment.HomeMovieFragment;

import androidx.fragment.app.FragmentManager;

public class NavigationController {
    private final int containerId;
    private final FragmentManager fragmentManager;


    public NavigationController(FragmentManager fragmentManager) {
        containerId = R.id.contentFrame;
        this.fragmentManager = fragmentManager;
    }
    public void navigateToHomeFragment() {
        HomeMovieFragment fragment = new HomeMovieFragment();
        fragmentManager.beginTransaction()
                .replace(containerId, fragment, AppConstants.FRAGMENT_TAG.HOME_MOVİE_FRAGMENT)
                .commitAllowingStateLoss();
    }
}
