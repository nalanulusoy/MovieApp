package com.nalan.movieapp.di;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.nalan.movieapp.MovieApp;
import com.nalan.movieapp.di.component.AppComponent;
import com.nalan.movieapp.di.component.DaggerAppComponent;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import dagger.android.AndroidInjection;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasSupportFragmentInjector;


public class AppInjector {

    private AppInjector() {}

    public static void init(MovieApp movieApp) {


       DaggerAppComponent.builder().application(movieApp)
                .build().inject(movieApp);

        movieApp.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {
                handleActivity(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }

    private static void handleActivity(Activity activity) {
        if (activity instanceof HasSupportFragmentInjector) {
            AndroidInjection.inject(activity);
        }

        if (activity instanceof FragmentActivity) {
            ((FragmentActivity) activity).getSupportFragmentManager()
                    .registerFragmentLifecycleCallbacks(
                            new FragmentManager.FragmentLifecycleCallbacks() {
                                @Override
                                public void onFragmentCreated(FragmentManager fm, Fragment f, Bundle savedInstanceState) {
                                    if(f instanceof Injectable){
                                        AndroidSupportInjection.inject(f);
                                    }
                                }
                            }
                            , true
                    );
        }
    }
}
