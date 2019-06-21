package com.nalan.movieapp.di.module;


import com.nalan.movieapp.ui.fragment.HomeMovieFragment;
import com.nalan.movieapp.ui.fragment.MovieDetailFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract HomeMovieFragment contributeMovieFragment();

    @ContributesAndroidInjector
    abstract MovieDetailFragment contributeMovieDetailFragment();
}
