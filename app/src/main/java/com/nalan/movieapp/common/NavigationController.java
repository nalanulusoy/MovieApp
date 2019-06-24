package com.nalan.movieapp.common;

import com.nalan.movieapp.R;
import com.nalan.movieapp.constants.AppConstants;
import com.nalan.movieapp.ui.MainActivity;
import com.nalan.movieapp.ui.fragment.HomeMovieFragment;
import com.nalan.movieapp.ui.fragment.MovieDetailFragment;

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
                .addToBackStack(AppConstants.FRAGMENT_TAG.HOME_MOVİE_FRAGMENT)
                .commitAllowingStateLoss();
    }


    public void navigateToMovieDetailFragment(String movieId){

        fragmentManager.beginTransaction().replace(containerId,MovieDetailFragment.newInstance(movieId),AppConstants.FRAGMENT_TAG.HOME_DETAİL_FRAGMENT).addToBackStack(AppConstants.FRAGMENT_TAG.HOME_DETAİL_FRAGMENT).commitAllowingStateLoss();

    }



    public void navigateToMovieDetailFragmentBack(){

        fragmentManager.popBackStack(fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount()-1).getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }
}
